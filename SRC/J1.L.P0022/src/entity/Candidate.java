
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constant.Constant;
import utils.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Candidate {
    
    private String id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String address;
    private String phone;
    private String email;
    private int candidateType;

    public Candidate() {
    }

    public Candidate(String id, String firstName, String lastName, 
                     String birthDate, String address, String phone, 
                     String email, int candidateType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        return "Candidate{" + "id=" + id + ", firstName=" + firstName 
                + ", lastName=" + lastName + ", birthDate=" + birthDate 
                + ", address=" + address + ", phone=" + phone + ", email=" + email 
                + ", candidateType=" + candidateType + '}';
    }

    /**
     * Use to get infomation
     */
    public void input() {
        String id = Validation.getString(
                    "Enter your ID: ", 
                    "Must follow fomat " + Constant.REGEX_ID, 
                    "Your ID not valid", 
                    Constant.REGEX_ID
        );
        String firstName = Validation.getString(
                    "Enter your first name: ", 
                    "Must have(a-zA-Z)", 
                    "Invalid string", 
                    Constant.REGEX_NAME
        );
        String lastName = Validation.getString(
                    "Enter your last name: ", 
                    "Must have(a-zA-Z)", 
                    "Invalid string", 
                    Constant.REGEX_NAME
        );
        String birthDate = Validation.getString(
                    "Enter your birth date: ", 
                    "Must follow dd/mm/yy", 
                    "Invalid string", 
                    Constant.REGEX_DATE_OF_BIRTH
        ); 
        String address = Validation.getString(
                    "Enter your address: ", 
                    "Must follow (a-zA-Z0-9)", 
                    "Invalid string", 
                    Constant.REGEX_NORMAL
        );
        String phone = Validation.getString(
                    "Enter your phone: ", 
                    "Must have 10 or 11 number", 
                    "Invalid string", 
                    Constant.REGEX_PHONE
        );
        String email = Validation.getString(
                    "Enter your email: ", 
                    "Must follow fomat email", 
                    "Invalid string", 
                    Constant.REGEX_EMAIL
        ); 
        int type = -1;
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = type;
    }

    /**
     * Use to display information
     */
    public void display() {
        System.out.printf("|%7s |%7s |%7s |%7s |%10s |%7s |%10s |%3s",
                        id,
                        firstName,
                        lastName,
                        birthDate,
                        address,
                        phone,
                        email,
                        candidateType
        );
    }
    
    
}