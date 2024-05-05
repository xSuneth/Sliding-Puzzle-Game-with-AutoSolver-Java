# Sliding Puzzle Game with Auto Solver

This is a simple sliding puzzle game, you can play it in three modes:

1. Quickplay (No limits): It will show you the puzzle and you can move the numbers as you like.
2. Play with time limit: You have a time limit to solve the puzzle, it will decrease every second and you will lose if you reach 0.
3. Play with moves limit: You have a moves limit, it will decrease every time you make a move and you will lose if you reach 0.

The game also can save players who win and show up in the top 10 players with marks in the leaderboard.

Screenshots of the program are in the "screenshots" folder.
https://github.com/xSuneth/Puzzle_Game/tree/main/screenshots

# How to Play

1. Download the zip file and extract it.
2. Run the "SlidingPuzzleGame.jar" file.
3. Select the mode you want to play.
4. Start playing the puzzle.

# Technical Details

- The game is built using Java SE 8.
- The game uses the IterativeDeepeningAStar (a better version of the Astar algorithm) algorithm as the solver.
- The game uses the Manhatten heuristic function.

This project wouldn't be possible without the great work of Matija Gojkovic, who wrote the IterativeDeepeningAStar algorithm used in this game. You can check out his GitHub profile at https://github.com/gojkovicmatija99.
