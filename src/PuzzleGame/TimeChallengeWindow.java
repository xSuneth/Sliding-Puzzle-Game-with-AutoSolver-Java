/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuzzleGame;

import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 *
 * @author Suneth Chathuranga
 */
public class TimeChallengeWindow extends GameBoard{
    TimeChallengeWindow(JFrame parentWindow) {
        super(parentWindow); // replace someIntValue with the actual value
        initStart();
    }
    
    public void initStart(){
        timeLabel.setText("Remaining Time: 00:30:00");

    }

    public void startTimer() {
        final int[] time = {0, 30, 0}; // seconds, minutes, hours

        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if (!isPaused) {
                timeLabel.setVisible(true);
                timeLabel.setForeground(Color.BLACK);
                time[0]--;

                if (time[0] == -1) {
                    time[0] = 59;
                    time[1]--;
                }
                if (time[1] == -1) {
                    time[1] = 59;
                    time[2]--;
                }

                SwingUtilities.invokeLater(() -> {
                    if (time[2] == 0 && time[1] == 0) {
                        timeLabel.setForeground(Color.RED);
                    } else {
                        timeLabel.setForeground(Color.BLACK); // Reset color if not less than 1 minute
                    }
                    timeLabel.setText(String.format("Remaining Time: %02d:%02d:%02d", time[2], time[1], time[0]));
                });

                if (time[2] == 0 && time[1] == 0 && time[0] == 0) {
                    executor.shutdown();
                }
            }
            else{
                timeLabel.setVisible(!timeLabel.isVisible());
                timeLabel.setForeground(Color.ORANGE);
            }
        }, 0, 1, TimeUnit.SECONDS); // Update every second
    }
        
    }
    
