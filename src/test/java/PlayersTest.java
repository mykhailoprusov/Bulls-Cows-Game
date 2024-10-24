//import Models.Players;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class PlayersTest {
//
//    @Test
//    public void addPlayer(Player p){
//        Player plr = new Player(); // can we add empty players?
//        Player plr1 = new Player("Mykhailo");
//        Player plr2 = new Player("Anatolii",3,5);
//        Player plr3 = new Player("Anatolii",2,3,3,5);
//        Players plrs = new Players();
//        plrs.addPlayer(plr);
//        plrs.addPlayer(plr1);
//        plrs.addPlayer(plr2);
//        plrs.addPlayer(plr3);
//        assertEquals(plrs.findPlayer(plr), plr);
//        assertEquals(plrs.findPlayer(plr1), plr);
//        assertEquals(plrs.findPlayer(plr2), plr);
//        assertEquals(plrs.findPlayer(plr3), plr);
//    }
//    @Test
//    public Player findPlayer(Player p){
//        Player plr = new Player(); // can we add empty players?
//        Player plr1 = new Player("Mykhailo");
//        Player plr2 = new Player("Anatolii",3,5);
//        Player plr3 = new Player("Anatolii",2,3,3,5);
//        Players plrs = new Players();
//        plrs.addPlayer(plr);
//        plrs.addPlayer(plr1);
//        plrs.addPlayer(plr2);
//        plrs.addPlayer(plr3);
//        plrs.savePlayers();
//
//        Players plrs2 = new Players();
//
//        assertEquals(plrs2.findPlayer(plr), plr);
//        assertEquals(plrs2.findPlayer(plr1), plr);
//        assertEquals(plrs2.findPlayer(plr2), plr);
//        assertEquals(plrs2.findPlayer(plr3), plr);
//
//    }
//
//    @Test
//    public int getAllPlayersBullsStored(){
//        Players plrs = new Players("defaultLocation1");
//        Player plr = new Player(); // can we add empty players?
//        Player plr1 = new Player("Mykhailo");
//        Player plr2 = new Player("Anatolii",3,5);
//        Player plr3 = new Player("Anatolii",2,3,3,5);
//
//        plrs.addPlayer(plr);
//        plrs.addPlayer(plr1);
//        plrs.addPlayer(plr2);
//        plrs.addPlayer(plr3);
//
//        plrs.savePlayers();
//
//        Players plrs2 = new Players();
//
//        assertEquals(plrs2.getAllPlayersBulls(), 5);
//
//    }
//
//    @Test
//    public int getAllPlayersBullsNotStored(){
//        Players plrs = new Players("defaultLocation2");
//        Player plr = new Player(); // can we add empty players?
//        Player plr1 = new Player("Mykhailo");
//        Player plr2 = new Player("Anatolii",3,5);
//        Player plr3 = new Player("Anatolii",2,3,3,5);
//
//        plrs.addPlayer(plr);
//        plrs.addPlayer(plr1);
//        plrs.addPlayer(plr2);
//        plrs.addPlayer(plr3);
//
//
//
//
//        assertEquals(plrs.getAllPlayersBulls(), 5);
//
//    }
//
//    @Test
//    public int getAllPlayersCowsStored(){
//        Players plrs = new Players("defaultLocation3");
//        Player plr = new Player(); // can we add empty players?
//        Player plr1 = new Player("Mykhailo");
//        Player plr2 = new Player("Anatolii",3,5);
//        Player plr3 = new Player("Anatolii",2,3,3,5);
//
//        plrs.addPlayer(plr);
//        plrs.addPlayer(plr1);
//        plrs.addPlayer(plr2);
//        plrs.addPlayer(plr3);
//
//        plrs.savePlayers();
//
//        Players plrs2 = new Players();
//
//        assertEquals(plrs2.getAllPlayersCows(), 8);
//    }
//
//    @Test
//    public int getAllPlayersCowsNotStored(){
//        Players plrs = new Players("defaultLocation4");
//        Player plr = new Player(); // can we add empty players?
//        Player plr1 = new Player("Mykhailo");
//        Player plr2 = new Player("Anatolii",3,5);
//        Player plr3 = new Player("Anatolii",2,3,3,5);
//
//        plrs.addPlayer(plr);
//        plrs.addPlayer(plr1);
//        plrs.addPlayer(plr2);
//        plrs.addPlayer(plr3);
//
//
//
//
//        assertEquals(plrs.getAllPlayersCows(), 8);
//
//    }
//
//    @Test
//    public SecretCode getAllPlayersSecretCodesAttemptedNotStored(){ // meaning on the physical disc
//        Players plrs = new Players("defaultLocation5");
//        Player plr = new Player(); // can we add empty players?
//        Player plr1 = new Player("Mykhailo");
//        Player plr2 = new Player("Anatolii",3,5);
//        Player plr3 = new Player("Nick",2,3,3,5);
//
//        plrs.addPlayer(plr);
//        plrs.addPlayer(plr1);
//        plrs.addPlayer(plr2);
//        plrs.addPlayer(plr3);
//
//
//
//
//        assertEquals(plrs.getAllPlayersSecretCodesAttempted(), 3);
//
//    }
//
//    @Test
//    public SecretCode getAllPlayersSecretCodesAttemptedStored(){ // meaning on the physical disc
//        Players plrs = new Players("defaultLocation6");
//        Player plr = new Player(); // can we add empty players?
//        Player plr1 = new Player("Mykhailo");
//        Player plr2 = new Player("Anatolii",3,5);
//        Player plr3 = new Player("Nick",2,3,3,5);
//
//        plrs.addPlayer(plr);
//        plrs.addPlayer(plr1);
//        plrs.addPlayer(plr2);
//        plrs.addPlayer(plr3);
//
//        plrs.savePlayers();
//
//        Players plrs2 = new Players();
//
//        assertEquals(plrs2.getAllPlayersSecretCodesAttempted(), 3);
//
//
//
//
//    }
//
//    @Test
//    public SecretCode getAllPlayersSecretCodesDecipheredStored(){ // meaning on the physical disc
//        Players plrs = new Players("defaultLocation7");
//        Player plr = new Player(); // can we add empty players?
//        Player plr1 = new Player("Mykhailo");
//        Player plr2 = new Player("Anatolii",3,5);
//        Player plr3 = new Player("Mykhailo",2,3,3,5);
//
//
//        plrs.addPlayer(plr);
//        plrs.addPlayer(plr1);
//        plrs.addPlayer(plr2);
//        plrs.addPlayer(plr3);
//
//        plrs.savePlayers();
//
//        Players plrs2 = new Players();
//
//        assertEquals(plrs2.getAllPlayersSecretCodesDeciphered(), 5);
//
//
//
//
//    }
//
//    @Test
//    public SecretCode getAllPlayersSecretCodesDecipheredNotStored(){ // meaning on the physical disc
//        Players plrs = new Players("defaultLocation8");
//        Player plr = new Player(); // can we add empty players?
//        Player plr1 = new Player("Mykhailo");
//        Player plr2 = new Player("Anatolii",3,5);
//        Player plr3 = new Player("Nick",2,3,3,5);
//
//        plrs.addPlayer(plr);
//        plrs.addPlayer(plr1);
//        plrs.addPlayer(plr2);
//        plrs.addPlayer(plr3);
//
//
//
//
//        assertEquals(plrs.getAllPlayersSecretCodesDeciphered(), 5);
//
//    }
//
//
//
//}