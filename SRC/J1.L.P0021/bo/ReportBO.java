
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Report;
import entity.Student;
import java.util.List;

/**
 *
 * @author Nhat Anh
 */
public class ReportBO {

    private List<Report> listReports;

    public ReportBO(List<Report> listReports) {
        this.listReports = listReports;
    }

    public ReportBO() {
    }

    public List<Report> getListReports() {
        return listReports;
    }

    public void setListReports(List<Report> listReports) {
        this.listReports = listReports;
    }

    /**
     * Use to to display student(s) with total Courses of this student
     * 
     * @param list       list about information of student take from input
     * @param listReport list about information of student follow
     *                   condition report
     */
    public boolean add(List<Student> list, String courseName) {
        for (Student ls : list) {
            if(ls.getCourseName().equalsIgnoreCase(courseName)){
                Report report = new Report();
                report.input(ls);
                listReports.add(report);
            }
        }
        return true;
    }

    public void clear(){
        listReports.clear();
    }

    /**
     * Use to check repeat
     */
    public void checkRepeat() {
        int count;
        for (int i = 0; i < listReports.size() - 1; i++) {
            for (int j = i + 1; j < listReports.size(); j++) {
                String name = listReports.get(j).getName();
                String course = listReports.get(j).getCourseName();
                String semester = listReports.get(j).getSemester();
                if (
                    listReports.get(i).getName().equalsIgnoreCase(name) &&
                    listReports.get(i).getCourseName().equalsIgnoreCase(course) &&
                    !listReports.get(i).getSemester().equalsIgnoreCase(semester)
                ) {
                    count = listReports.get(i).getTotalOfCourse();
                    count++;
                    listReports.get(i).setTotalOfCourse(count);
                    listReports.remove(listReports.get(j));
                }
            }
        }
    }

    /**
     * 
     */
    public void display() {
        if(listReports.isEmpty()){
            System.out.println("Empty");
        }
        listReports.forEach(a -> {
            a.display();
        });
    }
}
