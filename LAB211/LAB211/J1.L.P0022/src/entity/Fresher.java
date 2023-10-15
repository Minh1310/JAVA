/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constant.Constant;
import validation.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Fresher extends Candidate{
    
    private String graduated;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(String id, String firstName, String lastName, String birthDate, 
                    String address, String phone, String email, int candidateType, 
                    String graduated, String graduationRank, String education) {
        super(id, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.graduated = graduated;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduated() {
        return graduated;
    }

    public void setGraduated(String graduated) {
        this.graduated = graduated;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return super .toString() + " Fresher{" + "graduated=" + graduated + ", graduationRank=" + graduationRank + ", education=" + education + '}';
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("|%7s |%7s |%7s", graduated,graduationRank,education);
    }

    @Override
    public void input() {
        super.input();
        String graduationDate = Validation.getString(
                    "Enter your graduation date: ", 
                    "Must follow fomat email", 
                    "Invalid string", 
                    Constant.REGEX_DATE_OF_BIRTH
        ); 

        String graduationRank = Validation.getString(
                "Enter your graduation rank: ",
                "Must follow: " + Constant.REGEX_GRADUATE_RANK,
                "Invalid string",
                Constant.REGEX_GRADUATE_RANK
        );
        
        String education = Validation.getString(
                    "Enter your education: ", 
                    "Must follow fomat email", 
                    "Invalid string", 
                    Constant.REGEX_NORMAL
        ); 

        this.graduated = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
    
    
    
    
}
