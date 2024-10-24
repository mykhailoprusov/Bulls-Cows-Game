import Models.LettersCode;
import Models.SecretCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LettersCodeTest {
    SecretCode lettersCode = new LettersCode("letterCode.txt");

    @Test
    public void test_generate_letters()  {
        String generatedCode="";
        try {
            generatedCode= lettersCode.requestSecretCode();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        return;
        }
        System.out.println(generatedCode);
        Assertions.assertEquals(4,generatedCode.length());
        char char1 = generatedCode.charAt(0);
        char char2 = generatedCode.charAt(1);
        char char3 = generatedCode.charAt(2);
        char char4 = generatedCode.charAt(3);

        Assertions.assertTrue(char1 != char2 && char1 != char3 && char1 != char4 && char2 != char3 && char2 != char4 && char3 != char4);
       /* assertThrows(IOException.class, () -> {
            List<String> lines = reader.readFile(invalidFilePath);
        });*/
    }

    @Test
    public void testValidCode(){
        LettersCode lettersCode = new LettersCode("letters");
        Assertions.assertFalse(lettersCode.codeIsValid("cgdwhj134544bchjdk"));
        Assertions.assertFalse(lettersCode.codeIsValid("12345678"));
        Assertions.assertTrue(lettersCode.codeIsValid("bfhjed"));
        Assertions.assertFalse(lettersCode.codeIsValid("nchkds--/"));
    }

}
