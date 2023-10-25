/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import constant.Constant;
import utils.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Account {

    private String userName;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dateOfBirth;

    public Account() {
    }

    public Account(
            String userName, String password,
            String name, String phone,
            String email, String address,
            String dateOfBirth) {
        this.userName = userName;
        this.password = getMd5(password);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = getMd5(password) ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Account{" + "userName=" + userName + ", password=" + password + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address + ", dateOfBirth=" + dateOfBirth + '}';
    }

    public void input(){
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
        String passMd5 = getMd5(password);
        
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
        this.userName = userName;
        this.password = passMd5;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public void display(){
        System.out.printf("|%5s|%5s|%5s|%5s|%5s|%5s|%5s|",
                        userName,password,name,phone,
                        email, address, dateOfBirth
        );
        System.out.println();
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
