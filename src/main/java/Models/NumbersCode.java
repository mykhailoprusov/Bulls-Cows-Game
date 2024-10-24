package Models;

import java.util.Random;

public class NumbersCode extends SecretCode{


    public NumbersCode() {

    }
    @Override
    public String requestSecretCode(){
            Random rnd = new Random();
            String num = new String();
            num+= rnd.nextInt(1,10)+"";


            for(int i =0;i<3;i++){
                int nu = 0;
                do{
                    nu = rnd.nextInt(0,10);
                }
                while(num.contains(nu+"")); // it goes into a loop while there is a duplicate in a number
                num+=nu;
            }
            super.setCode(num);

            return super.getCode();
        }

    public Boolean codeIsValid(String input) {
        if (input.matches("[0-9]+")) {
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }
}
