package Models;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;


public class Game{
    private CodeType codeType;
    static int guessCount;
    private Player currentPlayer;
    private HashMap<String,String> playerGameMapping; // mapping Username -> name of the file where the game is stored
    private SecretCode currentSecretCode;
    private static String path;
    private String prevGuess = "";

    public Game(){

    }
    public Game(Player plr) {
        this.currentPlayer = plr;
        this.codeType = CodeType.letter;
        this.currentSecretCode = null;
        this.playerGameMapping = null;
    }

    public Game(Player plr, String codeType){

        this.currentPlayer = plr;
        this.currentSecretCode =null;
        this.codeType = CodeType.getType(codeType);
        this.playerGameMapping = null;

    }
    private void enterValidGuess(String guess) {
        enterGuess(guess);
        System.out.println("Bulls: " + currentPlayer.getBulls() + ", Cows: " + currentPlayer.getCows());
    }
    private boolean playerHasGuessedCorrectly(String guess) {
        return guess.equals(currentSecretCode);
    }
    public void setPath(String pt){
        path = pt;
    }
    public String getPath(){
        return path;
    }
    public String requestCode() throws Exception {

        switch (codeType){
            case letter :
                currentSecretCode= new LettersCode(path);
                break;
            case number:
                currentSecretCode = new NumbersCode();
                break;

        }

        return currentSecretCode.requestSecretCode();
    }

    public void enterGuess(String guess){
        // this method is where the user guess is interpreted and analyzed
        prevGuess = guess;
        int bullCount = 0;
        int cowCount = 0;
        String secretCode = getCurrentSecretCode();

        if (guess.length() != 4) {
            throw new IllegalArgumentException("\nError: Guess must be exactly 4 characters long");
        }
        for(int i =0;i<guess.length();i++) {
            if(secretCode.charAt(i) == guess.charAt(i)){bullCount++;}
            else{
                for(int j=0; j<guess.length();j++){
                    if(secretCode.charAt(i) == guess.charAt(j)){cowCount++;}
                }
            }
        }
            currentPlayer.updateBulls(bullCount);
            currentPlayer.updateCows(cowCount);
            currentPlayer.updateCumulativeBulls(bullCount);
            currentPlayer.updateCumulativeCows(cowCount);
            guessCount++;
    }

    public String getHint(){

        String code = getCurrentSecretCode();
        ArrayList<Integer> indexBank = new ArrayList<>();
        // stores the positions of wrong guess characters,
        // so that said indexes can be randomly chosen from

       if (currentPlayer.getBulls()==4){return "Come on now, you don't need a hint!";}
        else{
            for(int i =0; i<code.length();i++){
                if(prevGuess.charAt(i)!=code.charAt(i)){
                    indexBank.add(i);

                }
            }
        }
        int random = new Random().nextInt(indexBank.size()); // from zero to hany indexes there are
        return "Try "+code.charAt(indexBank.get(random))+" at position "+(indexBank.get(random)+1)+" of your guess";
    }


    public void undoGuess(int pos, char ltr){

        switch (codeType){
            case letter -> {
                if (!Character.isLetter(ltr)) {
                    System.out.println("The character is not a letter.");
                    return;
                }
            }
            case number -> {
                if (!Character.isDigit(ltr)) {
                    System.out.println("The character is not a digit.");
                    return;
                }
            }
        }

        if(prevGuess.isEmpty())
            return;
        if(pos<0&&pos>4){
            System.out.println("Index for new letter is invalid");
            return;
        }

        char[] charArray = prevGuess.toCharArray();
        charArray[pos] = ltr;
        this.enterGuess(new String(charArray));
    }
   public static int getCount(){

        return guessCount;
    }
    public String getCodeType() {
        return codeType.toString();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public HashMap<String, String> getPlayerGameMapping() {
        return playerGameMapping;
    }

    public String getCurrentSecretCode() {
        return currentSecretCode.getCode();
    }






}