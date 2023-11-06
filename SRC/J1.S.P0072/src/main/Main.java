/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.AccountBO;
import constant.Constant;
import utils.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Main {

    public static void main(String[] args) {
        AccountBO accountBO = new AccountBO();
        //
        // list.add(new Account(
        // "truong",
        // "truong310",
        // "truong handsome",
        // "1234567890",
        // "truong@fpt.edu.vn",
        // "FPT",
        // "12/12/2003"
        // ));

        int choice;
        do {
            System.out.println("1. Add user");
            System.out.println("2. Login");
            System.out.println("3. Exist");
            choice = Validation.getInt(
                    "Enter your choice",
                    "Out of range!",
                    "Invalid number",
                    1, 3);
            switch (choice) {
                case 1:
                    accountBO.display();
                    System.out.println(accountBO.add() ? "okilalal" : "huhuh");
                    System.out.println("--------");
                    accountBO.display();
                    System.out.println("--------");
                    break;
                case 2:
                    String userName = Validation.getString(
                            "Enter user name: ",
                            "Must have a-zA-Z0-9",
                            "Invalid String",
                            Constant.REGEX_USER_NAME);

                    String password = Validation.getString(
                            "Enter password: ",
                            "Must have more than 5 character",
                            "Invalid String",
                            Constant.REGEX_PASS_WORD);
                    int k = accountBO.login(userName, password);
                    System.out.println("--------");
                    if (k >= 0) {
                        int choice2 = Validation.getInt(
                                accountBO.getList().get(k).getName() +
                                        ", Do you want change your password(Y-1/N-2)",
                                "Must from 1-2",
                                "Invalid number",
                                1, 2);
                        System.out.println("");
                        if (choice2 == 1) {
                            do {
                                String oldPass = Validation.getString(
                                        "Enter old password: ",
                                        "Must have a-zA-Z0-9",
                                        "Invalid String",
                                        Constant.REGEX_PASS_WORD);
                                if (accountBO.checkPassword(k, oldPass)) {
                                    break;
                                }
                                System.out.println(Constant.MESSAGE_WRONG_PASSWORD);
                            } while (true);
                            do {
                                String newPass = Validation.getString(
                                        "Enter new password: ",
                                        "Must have a-zA-Z0-9",
                                        "Invalid String",
                                        Constant.REGEX_PASS_WORD);
                                String renewPass = Validation.getString(
                                        "Enter renew password: ",
                                        "Must have a-zA-Z0-9",
                                        "Invalid String",
                                        Constant.REGEX_PASS_WORD);
                                if (accountBO.setPassword(k, newPass, renewPass)) {
                                    System.out.println("Update successful");
                                    break;
                                }
                                System.out.println(Constant.MESSAGE_NEW_PASSWORD_NOT_MATCH);
                            } while (true);
                        }
                    } else {
                        System.out.println("Login fail");
                    }
                    accountBO.display();
                    break;
                case 3:
                    System.out.println("have a nice day");
                    System.out.println("--------");
                    accountBO.display();
                    break;
            }
        } while (choice != 4);
    }
}
