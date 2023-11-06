/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.MatrixBO;
import entity.Matrix;
import utils.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Main {
    public static void main(String[] args){
        MatrixBO matrixBO = new MatrixBO();
        matrixBO.display();
        int choice;
        final int MAX = Integer.MAX_VALUE;
        do{
            Matrix m1 = new Matrix();
            Matrix m2 = new Matrix();
            System.out.println("1. Addition");
            System.out.println("2. Sucstraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Exist");
            choice = Validation.getInt(
                            "Enter your choice", 
                            "Must 1 to 4!", 
                            "Invalid number", 
                            1, 4);
            switch(choice){
                case 1:
                    matrixBO.calculate(choice);
                    break;
                case 2:
                    matrixBO.calculate(choice);
                    break;
                case 3:
                    matrixBO.calculate(choice);
                    break;
                case 4:
                    System.out.println("Exist program");
                    break;
            }

        }while(choice!=4);
}}
