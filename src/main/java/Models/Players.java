//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Models;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Players {
    private ArrayList<ArrayList<String>> allPlayers = null;
    private List<Player> players1 = new ArrayList<>();
    private String playersFile;

    public Players() {
        this.allPlayers = new ArrayList();
        this.playersFile = "all_players_statistics.txt";
    }
    public List<ArrayList<String>> getTop10Players() {
        // Sort players based on the number of successfully deciphered codes
        Collections.sort(allPlayers, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> player1, ArrayList<String> player2) {
                int codesDeciphered1 = Integer.parseInt(player1.get(4)); // Assuming the 5th element stores codes deciphered
                int codesDeciphered2 = Integer.parseInt(player2.get(4)); // Assuming the 5th element stores codes deciphered
                return Integer.compare(codesDeciphered2, codesDeciphered1); // Descending order
            }
        });
        // Return the top 10 players
        return allPlayers.subList(0, Math.min(10, allPlayers.size()));
    }
    public Players(String fileLocation) {
        this.playersFile = fileLocation;
    }

    public void addPlayer(Player p) {
        // iterate over the allPlayers
        // if the player doesn't exist, add it otherwise update it with new values
        int flag = 0; // change flag to 1 if you find a player in the database
        for (int i = 0; i< allPlayers.size(); i++ ) {
            if (allPlayers.get(i).get(0).equals(p.getUsername()) != true) {
                continue;
            }
            flag = 1;

            allPlayers.get(i).set(1, String.valueOf(p.getCumulativeBulls()));
            allPlayers.get(i).set(2,String.valueOf(p.getCumulativeCows()));
            allPlayers.get(i).set(3, String.valueOf(p.getCodesAttempted()));
            allPlayers.get(i).set(4,String.valueOf(p.getCodesDeciphered()));
            break;
        }
        if(flag == 0){
            ArrayList<String> player = new ArrayList<>();
            player.add(p.getUsername());
            player.add(String.valueOf(p.getCumulativeBulls()));
            player.add(String.valueOf(p.getCumulativeCows()));
            player.add(String.valueOf(p.getCodesAttempted()));
            player.add(String.valueOf(p.getCodesDeciphered()));
//            for (String line : player) {
//                System.out.println(line);
//                         }
            allPlayers.add(player);

        }


    }

    public void loadPlayers() {
        String filename = "player_statistics.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            ArrayList<ArrayList<String>> entities = new ArrayList<>();
            String line;
            ArrayList<String> entity = new ArrayList<>();
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
                String[] value = line.split(" ");
                if (lineCount < 3 && value.length != 2) {
                    System.out.println("Invalid data format in the file.");
                    exit(1);
                }
                if (lineCount >=3 && value.length != 3) {
                    System.out.println("Invalid data format in the file.");
                    exit(1);
                }
                entity.add(value[value.length - 1]);
                lineCount++;

                // Check if we have read 5 lines
                if (lineCount == 5) {
                    entities.add(entity);
                    entity = new ArrayList<>();
                    lineCount = 0; // Reset line count for the next entity
                }

            }

            allPlayers = entities;


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


//        for (ArrayList<String> entity : allPlayers) {
//            for (String line : entity) {
//                System.out.println(line);
//            }
//
//        }
    }
    public void savePlayers(){
        String fileName = "player_statistics.txt"; // Use player name in the file name
            try (FileWriter writer = new FileWriter(fileName, false)) {
                for (int i = 0; i < allPlayers.size(); i++) {
                    writer.write("Player: " + allPlayers.get(i).get(0) + "\n");
                    writer.write("Bulls: " + allPlayers.get(i).get(1) + "\n");
                    writer.write("Cows: " + allPlayers.get(i).get(2) + "\n");
                    writer.write("Codes Attempted: " + allPlayers.get(i).get(3) + "\n");
                    writer.write("Codes Deciphered: " + allPlayers.get(i).get(4) + "\n");
                }
            }catch(IOException e){
                System.out.println("Error saving player statistics to file: " + e.getMessage());
            }
        }

    public void setAllPlayers(ArrayList<ArrayList<String>> allPlayers) {
        this.allPlayers = allPlayers;
    }
    public Player findPlayer(Player p) {
        return new Player();
    }

    public int getAllPlayersBulls() {
        return 0;
    }

    public int getAllPlayersCows() {
        return 0;
    }

    public SecretCode getAllPlayersSecretCodesAttempted() {
        return new SecretCode();
    }

    public SecretCode getAllPlayersSecretCodesDeciphered() {
        return new SecretCode();
    }
}
