package main;

import java.util.ArrayList;
import entity.*;
import validation.Validation;

public class Main {
    public static void main(String[] args){
        ArrayList<Student> listStudent = new ArrayList<>();
        ArrayList<Report> listReport = new ArrayList<>();
        StudentMain student = new StudentMain();
        ReportMain report = new ReportMain();
        Student x = new Student("HE141753","MINH","Fall","java");
        Student y = new Student("HE151753","TA","Summer","C/C++");
        Student z = new Student("HE161753","TAM","Spring","java");
        listStudent.add(x);
        listStudent.add(y);
        listStudent.add(z);
        listStudent.forEach((Student a) -> {a.display();});
        int choice;
        do{
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            choice = Validation.getInt("Enter your choice:",
                                       "Your choice must be 1 to 5!", 
                                       "Number is not valid!", 
                                       1, 5);
            switch(choice){
                case 1:
                    System.out.println("1");
                    student.getNewStudent(listStudent);
                    break;
                case 2:
                    System.out.println("2");
                    student.listFindByTexts(listStudent);
                    break;
                case 3:
                    System.out.println("3");
                    student.updateOrDelete(listStudent);
                    break;
                case 4:
                    System.out.println("4");
                    report.report(listStudent, listReport);
                    break;
                case 5:
                    System.out.println("5");
                    break;
            }

        } while(choice !=5);

    }
    }

