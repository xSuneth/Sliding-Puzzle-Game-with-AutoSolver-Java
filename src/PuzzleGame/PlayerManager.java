package PuzzleGame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Suneth Chathuranga
 */
import java.io.*;
import java.util.*;

public class PlayerManager {
    private static final int MAX_PLAYERS = 10;
    private List<String> players;

    public PlayerManager() {
        players = new ArrayList<>();
        readFromFile();
    }

    private void readFromFile() {

        // src\PuzzleGame\playerdata\players.txt
        try{
            InputStream inputStream = getClass().getResourceAsStream("/PuzzleGame/playerdata/players.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                players.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        // Sort players based on their score
        players.sort((p1, p2) -> {
            String[] parts1 = p1.split(", ");
            String[] parts2 = p2.split(", ");
            long score1 = parseDuration(parts1[1]);
            long score2 = parseDuration(parts2[1]);
            return Long.compare(score1, score2); // Sort in ascending order (lower time is better)
        });
    }

    private long parseDuration(String duration) {
        String[] parts = duration.split(":");
        long hours = Long.parseLong(parts[0]);
        long minutes = Long.parseLong(parts[1]);
        long seconds = Long.parseLong(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    private void writeToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("players.txt"))) {
            for (String player : players) {
                bw.write(player);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void addPlayer(String playerName, String score) {
        String playerData = playerName + ", " + score;
        int index = Collections.binarySearch(players, playerData, (p1, p2) -> {
            long score1 = parseDuration(p1.split(", ")[1]);
            long score2 = parseDuration(p2.split(", ")[1]);
            return Long.compare(score1, score2); // Sort in ascending order (lower time is better)
        });
        if (index < 0) {
            index = -index - 1; // If not found, get insertion point
        }
        players.add(index, playerData);
        if (players.size() > MAX_PLAYERS) {
            players.remove(MAX_PLAYERS); // Keep only the top 10 players
        }
        writeToFile();
    }

    public List<String> getTopPlayers() {
        return players.subList(0, Math.min(players.size(), MAX_PLAYERS));
    }

    
}

