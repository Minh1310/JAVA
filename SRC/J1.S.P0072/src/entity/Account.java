/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

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
        this.password = Validation.getMd5(password);
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
        this.password = Validation.getMd5(password) ;
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
        return "Account{" + "userName=" + userName + ", password=" + password 
                + ", name=" + name + ", phone=" + phone + ", email=" + email 
                + ", address=" + address + ", dateOfBirth=" + dateOfBirth + '}';
    }

    public void input(List<Account> list){
        do{
            this.userName = Validation.getString(
                "Enter user name: ", 
                "Must have a-zA-Z0-9", 
                "Invalid String", 
                Constant.REGEX_USER_NAME);
            if(!exist(list)){
                break;
            }
            System.out.println(Constant.MESSAGE__USER_EXIST);
        } while(true);
        this.password = Validation.getMd5(
            Validation.getString(
                "Enter password: ", 
                "Must have more than 5 character", 
                "Invalid String", 
                Constant.REGEX_PASS_WORD)
        );       
        this.name = Validation.getString(
                "Enter your name: ", 
                "Must have a-zA-Z", 
                "Invalid String", 
                Constant.REGEX_NAME);        
        this.phone = Validation.getString(
                "Enter your phone: ", 
                "Must have 10 or 11 number(0-9)", 
                "Invalid String", 
                Constant.REGEX_PHONE);      
        this.email = Validation.getString(
                "Enter your email: ", 
                "Must follow format", 
                "Invalid String", 
                Constant.REGEX_EMAIL);       
        this.address = Validation.getString(
                "Enter your address: ", 
                "Must have a-zA-Z0-9", 
                "Invalid String", 
                Constant.REGEX_ADDRESS);       
        this.dateOfBirth = Validation.getString(
                "Enter your date of birth", 
                "Must have follow dd/mm/yy", 
                "Invalid String", 
                Constant.REGEX_DATE_OF_BIRTH);
    }

    private boolean exist(List<Account> list){
        return list.stream().anyMatch( ls -> (
            ls.getUserName().equals(this.userName)
        ));
    }

    public void display(){
        System.out.printf("|%5s|%5s|%5s|%5s|%5s|%5s|%5s|",
                        this.userName,this.password,this.name,this.phone,
                        this.email, this.address, this.dateOfBirth
        );
        System.out.println();
    }
}
