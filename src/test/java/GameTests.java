import Models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests{
    @Test
    public void CreateGameWithPlayerObj(){
        Player plr = new Player();
        Game game1 = new Game(plr);
        Assertions.assertEquals(game1.getCodeType(), "letter");
        Assertions.assertEquals(game1.getCurrentPlayer(), plr);
//        Assertions.assertNull(game1.getPlayerGameMapping()); game mapping is not implemented yet
    }
    @Test
    public void CreateGameWithPlayerAndCodeTypeLetters(){
        Player plr = new Player();
        Game game1 = new Game(plr, "letter");
        Assertions.assertEquals(game1.getCodeType(), "letter");
        Assertions.assertEquals(game1.getCurrentPlayer(), plr);
        Assertions.assertTrue("letter".equals(game1.getCodeType()));
    }

    @Test
    public void CreateGameWithPlayerAndCodeTypeNumbers(){
        Player plr = new Player();
        Game game1 = new Game(plr, "number");
        Assertions.assertEquals(game1.getCodeType(), "number");
        Assertions.assertEquals(game1.getCurrentPlayer(), plr);
        try {
            Assertions.assertNotNull(game1.requestCode());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void GameNumbersRequestCode(){
        Player plr = new Player();
        Game game1 = new Game(plr, "number");
        Assertions.assertEquals(game1.getCodeType(), "number");
        Assertions.assertEquals(game1.getCurrentPlayer(), plr);
            String scode = "";
    try {
         scode = game1.requestCode();
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
        Assertions.assertNotNull(scode);
        Assertions.assertNotEquals("", scode);


        Assertions.assertEquals(scode, game1.getCurrentSecretCode()); // check if the requested code matches stored in the game class

    }

    @Test
    public void GameLettersRequestCode(){
        Player plr = new Player();
        Game game1 = new Game(plr, "letter");
        game1.setPath("letterCode.txt");
        Assertions.assertEquals(game1.getCodeType(), "letter");
        Assertions.assertEquals(game1.getCurrentPlayer(), plr);
        String scode = "";
        try {
            scode = game1.requestCode();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assertions.assertNotNull(scode);
        Assertions.assertNotEquals("", scode);
        Assertions.assertEquals(scode, game1.getCurrentSecretCode()); // check if the requested code matches stored in the game class

    }

    @Test
    public void GameLetterRequestCodeNoFile(){
        Player plr = new Player();
        Game game1 = new Game(plr, "letter");
        System.out.println(game1.getPath());
        Assertions.assertEquals(game1.getCodeType(), "letter");
        Assertions.assertEquals(game1.getCurrentPlayer(), plr);

            assertThrows(Exception.class, () -> {
                 game1.requestCode();
            });

        Assertions.assertEquals(new SecretCode().getCode(), game1.getCurrentSecretCode()); // check if the requested code matches stored in the game class

    }

    @Test
    public void GameUndoGuessBeforeAnyGuesses() throws Exception {

        Player plr = new Player();
        Game game1 = new Game(plr, "letter");
        game1.setPath("letterCode.txt");
        try {
            game1.requestCode();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        game1.undoGuess(1,'a');
        Assertions.assertEquals(0,plr.getCodesAttempted());

    }
    @Test
    public void GameUndoInvalidChars() throws Exception {

        Player plr = new Player();
        Game game1 = new Game(plr, "letter");
        game1.setPath("letterCode.txt");
        try {
            game1.requestCode();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        game1.undoGuess(1,'2');
        Assertions.assertEquals(0,plr.getCodesAttempted());

    }
    @Test
    public void GameUndoInvalidPos() throws Exception {

        Player plr = new Player();
        Game game1 = new Game(plr, "number");
        try {
            game1.requestCode();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        game1.undoGuess(-1,'a');
        Assertions.assertEquals(0,plr.getCodesAttempted());

    }

    //win
    @Test
    public void testWin()  {
        Player plr = new Player();
        Game game1 = new Game(plr, "letter");
        game1.setPath("letterCode.txt");
        Assertions.assertEquals(game1.getCodeType(), "letter");
        Assertions.assertEquals(game1.getCurrentPlayer(), plr);
        String scode = "";
        try {
            scode = game1.requestCode();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assertions.assertNotEquals("", scode);

            game1.enterGuess(scode);

        Assertions.assertEquals(game1.getCurrentPlayer().getBulls(), 4);
    }

    //invalid

    @Test
    public void testInvalidLength()  {
        Player plr = new Player();
        Game game1 = new Game(plr, "letter");
        game1.setPath("letterCode.txt");
        Assertions.assertEquals(game1.getCodeType(), "letter");
        Assertions.assertEquals(game1.getCurrentPlayer(), plr);
        String scode = "";
        try {
            scode = game1.requestCode();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assertions.assertNotEquals("", scode);

       assertThrows(IllegalArgumentException.class, () -> {
            game1.enterGuess("abcde");
        });


        Assertions.assertEquals(scode, game1.getCurrentSecretCode()); // check if the requested code matches stored in the game class

    }
}