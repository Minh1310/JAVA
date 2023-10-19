/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import constant.Constant;
import java.util.Random;


/**
 *
 * @author Nhat Anh
 */
public class BubbleSort {
    
    private int[] array;

    public void setArray(int[] array) {
        this.array = array;
    }
    
    public BubbleSort(int sizeOfArray) {
        array = new int[sizeOfArray];   
    }
    
    /**
     * Generate random integer in number range for each array element
     */
    public void getArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }
    
    /**
     * Use to sort array by ascending or descending
     * 
     * @param SORT_BY is message to know sort by ascending or descending
     */
    public void sort(String SORT_BY) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                   int  temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                }
            }
        }      
        switch(SORT_BY){
            case Constant.DESC:
                int lowIndex = 0;
                int highIndex = array.length - 1;
                do {
                    int temp = array[lowIndex];
                        array[lowIndex] = array[highIndex];
                        array[highIndex] = temp;
                    lowIndex++;
                    highIndex--;
                } while (lowIndex <= highIndex);
                break;
            
        }
    }

    /**
     * Use to display array follow format
     */
    public void display() {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
       }
        System.out.println("]");
    }
}
