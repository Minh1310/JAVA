/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Task;
import java.util.ArrayList;
import logic.Management;
import validation.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Main {
    
    public static void main(String[] args){
    ArrayList<Task> list = new ArrayList<>();
    Management manage = new Management();
    list.add(new Task(105, "Dev Program", "Code", "28/08/2015", 9.5, "Dev", "Lead"));
    list.add(new Task(106, "Dev Program", "Code", "29/08/2015", 10, "Dev", "Lead"));
    list.add(new Task(107, "Dev Program", "Code", "30/08/2015", 10.5, "Dev", "Lead"));
    list.add(new Task(108, "Dev Program", "Code", "31/08/2015", 11, "Dev", "Lead"));
    
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
                manage.addTask(list);
                break;
            case 2:
                manage.deleteTask(list);
                break;
            case 3: 
                manage.showTask(list);
                break;
            case 4:
                break;
        }
    } while(choice != 4);
}}
