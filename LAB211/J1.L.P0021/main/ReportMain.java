package main;

import java.util.ArrayList;

import bo.ReportBO;
import constant.Constant;
import entity.Report;
import entity.Student;
import validation.Validation;

public class ReportMain{

    ReportBO action = new ReportBO();

    /**
     * Use to to display student(s) with total Courses of this student
     * 
     * @param list       list about information of student take from input
     * @param listReport list about information of student follow 
     *                   condition report 
     */
    public void report(ArrayList<Student> list, ArrayList<Report> listReport){
        String courseName = Validation.getString(
                                    "Enter your course name you want report: ", 
                                    "Must follow fomat: JAVA, .NET, C/C++", 
                                    "Your course name not valid", 
                                    Constant.CONDITION_COURSE_NAME
        );        
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCourseName().equalsIgnoreCase(courseName)){
                action.add(listReport, list.get(i));
            }
        }
        if(listReport.isEmpty()){
            System.out.println("Dont have information about this course");
        }
        action.checkRepeat(listReport);
        action.display(listReport);
        listReport.clear();   
    }
}