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
class PuzzleState {
    private Integer[][] board;
    private int emptyRow, emptyCol;
    Integer [][]solutionArray = {
        {1, 2, 3, 4},
        {8, 7, 6, 5},
        {9, 10, 11, 12},
        {null, 15, 14, 13},
        };

    public PuzzleState(Integer[][] board, int emptyRow, int emptyCol) {
        this.board = board;
        this.emptyRow = emptyRow;
        this.emptyCol = emptyCol;
    }

    public Integer[][] getBoard(){
        return board;
    }

    // Check if this state is the goal state
    public boolean isGoalState() {


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j] != solutionArray[i][j]) return false;
            }
        }
        return true;
    }


    // Implement your heuristic function here
    public int heuristic() {
        int distance = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int value = board[i][j];
                if (value != 0) { // Skip the empty tile
                    int goalRow = (value - 1) / board.length;
                    int goalCol = (value - 1) % board.length;
                    distance += Math.abs(i - goalRow) + Math.abs(j - goalCol);
                    }
                }
            }
        return distance;
    }

    // Generate possible successor states
    public List<PuzzleState> generateSuccessors() {
        List<PuzzleState> successors = new ArrayList<>();
    
        // Find the current position of the empty tile
        int emptyRow = -1;
        int emptyCol = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    emptyRow = i;
                    emptyCol = j;
                    break;
                }
            }
        }
    
        // Define possible moves (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
        // Generate successor states by swapping the empty tile with its adjacent tiles
        for (int[] dir : directions) {
            int newRow = emptyRow + dir[0];
            int newCol = emptyCol + dir[1];
            if (isValidPosition(newRow, newCol)) {
                Integer[][] newBoard = cloneBoard(board);
                swapTiles(newBoard, emptyRow, emptyCol, newRow, newCol);
                successors.add(new PuzzleState(newBoard, newRow, newCol));
            }
        }
    
        return successors;
    }
    
    // Helper method to check if a position is valid within the puzzle board
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
    }
    
    // Helper method to clone the puzzle board
    private Integer[][] cloneBoard(Integer[][] board) {
        Integer[][] newBoard = new Integer[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, board[i].length);
        }
        return newBoard;
    }
    
    // Helper method to swap two tiles in the puzzle board
    private void swapTiles(Integer[][] board, int row1, int col1, int row2, int col2) {
        int temp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = temp;
    }
    
}
