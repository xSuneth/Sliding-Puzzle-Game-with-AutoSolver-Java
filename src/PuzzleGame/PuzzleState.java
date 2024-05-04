/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuzzleGame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suneth Chathuranga
 */


public class PuzzleState {
    private int[][] board;
    private int emptyRow;
    private int emptyCol;
    private PuzzleState previousState;
    private int[][] goalState = {
            {1, 2, 3, 4},
            {8, 7, 6, 5},
            {9, 10, 11, 12},
            {0, 15, 14, 13} // Represented by 0
    };

    public PuzzleState(int[][] board, int emptyRow, int emptyCol, PuzzleState previousState) {
        this.board = board;
        this.emptyRow = emptyRow;
        this.emptyCol = emptyCol;
        this.previousState = previousState;
    }

    public boolean isGoalState() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != goalState[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int heuristic() {
        int distance = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int value = board[i][j];
                if (value != 0) { // Skip the empty tile
                    int goalRow = (value - 1) / board.length;
                    int goalCol = (value - 1) % board[0].length;
                    distance += Math.abs(i - goalRow) + Math.abs(j - goalCol);
                }
            }
        }
        return distance;
    }

    public List<PuzzleState> generateSuccessors() {
        List<PuzzleState> successors = new ArrayList<>();

        // Define possible moves (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Generate successor states by swapping the empty tile with its adjacent tiles
        for (int[] dir : directions) {
            int newRow = emptyRow + dir[0];
            int newCol = emptyCol + dir[1];
            if (isValidPosition(newRow, newCol)) {
                int[][] newBoard = cloneBoard(board);
                swapTiles(newBoard, emptyRow, emptyCol, newRow, newCol);
                successors.add(new PuzzleState(newBoard, newRow, newCol, this));
            }
        }

        return successors;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    private int[][] cloneBoard(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, board[i].length);
        }
        return newBoard;
    }

    private void swapTiles(int[][] board, int row1, int col1, int row2, int col2) {
        int temp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = temp;
    }

    public int[][] getBoard() {
        return board;
    }

    public static void printPuzzleState(PuzzleState puzzleState) {
        for (int i = 0; i < puzzleState.board.length; i++) {
            for (int j = 0; j < puzzleState.board[i].length; j++) {
                System.out.print(puzzleState.board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public PuzzleState getPreviousState() {
        return previousState;
    }

}

