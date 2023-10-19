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
public class SelectionSort {
    
    private int[] array;

    public void setArray(int[] array) {
        this.array = array;
    }
    
    public SelectionSort(int sizeOfArray) {
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
        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                if (array[j] < array[min_idx]){
                    min_idx = j;
                }    
            }
            int temp = array[min_idx];
                array[min_idx] = array[i];
                array[i] = temp;
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
