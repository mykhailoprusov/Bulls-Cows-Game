package Models;

import javax.annotation.processing.FilerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class LettersCode extends SecretCode{

    public String path;

    public LettersCode(String file) {
        this.path = file;
        System.out.println(path);
    }
    @Override
    public String requestSecretCode() throws Exception {
        System.out.println("LETTER CODE");
        try {
            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Path.of(path));

            super.setCode(lines.get(new Random().nextInt(0,lines.size())));

            return super.getCode();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Boolean codeIsValid(String input) {
        if (input.matches("[a-zA-Z]+")) {
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }



}
