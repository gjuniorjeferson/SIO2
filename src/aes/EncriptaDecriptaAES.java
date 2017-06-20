/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;
/**
 *
 * @author Jeferson
 */  
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
 
public class EncriptaDecriptaAES { 
     
     
    public static String encriptar(String senha, String textoNormal) {
        try {
            IvParameterSpec iv = new IvParameterSpec("jefersonguerrajr".getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(senha.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(textoNormal.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
     
    /*
       O metodo abaixo Recebe a String key contendo a senha e o texto encriptado e retorna o texto normal 
    */
     
    public static String decriptar(String senha, String textoEncriptado) {
        try {
            IvParameterSpec iv = new IvParameterSpec("jefersonguerrajr".getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(senha.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(textoEncriptado));
            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
     
    //metodo main pra testar 
    public static void main(String[] aes){
         
        String textoNormal = "Este é o texto normal", senha = "1234567890abcdef"; 
         
        System.out.println(textoNormal + " senha usada pra esconder o texto: " + senha);
        String textoSecreto = encriptar(senha, textoNormal);
        System.out.println("Texto criptografado: " + textoSecreto);
         
        String textoDecriptado = decriptar(senha, textoSecreto);
         
        System.out.println("Texto descriptografado: " + textoDecriptado);
         
    }
}
    

