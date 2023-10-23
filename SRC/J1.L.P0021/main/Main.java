package main;

import java.util.ArrayList;
import java.util.List;
import bo.ReportBO;
import bo.StudentBO;
import constant.Constant;
import entity.Report;
import entity.Student;
import utils.Validation;

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        List<Report> listReports = new ArrayList<>();
        StudentBO studentBO = new StudentBO(list);
        ReportBO reportBO = new ReportBO(listReports);
        list.add(new Student("HE171754", "A", "Summer", "java"));
        list.add(new Student("HE171754", "A", "Fall", "java"));
        list.add(new Student("HE171755", "B", "Summer", "c/c++"));
        list.add(new Student("HE171755", "B", "Fall", "c/c++"));
        list.add(new Student("HE171754", "A", "Spring", "java"));
        System.out.println("----------------");
    
        int choice;
        do {
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            choice = Validation.getInt("Enter your choice:",
                    "Your choice must be 1 to 5!",
                    "Number is not valid!",
                    1, 5);
            switch (choice) {
                case 1:
                    System.out.println("1");
                    int count = 0;
                    int choice1 = 0;
                    do {
                        System.out.println(studentBO.add() ? "success" : "fail");
                        count++;
                        if (count == 1) {
                            System.out.println("Do you want continue add?");
                            System.out.println("1. Continue");
                            System.out.println("2. Exit");
                            choice1 = Validation.getInt(
                                    "Enter your choice: ",
                                    "Out of range",
                                    "Invalid",
                                    1, 2);
                            switch (choice) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                            }
                        }
                    } while (choice1 != 2);
                    studentBO.display();
                    break;
                case 2:
                    System.out.println("2");
                    String text = Validation.getString(
                            "Enter text: ",
                            "Must follow fomat: Minh",
                            "Your name not valid",
                            Constant.CONDITION_STUDENT_NAME);
                    studentBO.display(studentBO.search(text));
                    break;
                case 3:
                    System.out.println("3");
                    int choice3 = 0;
                    String id = Validation.getString(
                            "Enter your ID: ",
                            "Must follow fomat: HE171754",
                            "Your ID not valid",
                            Constant.CONDITION_ID);
                    System.out.println("1. Update");
                    System.out.println("2. Delete");
                    choice3 = Validation.getInt(
                            "Enter your choice:",
                            "Your choice must be 1 to 5!",
                            "Number is not valid!",
                            1, 3);
                    switch (choice3) {
                        case 1:
                            System.out.println(studentBO.update(id) ? "Update success" : "fail");
                            break;
                        case 2:
                            System.out.println(studentBO.remove(id) ? "Remove success" : "fail");
                            break;
                    }
                    studentBO.display();
                    break;
                case 4:
                    System.out.println("4");
                    String courseName = Validation.getString(
                            "Enter your course name: ",
                            "Must follow fomat: JAVA, .NET, C/C++",
                            "Your course name not valid",
                            Constant.CONDITION_COURSE_NAME);
                    reportBO.add(studentBO.getList(), courseName);
                    reportBO.checkRepeat();
                    reportBO.display();
                    reportBO.clear();
                    break;
                case 5:
                    System.out.println("5");
                    break;
            }
        } while (choice != 5);

    }
}
