# Sliding Puzzle Game with Auto Solver

This is a simple sliding puzzle game, you can play it with the three modes:

1. Quick play (No limits): It will show you the puzzle and you can move the numbers as you like.
2. Play with time limit: You have a time limit to solve the puzzle, it will decrease every second and you will lose if you reach 0.
3. Play with moves limit: You have a moves limit, it will decrease every time you make a move and you will lose if you reach 0.

The game also can save players who win and show up the top 10 players with marks in leaderboard.

Screenshots of the program are in the "screenshots" folder.

# How to Play

1. Download the zip file and extract it.
2. Run the "SlidingPuzzleGame.jar" file.
3. Select the mode you want to play.
4. Start playing the puzzle.

# Technical Details

- The game is built using Java SE 8.
- The game uses IterativeDeepeningAStar algorithm as the solver.
- The game uses Manhatten heuristic function.

This project wouldn't be possible without the great work of Matija Gojkovic, who wrote the IterativeDeepeningAStar algorithm used in this game. You can check out his github profile at https://github.com/gojkovicmatija99.
