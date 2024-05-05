/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuzzleGame;


import javax.swing.JFrame;


/**
 *
 * @author Suneth Chathuranga
 */
public class MoveChallengeWindow extends GameBoard{
    
    MoveChallengeWindow(JFrame parentWindow, String playerName) {
        super(parentWindow, playerName); // replace someIntValue with the actual value
        initStart();
      
    }
    
    public void initStart(){
        movesLabel.setText("Remaining Moves: 250");
        currentMoves = 250;
        //  challangeFunctionPanel.setVisible(true);
        //  JLabel remainingMovesLabel = new JLabel();
        //  remainingMovesLabel.setText("Remaining Moves: 10");
        //  challangeFunctionPanel.add(remainingMovesLabel);

    }

    public void setMoveVount(){
        currentMoves--;
        movesLabel.setText("Remaining Moves: "+currentMoves);
        if (currentMoves==0) showGameOverDialog();
    }
}
