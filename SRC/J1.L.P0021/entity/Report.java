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
    private String semester;
    private String courseName;
    private int totalOfCourse;

    public Report() {
    }

    public Report(String name, String semester, String courseName, int totalOfCourse) {
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
        this.totalOfCourse = totalOfCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
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

    public void input(Student info) {
        this.name = info.getStudentName();
        this.semester = info.getSemester();
        this.courseName = info.getCourseName();
        this.totalOfCourse = 1;
    }

    public void display() {
        System.out.printf("|%10s |%10s |%10s ", name, courseName, totalOfCourse);
        System.out.println();
    }

}