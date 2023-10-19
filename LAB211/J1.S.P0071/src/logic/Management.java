/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import constant.Constant;
import entity.Task;
import java.util.ArrayList;
import java.util.Iterator;
import validation.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Management {
    
    /**
     * Use to check task existed in task list
     * 
     * @param list list about information of task take from input
     * @param Id ID of task take from input
     * @return true if ID existed or false if ID not check
     */
    private boolean checkTaskExist(ArrayList <Task> list,int id){
       boolean exist = false;
       for(Task ls : list){
           if(ls.getId() == id){
               exist = true;
               break;
           }
       }
       return exist;   
    }
    
    /**
     * 
     * @param list 
     */
    public void addTask(ArrayList<Task> list){
        int Id = list.get(list.size()-1).getId()+1;
        String requirementName = Validation.getString(
                "Enter requirement name: ", 
                "Must have (a-zA_Z0-9)", 
                "Invalid String", 
                Constant.REGEX_NAME);
        int taskTypeId = Validation.getInt(
                "Enter task type ID(1-4)", 
                "Must from 1 to 4", 
                "Invalid number", 
                1, 4);
        String taskType="";
        switch(taskTypeId){
            case 1:
                taskType = "Code";
                break;
            case 2:
                taskType = "Test";
                break;
            case 3:
                taskType = "Design";
                break;
            case 4:
                taskType = "Review";
                break;
        }
        String date = Validation.getString(
                "Enter your date: ", 
                "Must follow dd/mm/yy", 
                "Invalid String", 
                Constant.REGEX_DATE_OF_BIRTH);
        double planFrom,planTo,time;
        do{
            planFrom = Validation.getDouble(
                    "Enter time from: ", 
                    "Must from 8 to 17.5", 
                    "Invalid number", 
                    8, 17.5);
            planTo = Validation.getDouble(
                    "Enter time to: ", 
                    "Must from 8 to 17.5", 
                    "Invalid number", 
                    8, 17.5);
            time = planTo - planFrom;
        } while(planFrom >= planTo); 
        String assignee = Validation.getString(
                "Enter assignee name: ", 
                "Must have (a-zA_Z0-9)", 
                "Invalid String", 
                Constant.REGEX_NAME);
        String reviewer = Validation.getString(
                "Enter reviewer name: ", 
                "Must have (a-zA_Z0-9)", 
                "Invalid String", 
                Constant.REGEX_NAME);  
        list.add(new Task(
                Id,
                requirementName,
                taskType,date,
                time,assignee,
                reviewer));
    }
    
    public void deleteTask(ArrayList<Task> list){
       boolean check = true;
        int id = Validation.getInt(
                "Enter task type ID", 
                "Must small than list size", 
                "Invalid number", 
                list.get(0).getId(), list.get(list.size()-1).getId());
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId()== id){
                list.remove(i);
                check = false;
                break;
            }
        }
        if(check){
            System.out.println("Dont exist ID");
        }
    }
    
    /**
     * 
     * @param list 
     */
    //6,12,4,11,4,5
    public void showTask(ArrayList<Task> list){
        Iterator ls = list.iterator();
        while(ls.hasNext()){
            Object element = ls.next();
            System.out.println(element);
        }
    }
}
