/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import Constant.Constant;
import java.util.Random;


/**
 *
 * @author Nhat Anh
 */
public class QuickSort {
    
    private int[] array;

    public void setArray(int[] array) {
        this.array = array;
    }
    
    public QuickSort(int sizeOfArray) {
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
     * 
     * @param low  is start index
     * @param high is last index
     * @return a integer number which is index split array left and right,
     * left is less than, right is greater than         
     */
    private int partition( int low, int high){
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
            }
        }
        int temp = array[high];
            array[high] = array[i+1];
            array[i+1] = temp;
        return (i + 1);
    }
    
    /**
     * Use to sort array
     * 
     * @param low  is start index
     * @param high is last index
     */
    private void quickSort(int low, int high){
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }
    
    /**
     * Use to sort array by ascending or descending
     * 
     * @param SORT_BY is message to know sort by ascending or descending
     */
    public void sort(String SORT_BY) {
        int low = 0;
        int high = array.length-1;
        quickSort(low,high);    
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
