import Models.NumbersCode;
import Models.SecretCode;
import com.sun.jdi.Value;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;

public class NumbersCodeTest {


    @Test
    public void testNumbersCodeLength() {

        SecretCode code = new NumbersCode();
        try {
            code.requestSecretCode();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals((code.getCode()+"").length(),  4);

    }
    @Test
    public void testNumbersCodeIsNumeric(){

        SecretCode code = new NumbersCode();

        try {
            code.requestSecretCode();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Assertions.assertTrue(isNumeric(code.getCode()));

    }


    @Test
    public void testValidCode(){
        NumbersCode numbersCode = new NumbersCode();
        Assertions.assertFalse(numbersCode.codeIsValid("12ghf"));
        Assertions.assertTrue(numbersCode.codeIsValid("5372891"));
        Assertions.assertFalse(numbersCode.codeIsValid("bcgjfk"));
    }

    private boolean isNumeric(String code) {
        try {
            Double.parseDouble(code);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
