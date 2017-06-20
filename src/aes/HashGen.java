package aes;

import java.math.BigInteger;
import java.security.MessageDigest;

public class HashGen {
    public String getHash(String senha, String tipoDeHash) throws Exception { 
       MessageDigest m = MessageDigest.getInstance(tipoDeHash);
       m.update(senha.getBytes(),0,senha.length());
       return(new BigInteger(1,m.digest()).toString(16));  
        }
    }


