/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import logic.Matrix;
import validation.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Main {
    public static void main(String[] args){
        Matrix matrix = new Matrix();
        System.out.println("1. Addition");
        System.out.println("2. Sucstraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Exist");
        int choice = Validation.getInt(
                        "Enter your choice", 
                        "Must 1 to 4!", 
                        "Invalid number", 
                        1, 4);
        switch(choice){
            case 1:
                matrix.getMatrix();
                matrix.addition();
                matrix.display("+");
                break;
            case 2:
                matrix.getMatrix();
                matrix.subtraction();
                matrix.display("-");
                break;
            case 3:
                matrix.getMatrix();
                matrix.multiplication();
                matrix.display("x");
                break;
            case 4:
                System.out.println("Exist program");
                break;
        }

    }
}
