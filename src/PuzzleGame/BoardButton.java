/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuzzleGame;

import javax.swing.JButton;

/**
 *
 * @author Suneth Chathuranga
 */
public class BoardButton extends JButton{
    public int XPosition;
    public int YPosition;
    
    public BoardButton(int x,int y){
        this.XPosition = x;
        this.YPosition = y;
    }
    
}
