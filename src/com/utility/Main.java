package com.utility;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {


    public static void main(String[] args) {

        if (args.length == 0 || args.length > 1) {
            System.out.println("" +
                    "Usage: java -jar fcu.jar  file|directory" +
                    "");
            return;
        }

        if (Util.checkValidFileOrPath(args[0])) {

            //TODO: Add directory support

            String hash = null;
            try {
                hash = Util.getFileCheckSum(args[0]);
            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
                return;
            }

            System.out.print("CheckSum: " + hash);

        } else {
            System.out.print("Error Message : File or directory doesn't exist in the specified path");
        }


    }
}

