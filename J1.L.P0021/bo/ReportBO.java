

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Report;
import entity.Student;
import java.util.ArrayList;

/**
 *
 * @author Nhat Anh
 */
public class ReportBO {

    /**
     * Use to to display student(s) with total Courses of this student
     * 
     * @param list       list about information of student take from input
     * @param listReport list about information of student follow 
     *                   condition report 
     */
    public void add(ArrayList<Report> listReport, Student student){      
        Report report = new Report();
        report.input(student);
        listReport.add(report);
    }

    /**
     * @param listReport
     */
    public void checkRepeat(ArrayList<Report> listReport){
        int count;
        for(int i =0; i<listReport.size()-1;i++){
            for(int j =i+1;j<listReport.size();j++){
                String name = listReport.get(j).getName();
                if(listReport.get(i).getName().equalsIgnoreCase(name)){
                    String course = listReport.get(j).getCourseName();
                    if(listReport.get(i).getCourseName().equalsIgnoreCase(course)){
                        count = listReport.get(i).getTotalOfCourse();
                        count++;
                        listReport.get(i).setTotalOfCourse(count);
                        listReport.remove(listReport.get(j));
                    }
                }
            }
        }
    }
}
