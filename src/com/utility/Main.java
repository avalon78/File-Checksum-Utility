package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    static final int CHUNK_SIZE = 4096;

    public static void main(String[] args) {


        if (args.length == 0) return;

        File file = new File(args[0]);

        if (!file.isFile()) return;


        try (FileInputStream fis = new FileInputStream(file);
             DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("SHA-1"))) {

            byte[] fileBytes = new byte[CHUNK_SIZE];

            while (dis.read(fileBytes, 0, fileBytes.length) != -1) {
                //
            }

            byte[] hash = dis.getMessageDigest().digest();

            StringBuilder hexHash = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                hexHash.append(String.format("%02x", hash[i]));
            }

            System.out.print("CheckSum: " + hexHash);

        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}

