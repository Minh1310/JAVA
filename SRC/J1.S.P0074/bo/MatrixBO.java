/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Matrix;

/**
 *
 * @author Nhat Anh
 */
public class MatrixBO {

    private int[][] resultMatrix;

    public MatrixBO() {
        this.resultMatrix = new int[0][0];
    }

    public MatrixBO(int[][] resultMatrix) {
        this.resultMatrix = resultMatrix;
    }

    /**
     * Use to addition two matrix
     */
    public int[][] addition(Matrix m1,Matrix m2) {
        if (m1.getRow() != m2.getRow()
                | m1.getColumn() != m2.getColumn()) {
            return resultMatrix =null;
        }
        resultMatrix = new int[m1.getRow() ][m1.getColumn()];
        for (int i = 0; i < m1.getRow() ; i++) {
            for (int j = 0; j < m1.getColumn(); j++) {
                resultMatrix[i][j] = m1.getMatrix()[i][j] + m2.getMatrix()[i][j];
            }
        }
        return resultMatrix;
    }

    /**
     * Use to subtraction two matrix
     */
    public int[][] subtraction(Matrix m1,Matrix m2) {
        if (m1.getRow() != m2.getRow()
                | m1.getColumn() != m2.getColumn()) {
            return resultMatrix =null;
        }
        resultMatrix = new int[m1.getRow() ][m1.getColumn()];
        for (int i = 0; i < m1.getRow() ; i++) {
            for (int j = 0; j < m1.getColumn(); j++) {
                resultMatrix[i][j] = m1.getMatrix()[i][j] - m2.getMatrix()[i][j];
            }
        }
        return resultMatrix;
    }

    /**
     * Use to multiplication two matrix
     */
    public int[][] multiplication(Matrix m1,Matrix m2) {
        if (m1.getRow() != m2.getRow()
                | m1.getColumn() != m2.getColumn()) {
            return resultMatrix =null;
        }
        resultMatrix = new int[m1.getRow() ][m2.getColumn()];
        for (int i = 0; i < m1.getRow() ; i++) {
            for (int j = 0; j < m1.getColumn(); j++) {
                int result = 0;
                int count = 0;
                do {
                    result += m1.getMatrix()[i][count] * m2.getMatrix()[count][j];
                    count++;
                } while (count != m2.getRow());
                resultMatrix[i][j] = result;
            }
        }
        return resultMatrix;
    }

    public void display(Matrix m1,Matrix m2, String operator){
        if(resultMatrix == null){
            System.out.println("Cant calculate");
            return;
        }
        m1.display();
        System.out.println(operator);
        m2.display();
        System.out.println("=");
        display();

    }

    /**
     * Use to display matrix
     */
    public void display() {
        if (resultMatrix == null) {
            System.out.println("Null");
            return;
        }
        for (int[] ls : resultMatrix) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                System.out.print("[" + ls[j] + "]");
            }
            System.out.println("");
        }
    }

    public int[][] getResultMatrix() {
        return resultMatrix;
    }

    public void setResultMatrix(int[][] resultMatrix) {
        this.resultMatrix = resultMatrix;
    }
}
