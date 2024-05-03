/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuzzleGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Suneth Chathuranga
 */
public class SlidingPuzzleSolver {
    public List<PuzzleState> solvePuzzle(PuzzleState initialState) {
        PriorityQueue<PuzzleState> frontier = new PriorityQueue<>(Comparator.comparingInt(PuzzleState::heuristic));
        Map<PuzzleState, PuzzleState> cameFrom = new HashMap<>();
        Map<PuzzleState, Integer> gScore = new HashMap<>();

        frontier.add(initialState);
        cameFrom.put(initialState, null);
        gScore.put(initialState, 0);

        while (!frontier.isEmpty()) {
            PuzzleState currentState = frontier.poll();

            if (currentState.isGoalState()) {
                return reconstructPath(cameFrom, currentState);
            }

            for (PuzzleState nextState : currentState.generateSuccessors()) {
                int tentativeGScore = gScore.getOrDefault(currentState, Integer.MAX_VALUE) + 1;

                if (tentativeGScore < gScore.getOrDefault(nextState, Integer.MAX_VALUE)) {
                    cameFrom.put(nextState, currentState);
                    gScore.put(nextState, tentativeGScore);
                    frontier.add(nextState);
                }
            }
        }

        return Collections.emptyList(); // No solution found
    }

    private List<PuzzleState> reconstructPath(Map<PuzzleState, PuzzleState> cameFrom, PuzzleState currentState) {
        List<PuzzleState> path = new ArrayList<>();
        while (currentState != null) {
            path.add(currentState);
            currentState = cameFrom.get(currentState);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // Implement code to create initial puzzle state and call solvePuzzle method
    }
}
