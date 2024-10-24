import Models.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    @Test
    public void EmptyPlayer() {

        Player plr = new Player();
        assertEquals(plr.getBulls(),0);
        assertEquals(plr.getCows(),0);
        assertEquals(plr.getCodesAttempted(),0);
        assertEquals(plr.getCodesDeciphered(),0);
        assertEquals(plr.getUsername(),"");

    }
    @Test
    public void CreatePlayer() {
        Player plr = new Player("Anatolii");
        assertTrue(plr.getCows() == 0);
        assertTrue(plr.getBulls() == 0);
        assertTrue(plr.getCodesAttempted() == 0);
        assertTrue(plr.getCodesDeciphered() == 0);
        assertTrue(plr.getUsername().equals("Anatolii"));


    }
    @Test void loadPlayerCreation(){
        Player plr = new Player("Anatolii",3,5);
        assertTrue(plr.getCows() == 0);
        assertTrue(plr.getBulls() == 0);
        assertTrue(plr.getCodesAttempted() == 3);
        assertTrue(plr.getCodesDeciphered() == 5);
        assertTrue(plr.getUsername().equals("Anatolii"));
    }
    @Test void fullPlayerCreation(){
        Player plr = new Player("Anatolii",2,3,3,5);
        assertTrue(plr.getBulls() == 2);
        assertTrue(plr.getCows() == 3);
        assertTrue(plr.getCodesAttempted() == 3);
        assertTrue(plr.getCodesDeciphered() == 5);
        assertTrue(plr.getUsername().equals("Anatolii"));
    }

    @Test void wrongInfoCreation(){
        Player plr = new Player("",-5,5,-2,-1000);
        assertTrue(plr.getBulls() == 0);
        assertTrue(plr.getCows() == 0);
        assertTrue(plr.getCodesAttempted() == 0);
        assertTrue(plr.getCodesDeciphered() == 0);
        assertTrue(plr.getUsername().equals(""));
    }
    @Test void nullCreation(){
        Player plr = new Player(null,0,0,0,0);
        assertTrue(plr.getBulls() == 0);
        assertTrue(plr.getCows() == 0);
        assertTrue(plr.getCodesAttempted() == 0);
        assertTrue(plr.getCodesDeciphered() == 0);
        assertTrue(plr.getUsername().equals(""));
    }
    @Test void incrementAndUpdate(){
        Player plr = new Player("Anatolii",2,3,3,5);
        assertTrue(plr.getBulls() == 2);
        assertTrue(plr.getCows() == 3);
        assertTrue(plr.getCodesAttempted() == 3);
        assertTrue(plr.getCodesDeciphered() == 5);
        assertTrue(plr.getUsername().equals("Anatolii"));

        plr.incrementCodesAttempted();
        plr.incrementCodesAttempted();

        plr.incrementCodesDeciphered();
        plr.incrementCodesDeciphered();
        plr.incrementCodesDeciphered();

        plr.updateBulls(2);
        assertTrue(plr.getBulls() == 2);
        plr.updateBulls(5);
        assertTrue(plr.getBulls() == 2);

        plr.updateCows(3);
        assertTrue(plr.getCows() == 3);
        plr.updateCows(5);
        assertTrue(plr.getCows() == 3);


        assertTrue(  plr.getCodesAttempted()==5  );
        assertTrue( plr.getCodesDeciphered() == 8 );

    }



}
