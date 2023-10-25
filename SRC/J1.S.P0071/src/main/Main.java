/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import utils.Validation;
import bo.TaskBO;

/**
 *
 * @author Nhat Anh
 */
public class Main {
    
    public static void main(String[] args){

    TaskBO taskBO = new TaskBO();
    int choice;
    do{
        System.out.println("1. Add task");
        System.out.println("2. Delete task");
        System.out.println("3. Show task");
        System.out.println("4. Exit");
        choice = Validation.getInt(
                "Enter your choice", 
                "Out of range", 
                "Invalid number", 
                1, 4);
        switch(choice){
            case 1:
                System.out.println(taskBO.add()? "Success" : "fail");    
                break;
            case 2:
                int min = taskBO.getList().get(0).getId();
                int max = taskBO.getList().get(taskBO.getList().size()-1).getId();
                int id = Validation.getInt(
                    "Enter your id: ",
                    "Out of range", 
                    "Invalid number", 
                    min,max);
                System.out.println(taskBO.delete(id)? "Success" : "fail");  
                break;
            case 3: 
                taskBO.display();;
                break;
            case 4:
                break;
        }
    } while(choice != 4);
}}
