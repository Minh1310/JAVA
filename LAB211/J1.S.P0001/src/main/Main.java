/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import logic.BubbleSort;

import validate.Validation;

public class Main {

    public static void main(String[] args) {
        
        int sizeOfArray = Validation.getInt("Enter size of array:",
                                            "Size is out of range", 
                                            "Number is not valid", 
                                            0, 100);
        BubbleSort bubbleSort = new BubbleSort(sizeOfArray);
        bubbleSort.getArray();
        // Array before you sort
        System.out.println("Unsorted: ");
        bubbleSort.display();
        int choice;
        do{
            System.out.println("1. Ascending: ");
            System.out.println("2. Descending: ");
            System.out.println("3. Both");
            System.out.println("0. Exit: You are the best");
            choice = Validation.getInt("Enter your choice(0-3):",
                                        "Choice must be 0 to 3", 
                                        "Invalid number", 
                                        0, 3);
            switch(choice){
                case 1: 
                    System.out.println("1. Ascending: ");
                    bubbleSort.sort("ASC");
                    bubbleSort.display();
                    break;
                case 2:
                    System.out.println("1. Descending: ");
                    bubbleSort.sort("DESC");
                    bubbleSort.display();
                    break;
                case 3:
                    System.out.println("Both: ");
                    bubbleSort.sort("ASC");
                    bubbleSort.display();
                    bubbleSort.sort("DESC");
                    bubbleSort.display();
                    break;                 
            }
        } while(choice != 0);
    }
}
