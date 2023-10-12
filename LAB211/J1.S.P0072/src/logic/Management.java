/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import constant.Constant;
import entity.Account;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import validation.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Management {

    public Management() {
    }
    
    /**
     * Use to hashing algorithm converts data into a string of 32 characters
     * 
     * @param password
     * @return 
     */
    public  String getMd5(String password){
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
    
    /**
     * 
     * @param list
     * @param userName
     * @return 
     */
    private boolean checkUserNameExist(ArrayList<Account> list ,String userName){
        boolean result = false;
        for(Account ls : list){
            if(ls.getUserName().equals(userName)){
                result = true;
                break;
            }
        }
        return result;
    }
    
    /**
     * 
     * @param list 
     */
    public void addUser(ArrayList<Account> list){
        
        String userName;
        do{
        userName = Validation.getString(
                "Enter user name: ", 
                "Must have a-zA-Z0-9", 
                "Invalid String", 
                Constant.REGEX_USER_NAME);
        } while(checkUserNameExist(list,userName));
        
        String password = Validation.getString(
                "Enter password: ", 
                "Must have more than 5 character", 
                "Invalid String", 
                Constant.REGEX_PASS_WORD);
        
        String name = Validation.getString(
                "Enter your name: ", 
                "Must have a-zA-Z", 
                "Invalid String", 
                Constant.REGEX_NAME);
        
        String phone = Validation.getString(
                "Enter your phone: ", 
                "Must have 10 or 11 number(0-9)", 
                "Invalid String", 
                Constant.REGEX_PHONE);
        
        String email = Validation.getString(
                "Enter your email: ", 
                "Must follow format", 
                "Invalid String", 
                Constant.REGEX_EMAIL);
        
        String address = Validation.getString(
                "Enter your address: ", 
                "Must have a-zA-Z0-9", 
                "Invalid String", 
                Constant.REGEX_ADDRESS);
        
        String dateOfBirth = Validation.getString(
                "Enter your date of birth", 
                "Must have follow dd/mm/yy", 
                "Invalid String", 
                Constant.REGEX_DATE_OF_BIRTH);
        
        list.add(new Account(   
                            userName,
                            getMd5(password),
                            name,phone,
                            email,address,
                            dateOfBirth));
    }
    
    /**
     * 
     * @param list 
     */
    public void login(ArrayList<Account> list){
        
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
        System.out.println(getMd5(password));
        // Check login
        boolean checkFail = true;
        for(int i = 0;i<list.size();i++){
            if( list.get(i).getUserName().equals(userName)&&
                list.get(i).getPassword().equals(getMd5(password))    
            ){  
                System.out.println("");
                System.out.println("Welcome " + list.get(i).getUserName());
                System.out.println("");
                checkFail = false;
                // Change password
                String choice = Validation.getString(
                    list.get(i).getName() + 
                    ", Do you want change your password(Y/N)",
                    "Must have a-zA-Z0-9", 
                    "Invalid String", 
                    "^[Y|N]$");
                System.out.println("");
                switch(choice){
                    case "Y":
                        String oldPass = Validation.getString(
                                    "Enter old password: ", 
                                    "Must have a-zA-Z0-9", 
                                    "Invalid String", 
                                    Constant.REGEX_PASS_WORD);
                        if( list.get(i).getPassword().
                            equals(getMd5(oldPass))) 
                        {
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
                            
                            if(newPass.equals(renewPass)){
                                list.get(i).setPassword(getMd5(newPass));
                            }
                            else{
                                System.out.println("Repassword not match "
                                                    + "with new password");
                            }
                        }
                        break;
                    case "N":
                        break;
                }
                break;
            }
        }
        if(checkFail){
            System.out.println("Please check your user name or password");
        }
    }
}
