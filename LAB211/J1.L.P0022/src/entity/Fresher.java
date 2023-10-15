/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
    
    
    
    
}
