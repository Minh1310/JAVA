/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Account;
import java.util.ArrayList;
import logic.Management;
import validation.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Main {
    
    public static void main(String[] args){
        ArrayList<Account> list = new ArrayList<>();
        Management management = new Management();
        list.add(new Account(
                "minhDepTrai",
                management.getMd5("minh1310"),
                "Minh handsome",
                "1234567890",
                "minhbqhe171754@fpt.edu.vn",
                "daiHocFPT",
                "13/10/2003"
        ));
//        
//        list.add(new Account(
//                "truong",
//                "truong310",
//                "truong handsome",
//                "1234567890",
//                "truong@fpt.edu.vn",
//                "FPT",
//                "12/12/2003"
//        ));
        
        int choice;
        do{
            System.out.println("1. Add user");
            System.out.println("2. Login");
            System.out.println("3. Exist");
            choice = Validation.getInt(
                    "Enter your choice", 
                    "Out of range!", 
                    "Invalid number", 
                    1, 3);
                    switch(choice){
                        case 1:
                            System.out.println(list);
                            management.addUser(list);
                            System.out.println("--------");
                            System.out.println(list);
                            System.out.println("--------");
                            break;
                        case 2:
                            System.out.println(list);
                            management.login(list);
                            System.out.println("--------");
                            System.out.println(list);
                            System.out.println("--------");
                            break;
                        case 3:
                            System.out.println("have a nice day");
                            System.out.println("--------");
                            break;
                    }
        } while(choice!=3);
    }
}
