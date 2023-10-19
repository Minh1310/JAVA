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
public class InsertionSort {
    
    private int[] array;

    public void setArray(int[] array) {
        this.array = array;
    }
    
    public InsertionSort(int sizeOfArray) {
        array = new int[sizeOfArray];   
    }
    
    /**
     * Get array that each elements is random number
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
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
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
