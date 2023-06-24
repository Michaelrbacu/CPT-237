//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Recursive Directory Search method
//     from: http://stackoverflow.com/questions/2534632/list-all-files-from-a-directory-recursively-with-java
//
// CPT 237
//
// Kim Cannon
// 
// Michael Bacu - CPT 237 - Spring 2023
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DirectoryChecksum {

    public static void main(String[] args) {
        String directoryPath = "H:\\CPT Classes";
        try {
            computeChecksum(directoryPath);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void computeChecksum(String directoryPath) throws NoSuchAlgorithmException, IOException {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path: " + directoryPath);
            return;
        }

        long checksum = 0L;
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                computeChecksum(file.getAbsolutePath());
            } else {
                checksum += computeFileChecksum(file);
            }
        }

        System.out.println("Directory: " + directoryPath);
        System.out.println("Checksum: " + checksum);
    }

    private static long computeFileChecksum(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[8192];
        int read;
        while ((read = fis.read(buffer)) != -1) {
            md.update(buffer, 0, read);
        }

        fis.close();

        byte[] digest = md.digest();
        long checksum = 0L;
        for (byte b : digest) {
            checksum += b & 0xff;
        }

        return checksum;
    }
}
