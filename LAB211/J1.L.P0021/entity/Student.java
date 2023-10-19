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
public class Student {
    private String Id;
    private String studentName;
    private String semester;
    private String courseName;

    public Student(String Id, 
                    String studentName, 
                    String semester, 
                    String courseName
    ) {
        this.Id = Id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public Student() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
    
    @Override
    public String toString() {
        return "Students{" + "Id=" + Id + ", studentName=" + studentName + ", semester=" + semester + ", courseName=" + courseName + '}';
    }
    
    /**
     * 
     * @param list
     */
    public void input(){
        this.Id = Validation.getString(
                    "Enter your ID: ", 
                    "Must follow fomat: HE171754", 
                    "Your ID not valid", 
                    Constant.CONDITION_ID
            );
        
        this.studentName = Validation.getString(
                    "Enter student name: ", 
                    "Must follow fomat: Minh", 
                    "Your name not valid", 
                    Constant.CONDITION_STUDENT_NAME
            );
        this.semester = Validation.getString(
                    "Enter your semester: ", 
                    "Must follow fomat just have character and digit", 
                    "Your semester not valid", 
                    Constant.CONDITION_SEMESTER
            );
        this.courseName = Validation.getString(
                    "Enter your course name: ", 
                    "Must follow fomat: JAVA, .NET, C/C++", 
                    "Your course name not valid", 
                    Constant.CONDITION_COURSE_NAME
            );   
    }

    /**
     * Use to display imfomation of student
     */
    public void display(){
        System.out.printf("%10s| %10s| %10s| %10s| ",
                        Id, studentName, semester, courseName
                        );   
        System.out.println();
    }
    
}