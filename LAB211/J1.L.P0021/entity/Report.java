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
public class Report {
    
    private String name;
    private String courseName;
    private int totalOfCourse;

    public Report() {
    }

    public Report(String name, String courseName, int totalOfCourse) {
        this.name = name;
        this.courseName = courseName;
        this.totalOfCourse = totalOfCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalOfCourse() {
        return totalOfCourse;
    }

    public void setTotalOfCourse(int totalOfCourse) {
        this.totalOfCourse = totalOfCourse;
    }

    @Override
    public String toString() {
        return  name + " | " + courseName + " | " + totalOfCourse ;
    }

    public void input(Student info){
        this.name = info.getStudentName();
        this.courseName = info.getCourseName();
        this.totalOfCourse = 1;
    }

    public void display(){
        System.out.printf("|%10s |10%s |10%s ", name, courseName, totalOfCourse );
        System.out.println();
    }
    
    
}