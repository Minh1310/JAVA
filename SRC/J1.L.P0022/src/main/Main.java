
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import bo.ExperienceBO;
import bo.FresherBO;
import bo.InternBO;
import constant.Constant;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import utils.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Main {
    
    public static void main(String[] args){
        ArrayList<Experience> expList = new ArrayList<>();
        ArrayList<Fresher> freList = new ArrayList<>();
        ArrayList<Intern> intList = new ArrayList<>();
        ExperienceBO exp = new ExperienceBO();
        InternBO inte = new InternBO();
        FresherBO fre = new FresherBO();
        
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
                    exp.display(expList);
                    exp.add(expList);
                    exp.display(expList);
                    break;
                case 2:
                    fre.display(freList);
                    fre.add(freList);
                    fre.display(freList);
                    break;
                case 3:
                    inte.display(intList);
                    inte.add(intList);
                    inte.display(intList);
                    break;
                case 4:
                    System.out.println("------Experience------");
                    exp.display(expList);
                    System.out.println("------Fresher------");
                    fre.display(freList);
                    System.out.println("------Intern------");
                    inte.display(intList);
                    System.out.println("-------------------");
                    String name = Validation.getString(
                        "Enter your first name or last name : ", 
                        "Must have(a-zA-Z)", 
                        "Invalid string", 
                        Constant.REGEX_NAME
                    ).toLowerCase();
                    exp.display(exp.search(expList,name));
                    fre.display(fre.search(freList, name));
                    inte.display(inte.search(intList, name));
                    break;
                case 5:
                    break;
            }

        } while(choice!=5);
    }
}