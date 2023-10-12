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
public class Experience extends Candidate  {
    
    private int yearOfExp;
    private String proSkill;

    public Experience() {
    }

    public Experience(
        String id, String firstName, 
        String lastName, String birthDate, 
        String address, String phone, String email, 
        int candidateType, int yearOfExp, String proSkill) {
        super(id, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.yearOfExp = yearOfExp;
        this.proSkill = proSkill;
    }

    public int getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(int yearOfExp) {
        this.yearOfExp = yearOfExp;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + "Experience{" + "yearOfExp=" + yearOfExp 
                + ", proSkill=" + proSkill + '}';
    }

    @Override
    public void input() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'input'");
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    
    
    
    
    
    
}
