package Models;

public enum CodeType {
        letter,
        number;

    public static CodeType getType(String code){
        if(code.toLowerCase().equals("letters")){
            return CodeType.letter;
        }else
            return CodeType.number;
    }
    public String toString(){
        switch (this){

            case letter -> {
                return "letter";
            }
            case number -> {
                return "number";
            }
        }
        return "";
    }
}

