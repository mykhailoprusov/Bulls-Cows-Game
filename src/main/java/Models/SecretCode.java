package Models;

import java.io.IOException;

public class SecretCode {
    private String code="Default implementation";
    public String requestSecretCode() throws Exception {
        return code;
    }

    public String getCode()  {
            return code;
        }

        protected void setCode(String code){
            this.code = code;
        }


}
