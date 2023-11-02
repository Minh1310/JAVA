/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author Nhat Anh
 */
public class Validation {
    
    /**
     * Don't let anyone instantiate this class.
     */
    private Validation() {}
    
    /**
     * 
     * @param messageInfo
     * @param messageErrorOutOfRange
     * @param messageErrorInvalidNumber
     * @param min
     * @param max
     * @return 
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max
    ) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println(messageInfo);
                int number = Integer.parseInt(sc.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);

            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
    
    /**
     * 
     * @param messageInfo
     * @param messageErrorFormat
     * @param messageErrorInvalidString
     * @param REGEX_STRING
     * @return 
     */
    public static String getString(
            String messageInfo,
            String messageErrorFormat,
            String messageErrorInvalidString,
            final String REGEX_STRING
    ) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(messageInfo);
                String texts = scanner.nextLine();
                if (texts.matches(REGEX_STRING)) {
                    return texts;
                }
                System.out.println(messageErrorFormat);

            } catch (NullPointerException e) {
                System.out.println(messageErrorInvalidString);
            }
        } while (true);
    }

    /**
     * Use to hashing algorithm converts data into a string of 32 characters
     * 
     * @param password
     * @return
     */
    public static String getMd5(String password) {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(password.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}