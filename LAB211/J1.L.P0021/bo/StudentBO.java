/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import constant.Constant;
import entity.Student;
import java.util.ArrayList;
import validation.Validation;

/**
 *
 * @author Nhat Anh
 */
public class StudentBO {

    /**
     * Use to check student existed in student list
     * 
     * @param list list about information of student take from input
     * @param id is ID of student take from input
     * @return true if ID existed or false if ID not exist
     */
    public  boolean checkIdExist(ArrayList <Student> list,String id){
        boolean exist = false;
        for(Student ls : list){
            if(ls.getId().equalsIgnoreCase(id)){
                exist = true;
                break;
            }
        }
        return exist;   
     }
    
     /**
     * Use to get new student from input
     * 
     * @param list list about information of student take from input
     */
    public void add(ArrayList<Student> list) {
        Student student = new Student();
        student.input();
        if(checkIdExist(list, student.getId())){
                System.out.println("This student exist");
                System.out.println("Please try again");
                return;
            }
        list.add(student);            
    }
    
    /**
     * Use to find student list find by name
     * 
     * @param list list about information of student take from input
     */
    public  ArrayList<Student> listFindByName(ArrayList<Student> list, String name){
        ArrayList<Student> listFind = new ArrayList<>();
        // Loop to get list student find by name
        for (int i = 0; i< list.size(); i++) {
            if (list.get(i).getStudentName().contains(name)) {
                listFind.add(list.get(i));
            }
        }
        if(listFind.isEmpty()){
            System.out.println("Not exist this name");
            return null;
        }
        // Sort by name
        listFind.sort((o1, o2)
                -> o1.getStudentName().compareTo(o2.getStudentName()));
        return listFind;    
    }
    
    
    /**
     * Use to remote information os student have this ID
     * 
     * @param list
     * @param Id
     */
    public void remove(ArrayList<Student> list, int index){
        list.remove(index); 
    }

    /**
     * Use to update about information of student
     * 
     * @param list list about information of student take from input 
     */
    public void update(ArrayList<Student> list, int index){
        boolean check  = true;
        while(check){
            System.out.println("1. update name");
            System.out.println("2. update semester");
            System.out.println("3. update course");
            System.out.println("4. exit");
            int choice = Validation.getInt(
                                   "Enter your choice:",
                                   "Your choice must be 1 to 4!", 
                                   "Number is not valid!", 
                                   1, 4);
            switch(choice){
                case 1:
                    String newName = Validation.getString(
                                        "Enter new student name: ", 
                                        "Your name just have character and digit", 
                                        "Your ID not valid", 
                                        Constant.CONDITION_STUDENT_NAME
                    ); 
                    list.get(index).setStudentName(newName);
                    System.out.println("Update name oki");
                    break;
                case 2: 
                    String semester = Validation.getString(
                                   "Enter new your semester: ", 
                                   "Your semester just have character and digit", 
                                   "Your ID not valid", 
                                   Constant.CONDITION_SEMESTER
                    );
                    list.get(index).setSemester(semester);
                    System.out.println("Update semester oki");
                     break;
                case 3:
                    String courseName = Validation.getString(
                                        "Enter new your course name: ", 
                                        "Must follow fomat: JAVA, .NET, C/C++", 
                                        "Your ID not valid", 
                                        Constant.CONDITION_COURSE_NAME
                    );
                    list.get(index).setCourseName(courseName);
                    System.out.println("Update course name oki");
                    break;
                case 4:
                    check = false;
                    break;
            }
        }    
    }

    /**
     * Use to display information of student
     * 
     * @param list
     */
    public void display(ArrayList<Student> list){
        list.forEach((Student a) -> {a.display();});
    }
}
