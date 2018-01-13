package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Util {
    static final int CHUNK_SIZE = 4096;

    private Util() {
    }

    public static boolean checkValidFileOrPath(String arg) {
        Path path = Paths.get(arg);
        return Files.isRegularFile(path) || Files.isDirectory(path);
    }


    public static String getFileCheckSum(String file) throws IOException, NoSuchAlgorithmException {
        StringBuilder hexHash = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(new File(file));
             DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("SHA-1"))) {

            byte[] fileBytes = new byte[CHUNK_SIZE];

            while (dis.read(fileBytes, 0, fileBytes.length) != -1) {
                //
            }

            byte[] hash = dis.getMessageDigest().digest();


            for (int i = 0; i < hash.length; i++) {
                hexHash.append(String.format("%02x", hash[i]));
            }
        }

        return hexHash.toString();
    }
}

