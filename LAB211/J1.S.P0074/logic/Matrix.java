/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import validation.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Matrix {
    
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] resultMatrix;
    private int lengthRow;
    private int lengthColumn;

    public Matrix() { 
    }

    public void setLengthRow(int lengthRow) {
        this.lengthRow = lengthRow;
    }

    public void setLengthColumn(int lengthColumn) {
        this.lengthColumn = lengthColumn;
    }

    /**
     * Use to get two matrix from input
     */
    public void getMatrix(){
        lengthRow = Validation.getInt(
                            "Enter row matrix: ", 
                            "Number is out of range!", 
                            "Must be integer number", 
                            0, 100);
        lengthColumn = Validation.getInt(
                            "Enter column matrix: ", 
                            "Number is out of range!", 
                            "Must be integer number", 
                            0, 100);
        matrix1 = new int[lengthRow][lengthColumn]; 
        for (int i = 0; i < lengthRow ; i++) {
            for (int j = 0; j < lengthColumn; j++) {
                matrix1[i][j] = Validation.getInt(
                    "Element matrix " + "[" + (i+1) + "]" + "[" + (j+1) + "]" + "=",
                    "Number is out of range!",
                    "Must be integer number",
                    0, 100);
            }
        }
        
        lengthRow = Validation.getInt(
                            "Enter row matrix: ", 
                            "Number is out of range!", 
                            "Must be integer number", 
                            0, 100);
        lengthColumn = Validation.getInt(
                            "Enter column matrix: ", 
                            "Number is out of range!", 
                            "Must be integer number", 
                            0, 100);
        matrix2 = new int[lengthRow][lengthColumn]; 
        for (int i = 0; i < lengthRow ; i++) {
            for (int j = 0; j < lengthColumn; j++) {
                matrix2[i][j] = Validation.getInt(
                    "Element matrix " + "[" + (i+1) + "]" + "[" + (j+1) + "]" + "=",
                    "Number is out of range!",
                    "Must be integer number",
                    0, 100);
            }
        }
    }
    
    /**
     * Use to addition two matrix
     */
    public int[][] addition() {
        if (matrix1.length != matrix2.length
            | matrix1[0].length != matrix2[0].length) {
            System.out.println("Cant substraction two this matrix");
            return null;
        }
        resultMatrix = new int[lengthRow][lengthColumn];
        for (int i = 0; i < lengthRow; i++) {
            for (int j = 0; j < lengthColumn; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultMatrix;
    }
    
    /**
     * Use to subtraction two matrix
     */
    public int[][] subtraction() {
        if (matrix1.length != matrix2.length
            | matrix1[0].length != matrix2[0].length) {
            System.out.println("Cant subtraction two this matrix");
            return null;
        }
        resultMatrix = new int[lengthRow][lengthColumn];
        for (int i = 0; i < lengthRow; i++) {
            for (int j = 0; j < lengthColumn; j++) {
                resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return resultMatrix;
    }
    
    /**
     * Use to multiplication two matrix
     */
    public int[][] multiplication(){
        if(matrix1[0].length != matrix2.length){
            System.out.println("Cant multiplication two this matrix");
            return null;
        }
        resultMatrix = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length ; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                int result=0;
                int count =0;
                do{
                    result +=  matrix1[i][count] * matrix2[count][j];
                    count++;
                } while(count != matrix2.length);
                resultMatrix[i][j] = result;
            }
        }
        return resultMatrix;
    }
    
    /**
     *Use to display result of calculate two matrix
     * 
     * @param operator is the calculation between two matrices like: +,-,*
     */
    public void display(int [][]a,String operator){
        if(a == null){
            System.out.println("Error dimention");
            return;
        }
        display(matrix1);
        System.out.println(operator);
        display(matrix2);
        System.out.println("=");
        display(a);
    }
    
    /**
     * Use to display  matrix
     */
    public void display(int[][] a){
        if(a == null){
            System.out.println("Null");
            return;
        }
        for (int[] ls : a) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("[" + ls[j] + "]");
            }
            System.out.println("");
        }
    }
}
