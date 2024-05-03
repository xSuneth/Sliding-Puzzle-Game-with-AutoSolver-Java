/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuzzleGame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Suneth Chathuranga
 */
public class MoveChallengeWindow extends GameBoard{
    
    MoveChallengeWindow(JFrame parentWindow){
        super(parentWindow); // replace someIntValue with the actual value
        initStart();
      
    }
    
    public void initStart(){
        movesLabel.setText("Remaining Moves: 50");
        currentMoves = 50;
        //  challangeFunctionPanel.setVisible(true);
        //  JLabel remainingMovesLabel = new JLabel();
        //  remainingMovesLabel.setText("Remaining Moves: 10");
        //  challangeFunctionPanel.add(remainingMovesLabel);

    }

    public void setMoveVount(){
        currentMoves--;
        movesLabel.setText("Remaining Moves: "+currentMoves);
    }
}
