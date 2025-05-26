# TicTacToe-Java

This is a simple console-based Tic Tac Toe game written in Java. It supports two modes:

**AI vs Human (TicTacToeAIVsHuman.java)**

->In this mode, you play against a computer opponent.

->The human player uses the symbol X.

->The AI uses the symbol O.

->The AI makes random valid moves.

->Includes input validation and error handling.

->A scoreboard is maintained for multiple rounds.

->After each game, you’ll be prompted to play again or quit.

**Human vs Human (TicTacToeHumanVsHuman.java)**

->In this mode, two human players take turns.

Player 1: X

Player 2: O

->Both players enter their moves via console input.

->Validity checks ensure moves are within bounds and not overwriting existing moves.

->Also includes a scoreboard and replay option.


✨ Features

✅ Two Game Modes

AI vs Human (play against the computer)

Human vs Human (two-player mode)

🎯 Input Validation

Prevents invalid coordinates and overwriting existing moves

Handles incorrect input types (e.g., letters instead of numbers)

🔁 Replay Option

After each game, players can choose to play again or exit

📊 Scoreboard

Tracks and displays scores for each player across multiple rounds

🧱 Object-Oriented Design

Organized using classes like TicTacToe, Player, HumanPlayer, and AIPlayer

🖥️ Console-Based UI

Simple and clean interface using command-line input/output

🚫 Draw Detection

Automatically detects when the game ends in a tie
