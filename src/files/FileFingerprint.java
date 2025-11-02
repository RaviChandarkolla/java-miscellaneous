package files;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileFingerprint {

    // Generate SHA-256 hash of a file
    public static String getFileFingerprint(String filePath) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(filePath);
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        // Read the file data and update digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        }
        fis.close();

        // Convert the hash bytes to hexadecimal string
        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            // Get current working directory path
            String currentDirectory = System.getProperty("user.dir");
            // Print the directory path
            System.out.println("Current working directory: " + currentDirectory);

            String filePath = "./src/files/file.txt";
            String fingerprint = getFileFingerprint(filePath);
            System.out.println("File fingerprint (SHA-256): " + fingerprint);
            // You can store this fingerprint in database to check uniqueness
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}

