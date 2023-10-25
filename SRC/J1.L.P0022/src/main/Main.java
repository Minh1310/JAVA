
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.ExperienceBO;
import bo.FresherBO;
import bo.InternBO;
import constant.Constant;
import utils.Validation;
/**
 *
 * @author Nhat Anh
 */
public class Main {
    
    public static void main(String[] args){
        ExperienceBO experBO = new ExperienceBO();
        InternBO intBO = new InternBO();
        FresherBO freBO = new FresherBO(); 
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
                    experBO.display();
                    experBO.add();
                    experBO.display();
                    break;
                case 2:
                    freBO.display();
                    freBO.add();
                    freBO.display();
                    break;
                case 3:
                    intBO.display();
                    intBO.add();
                    intBO.display();
                    break;
                case 4:
                    System.out.println("------Experience------");
                    experBO.display();
                    System.out.println("------Fresher------");
                    freBO.display();
                    System.out.println("------Intern------");
                    intBO.display();
                    System.out.println("-------------------");
                    String name = Validation.getString(
                        "Enter your first name or last name : ", 
                        "Must have(a-zA-Z)", 
                        "Invalid string", 
                        Constant.REGEX_NAME
                    ).toLowerCase();
                    int type = Validation.getInt(
                            "Enter type of cadidate",
                            "Out of range", 
                            "Invalid number", 
                            0, 2);
                    switch(type){
                        case 0:
                            experBO.display(experBO.search(name));
                            break;
                        case 1:
                            freBO.display(freBO.search( name));
                            break;
                        case 2:
                            intBO.display(intBO.search( name));
                            break;

                    }
                    break;
                case 5:
                    break;
            }

        } while(choice!=5);
    }
}