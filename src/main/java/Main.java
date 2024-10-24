//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Models.Game;
import Models.Player;
import Models.Players;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int numGuessedCorrectly = 0;
        Scanner sc = new Scanner(System.in);
        Player plr = new Player();
        Game cowsAndBulls = null;
        boolean playAgain = true;
        boolean acceptableInput = false;
        Players players = new Players();
        plr.loadPlayer();
        players.loadPlayers();


        while(true) {
            while(acceptableInput) {
                try {
                    cowsAndBulls.requestCode();
                    System.out.println("Secret code has been generated: ");
                    System.out.println("***** " + cowsAndBulls.getCurrentSecretCode() + " *****");
                } catch (Exception var13) {
                    System.out.println(var13.getMessage());
                }

                do {
                    plr.incrementCodesAttempted();
                    System.out.println("\nNumber of guesses: " + Game.getCount());
                    double bullscowsaccuracy = 0;
                    double accuracyPercentage = 0;

                    if (plr.getBulls() != 0 && Game.getCount() != 0) {
                        bullscowsaccuracy = (double)plr.getCumulativeBulls() / (double)Game.getCount() * 100.0;
                        System.out.println("Guess accuracy (num correct/ attempts): " + bullscowsaccuracy + "%");

                    } else if (Game.getCount() == 0) {
                        System.out.println("Guess percentage accuracy: no guesses");
                    } else {
                        System.out.println("Guess percentage accuracy: 0%");
                    }

                    if (plr.getBulls() != 0 && Game.getCount() != 0) {
                        bullscowsaccuracy = (double)plr.getCumulativeBulls() / (double)plr.getCumulativeCows();
                        accuracyPercentage = bullscowsaccuracy / (double)Game.getCount() * 100.0;
                        System.out.println("Guess accuracy (num correct/num false/ attempts): " + accuracyPercentage + "%");

                    } else if (Game.getCount() == 0) {
                        System.out.println("Guess percentage accuracy: no guesses");
                    } else {
                        System.out.println("Guess percentage accuracy: 0%");
                    }

                    //Guess system
                    System.out.println("\nPlease enter your guess...");
                    try {
                        cowsAndBulls.enterGuess(sc.next());
                        PrintStream var10000 = System.out;
                        int var10001 = plr.getCows();
                        var10000.println("number of Cows " + var10001 + " , number of bulls " + plr.getBulls());
                        ///Hint system
                        System.out.println("\nDo you want a hint?");
                        System.out.println("Enter YES if that is the case");
                        if(sc.next().equalsIgnoreCase("yes")){
                            System.out.println(cowsAndBulls.getHint());}

                    } catch (IllegalArgumentException var12) {
                        System.out.println("\n !!! ERROR: your guess must be 4 characters long,\n being either an English word or an integer \ndepending on what game you have chosen");
                    }
                } while(plr.getBulls() != 4);

                ++numGuessedCorrectly;
                plr.incrementCodesDeciphered();
                displayTop10Players(players);
                System.out.println("number of codes guessed correctly: " + numGuessedCorrectly);
                System.out.println("\nYou have guessed the code!");
                System.out.println("Do your want to play again? input yes or no");
                if (sc.next().equalsIgnoreCase("no")) {

                    players.addPlayer(plr);
                    players.savePlayers();
                    //plr.saveStatisticsToFile();
                    System.out.println("\nPlayer Statistics:");
                    System.out.println("Player: " + plr.getUsername());
                    System.out.println("Bulls: " + plr.getBulls());
                    System.out.println("Cows: " + plr.getCows());
                    System.out.println("Attempted: " + plr.getCodesAttempted());
                    System.out.println("Deciphered: " + plr.getCodesDeciphered());
                    System.out.println("Total bulls: " + plr.getCumulativeBulls());
                    System.out.println("Total cows: " + plr.getCumulativeCows());
                    playAgain = false;
                }

                if (!playAgain) {
                    return;
                }
            }

            System.out.println("\n*** Cows and Bulls ***");
            System.out.println("\nEnter either 1 or 2 for the following options");
            System.out.println("\n1. I want to decipher a numbers based code");
            System.out.println("2. I want to decipher a letters based code");

            try {
                int input = sc.nextInt();
                if (input == 1) {
                    cowsAndBulls = new Game(plr, "numbers");
                    acceptableInput = true;
                } else if (input == 2) {
                    cowsAndBulls = new Game(plr, "letters");
                    acceptableInput = true;
                } else {
                    System.out.println("Invalid input, input explicitly either 1 or 2");
                }
            } catch (InputMismatchException var14) {
                System.out.println("!!! please enter an integer, either 1 or 2");
                sc.next();
            }
        }
    }
    private static void displayTop10Players(Players players) {
        List<ArrayList<String>> top10Players = players.getTop10Players();
        System.out.println("\nTop 10 Players:");
        for (int i = 0; i < top10Players.size(); i++) {
            ArrayList<String> playerData = top10Players.get(i);
            String username = playerData.get(0);
            String codesDeciphered = playerData.get(4); // Assuming the 5th element stores codes deciphered
            System.out.println((i + 1) + ". " + username + " - Codes Deciphered: " + codesDeciphered);
        }}
}
