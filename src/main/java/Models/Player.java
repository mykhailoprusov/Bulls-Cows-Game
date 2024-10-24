package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class   Player {


    private String username;
    private int numberOfBulls;
    private int numberOfCows;
    private int codesAttempted;
    private int codesDeciphered;

    private int cumulativeBulls;
    private int cumulativeCows;

    public Player(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        username  = scanner.nextLine();
        this.numberOfBulls = 0;
        this.numberOfCows = 0;
        this.codesAttempted  = 0 ;
        this.codesDeciphered = 0;
        this.cumulativeBulls = 0;
        this.cumulativeCows = 0;
    }
    public Player(String username){
        if(username==null)
            this.username = "";
        else
            this.username = username;

        this.numberOfBulls = 0;
        this.numberOfCows = 0;
        this.codesAttempted  = 0 ;
        this.codesDeciphered = 0;
        this.cumulativeBulls = 0;
        this.cumulativeCows = 0;
    }
    public Player(String username,int codesAttempted,int codesDeciphered){
        if(username==null)
            this.username = "";
        else
            this.username = username;

        this.numberOfBulls = 0;
        this.numberOfCows = 0;
        this.cumulativeBulls = 0;
        this.cumulativeCows = 0;
        if(codesAttempted>=0)
            this.codesAttempted  = codesAttempted ;
        else
            this.codesAttempted = 0;
        if(codesDeciphered>=0)
            this.codesDeciphered = codesDeciphered;
        else
            this.codesDeciphered = 0;
    }
    public Player(String username,int numberOfBulls,int numberOfCows,int codesAttempted,int codesDeciphered){
        if(username==null)
            this.username = "";
        else
            this.username = username;

        if(numberOfBulls>=0&&numberOfBulls<=4)
            this.numberOfBulls  = numberOfBulls ;
        else
            this.numberOfBulls = 0;

        if(numberOfCows>=0&&numberOfCows<=4)
            this.numberOfCows = numberOfCows;
        else
            this.numberOfCows = 0;

        if(codesAttempted>=0)
            this.codesAttempted  = codesAttempted ;
        else
            this.codesAttempted = 0;
        if(codesDeciphered>=0)
            this.codesDeciphered = codesDeciphered;
        else
            this.codesDeciphered = 0;
    }


    public void updateBulls(int numberOfBulls) {
        if(numberOfBulls>=0&&numberOfBulls<=4)
            this.numberOfBulls = numberOfBulls;
    }

    public void updateCows(int numberOfCows) {
        if(numberOfCows>=0&&numberOfCows<=4)
            this.numberOfCows = numberOfCows;
    }
    public void updateCumulativeBulls(int bulls) {
        cumulativeBulls += bulls;
    }
    public void updateCumulativeCows(int cows) {
        cumulativeCows += cows;
    }
    public int getCumulativeBulls() {
        return cumulativeBulls;
    }
    public int getCumulativeCows() {
        return cumulativeCows;
    }
    public void incrementCodesAttempted() {
        this.codesAttempted +=1;
    }

    public void incrementCodesDeciphered() {
        this.codesDeciphered +=1;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public int getBulls() {
        return numberOfBulls;
    }

    public int getCows() {
        return numberOfCows;
    }

    public int getCodesAttempted() {
        return codesAttempted;
    }

    public int getCodesDeciphered() {
        return codesDeciphered;
    }

    public void setCumulativeBulls(int fileBulls){
        this.cumulativeBulls = fileBulls;
    }

    public void setCumulativeCows(int fileCows){
        this.cumulativeCows = fileCows;
    }
    public void setCodesAttempted(int fileCodesAttempted){

        this.codesAttempted = fileCodesAttempted;
    }
    public void setCodesDeciphered(int fileCodesDeciphered){
        this.codesDeciphered = fileCodesDeciphered;
    }
    public void loadPlayer(){
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


            int flag = 0; // change flag to 1 if you find a player in the database
            for (ArrayList<String> player : entities) {
                if (player.get(0).equals(username) != true) {
                    continue;
                }
                flag = 1;
                // update the necessary player
                setCumulativeBulls(Integer.parseInt(player.get(1)));
                setCumulativeCows(Integer.parseInt(player.get(2)));
                setCodesAttempted(Integer.parseInt(player.get(3)));
                setCodesDeciphered(Integer.parseInt(player.get(4)));

            }


            if (flag == 0) {
                System.out.println("Couldn't load details. Creating new user account");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.println("Error parsing data: " + e.getMessage());
        }
    }





}
