/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import logic.Management;
import validation.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Main {
    
    public static void main(String[] args){
        ArrayList<Experience> expList = new ArrayList<>();
        ArrayList<Fresher> freList = new ArrayList<>();
        ArrayList<Intern> intList = new ArrayList<>();
        Management manage = new Management();
        System.out.println("minh");
        int choice;
        do{
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Intern");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            choice = Validation.getInt(
                "Enter your choice",
                "Must around 1-5",
                "Invalid number", 
                1,5);
            switch(choice){
                case 1:
                    manage.display(expList);
                    manage.addExperience(expList);
                    manage.display(expList);
                    break;
                case 2:
                    manage.display(freList);
                    manage.addFresher(freList);
                    manage.display(freList);
                    break;
                case 3:
                    manage.display(intList);
                    manage.addIntern(intList);
                    manage.display(intList);
                    break;
                case 4:
                    System.out.println("------Experience------");
                    manage.display(expList);
                    System.out.println("------Fresher------");
                    manage.display(freList);
                    System.out.println("------Intern------");
                    manage.display(intList);
                    System.out.println("-------------------");
                    manage.search(expList,freList,intList);
                    break;
                case 5:
                    break;
            }

        } while(choice!=5);
    }
}
