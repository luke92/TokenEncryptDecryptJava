import java.net.URLEncoder; 
import java.util.Base64;
import java.util.Date;

import javax.crypto.Cipher; 
import javax.crypto.spec.SecretKeySpec;

public class TokenEncryptApp {
    public static void main(String[] args) throws Exception {
        String cpUrl = "https://content-page.com?token={TOKEN}"; 
        String presharedKey = "NNdV_nt6Vppmsx8G"; 
        String msisdn = "351912345678"; 
        String productId = "1020"; 
        Long timestamp = new Date().getTime(); 
        String tokenDecrypted = msisdn + "#" + productId + "#" + timestamp;

        String encryptionAlgorithm = "AES"; 
        SecretKeySpec keySpecification = new SecretKeySpec(
            presharedKey.getBytes("UTF-8"), 
            encryptionAlgorithm); 
        Cipher cipher = Cipher.getInstance(encryptionAlgorithm); 
        cipher.init (Cipher.ENCRYPT_MODE, keySpecification); 
        byte[] encryptedBytes = cipher.doFinal(tokenDecrypted.getBytes()); 
        String tokenBase64Encoded = Base64.getEncoder().encodeToString(encryptedBytes);

        String tokenUrlEncoded = URLEncoder.encode(tokenBase64Encoded, "UTF-8");

        cpUrl = cpUrl.replace("{TOKEN}", tokenUrlEncoded);

        System.out.println("cpUrl: " + cpUrl);
    }
}