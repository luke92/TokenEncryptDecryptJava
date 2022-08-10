import java.net.URLDecoder;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class TokenDecryptApp {
    public static void main(String[] args) throws Exception {
        String token = "EPcvxD1BSRJcniKEjv8zhC%2FcJX468qdNmpJNMxo7YPs%3D";
        String presharedKey = "NNdV_nt6Vppmsx8G";
        
        String tokenUrlDecoded = URLDecoder.decode(token, "UTF-8");
        byte[] tokenBase64Encoded = Base64.getDecoder().decode(tokenUrlDecoded);

        String encryptionAlgorithm = "AES";
        SecretKeySpec keySpecification = new SecretKeySpec(
            presharedKey.getBytes("UTF-8"), 
            encryptionAlgorithm);
        Cipher cipher = Cipher.getInstance(encryptionAlgorithm);
        cipher.init(Cipher.DECRYPT_MODE, keySpecification);
        byte[] bytes = cipher.doFinal(tokenBase64Encoded);

        String tokenDecrypted = new String(bytes);

        System.out.println("tokenDecrypted: " + tokenDecrypted);
    }
}
