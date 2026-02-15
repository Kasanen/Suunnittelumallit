import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {

    private SecretKey secretKey;

    public EncryptedPrinter(Printer printer) {
        super(printer);
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void print(String message) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            super.print(encryptedText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
