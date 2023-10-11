package main;

import java.util.ArrayList;

import bo.StudentBO;
import constant.Constant;
import entity.Student;
import validation.Validation;

public class StudentMain{
    StudentBO action = new StudentBO();
    /**
     * Use to get new student from input
     * 
     * @param list list about information of student take from input
     */
    public void getNewStudent(ArrayList<Student> list) {
        int count =0;
        boolean loop = true;
        do{
            action.add(list);
            count++;
            int choice;
            if(count == 1){
                System.out.println("Do you want continue add?");
                System.out.println("1. Continue");
                System.out.println("2. Exit");
                choice = Validation.getInt(
                        "Enter your choice: ", 
                        "Out of range", "Invalid", 
                        1, 2);
                switch(choice){
                    case 1:
                        loop = true;
                        break;
                    case 2:
                        loop = false;
                        break;
                }
            }         
        } while(loop);   
        list.forEach((Student a) -> {a.display();});
    }
    
    /**
     * Use to find student list find by name
     * 
     * @param list list about information of student take from input
     * @return
     */
    public ArrayList<Student> listFindByName(ArrayList<Student> list){
        ArrayList<Student> listFind = new ArrayList<>();
        String name = Validation.getString(
                    "Enter student name: ", 
                    "Must follow fomat: HE171754", 
                    "Your ID not valid", 
                    "^[a-zA-Z]{1,}$");
        if(list.isEmpty()){
            System.out.println("List is empty");
            return null;
        }
        return action.listFindByName(listFind, name);         
    }
    
    /**
     * Use to update or delete information of student 
     * 
     * @param list list about information of student take from input
     */
    public void updateOrDelete(ArrayList<Student> list){
        int choice;
        String Id = Validation.getString(
                    "Enter your ID: ", 
                    "Must follow fomat: HE171754", 
                    "Your ID not valid", 
                    Constant.CONDITION_ID
        );
        if(!action.checkIdExist(list,Id)){
            System.out.println("ID not exist");
            return;
        }
        int index = -1;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId().equals(Id) ){
                index =i;
                break;   
            }
        } 
        System.out.println("1. Update");
        System.out.println("2. Delete");
        choice = Validation.getInt(
                    "Enter your choice:",
                    "Your choice must be 1 to 5!", 
                    "Number is not valid!", 
                    1, 3);
        switch(choice){
            case 1:
                action.update(list,index);
                System.out.println("Update success");
                break;
            case 2:
                action.remove(list, index);
                System.out.println("Remove success");
                break;
        }
        action.display(list);
    }
}