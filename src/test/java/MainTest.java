import Models.LettersCode;
import Models.SecretCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Models.Players;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class MainTest {




    @Test
    public void testTop10Players() {
        // Create sample player data
        ArrayList<ArrayList<String>> samplePlayerData = createSamplePlayerData();

        // Create a mock Players object
        Players players = new Players();
        players.setAllPlayers(samplePlayerData);

        // Call getTop10Players() method to retrieve the top 10 players
        List<ArrayList<String>> top10Players = players.getTop10Players();

        // Define expected top 10 players based on the sample data
        List<ArrayList<String>> expectedTop10Players = Arrays.asList(
                new ArrayList<>(Arrays.asList("Player1", "10", "20", "30", "40")),
                new ArrayList<>(Arrays.asList("Player2", "8", "15", "25", "35")),
                new ArrayList<>(Arrays.asList("Player3", "6", "10", "20", "30")),
                new ArrayList<>(Arrays.asList("Player4", "5", "8", "15", "25")),
                new ArrayList<>(Arrays.asList("Player5", "4", "5", "10", "20")),
                new ArrayList<>(Arrays.asList("Player6", "3", "3", "8", "15")),
                new ArrayList<>(Arrays.asList("Player7", "2", "2", "5", "10"))

        );

        // Assert that the retrieved top 10 players match the expected results
        assertEquals(expectedTop10Players, top10Players);
    }

    private ArrayList<ArrayList<String>> createSamplePlayerData() {
        ArrayList<ArrayList<String>> playerData = new ArrayList<>();
        playerData.add(new ArrayList<>(Arrays.asList("Player1", "10", "20", "30", "40")));
        playerData.add(new ArrayList<>(Arrays.asList("Player2", "8", "15", "25", "35")));
        playerData.add(new ArrayList<>(Arrays.asList("Player3", "6", "10", "20", "30")));
        playerData.add(new ArrayList<>(Arrays.asList("Player4", "5", "8", "15", "25")));
        playerData.add(new ArrayList<>(Arrays.asList("Player5", "4", "5", "10", "20")));
        playerData.add(new ArrayList<>(Arrays.asList("Player6", "3", "3", "8", "15")));
        playerData.add(new ArrayList<>(Arrays.asList("Player7", "2", "2", "5", "10")));
        return playerData;
    }
    @Test
    public void testGuessAccuracies() {
        // Sample data
        int totalGuesses = 10;
        int correctBulls = 6;
        int correctCows = 2;

        // Calculate guess accuracies
        double accuracyPercentage = (double) (correctBulls + correctCows) / totalGuesses * 100;
        double bullscowsaccuracy = (double) (correctBulls + correctCows) / (correctBulls + correctCows + (totalGuesses - correctBulls - correctCows)) * 100;

        // Expected values
        double expectedAccuracyPercentage = 80.0; // (6 + 2) / 10 * 100 = 80
        double expectedBullscowsAccuracy = 66.66666666666666; // (6 + 2) / (6 + 2 + (10 - 6 - 2)) * 100 = 66.67

        // Assert that the calculated accuracies match the expected values
        assertEquals(expectedAccuracyPercentage, accuracyPercentage, 0.01); // 0.01 tolerance for double comparison
        assertEquals(expectedBullscowsAccuracy, bullscowsaccuracy, 0.01);
    }
}
