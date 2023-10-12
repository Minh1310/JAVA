/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

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
    
}