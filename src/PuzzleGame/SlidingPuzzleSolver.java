/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuzzleGame;

/**
 *
 * @author Suneth Chathuranga
 */


 import java.util.*;


 public class SlidingPuzzleSolver {
    public List<PuzzleState> solvePuzzle(PuzzleState initialState) {
        PriorityQueue<PuzzleState> frontier = new PriorityQueue<>(Comparator.comparingInt(PuzzleState::heuristic));
        Set<PuzzleState> explored = new HashSet<>();

        frontier.add(initialState);

        while (!frontier.isEmpty()) {
            PuzzleState currentState = frontier.poll();
            explored.add(currentState);
            PuzzleState.printPuzzleState(currentState);

            if (currentState.isGoalState()) {
                System.out.println("Solution found!");
                return reconstructPath(currentState);
            }

            for (PuzzleState nextState : currentState.generateSuccessors()) {
                if (!explored.contains(nextState)) {
                    frontier.add(nextState);
                }
            }
        }

        return Collections.emptyList(); // No solution found
    }

    private List<PuzzleState> reconstructPath(PuzzleState currentState) {
        List<PuzzleState> path = new ArrayList<>();
        while (currentState != null) {
            path.add(currentState);
            currentState = currentState.getPreviousState();
        }
        Collections.reverse(path);
        return path;
    }
}