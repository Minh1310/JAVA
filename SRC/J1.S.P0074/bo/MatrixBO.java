/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import constant.Constant;
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
    
    public void calculate(int choice){
        this.resultMatrix = null;
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix();
        m1.input(Constant.MAX,Constant.MAX);
        m1.inputValue();
        if(choice == 3){
            m2.input(m1.getColumn(), Constant.MAX);
        } else{ 
            m2.input(m1.getRow(), m1.getColumn());}
        m2.inputValue();
        switch(choice){
            case 1:
                addition(m1, m2);
                display(m1, m2, "+");
               break;
            case 2:
                subtraction(m1, m2);
                display(m1, m2, "-");
                break;
            case 3:
                multiplication(m1, m2);
                display(m1, m2, "X");
                break;
        }     
    }

    /**
     * Use to addition two matrix
     * @param m1
     * @param m2 
     */
    public void addition(Matrix m1,Matrix m2) {
        if (m1.getRow() != m2.getRow()
                | m1.getColumn() != m2.getColumn()) {
            return;
        }
        this.resultMatrix = new int[m1.getRow() ][m1.getColumn()];
        for (int i = 0; i < m1.getRow() ; i++) {
            for (int j = 0; j < m1.getColumn(); j++) {
               this. resultMatrix[i][j] = m1.getMatrix()[i][j] + m2.getMatrix()[i][j];
            }
        }
    }

    /**
     * Use to subtraction two matrix
     * @param m1
     * @param m2
     */
    public void subtraction(Matrix m1,Matrix m2) {
        if (m1.getRow() != m2.getRow()
                | m1.getColumn() != m2.getColumn()) {
            return;
        }
        this.resultMatrix = new int[m1.getRow() ][m1.getColumn()];
        for (int i = 0; i < m1.getRow() ; i++) {
            for (int j = 0; j < m1.getColumn(); j++) {
                this.resultMatrix[i][j] = m1.getMatrix()[i][j] - m2.getMatrix()[i][j];
            }
        }
    }

    /**
     * Use to multiplication two matrix
     * @param m1
     * @param m2 
     */
    public void multiplication(Matrix m1,Matrix m2) {
        if (m1.getColumn() != m2.getRow()) {
            return ;
        }
        this.resultMatrix = new int[m1.getRow() ][m2.getColumn()];
        for (int i = 0; i < m1.getRow() ; i++) {
            for (int j = 0; j < m1.getColumn(); j++) {
                int result = 0;
                int count = 0;
                do {
                    result += (m1.getMatrix()[i][count] * m2.getMatrix()[count][j]);
                    count++;
                } while (count != m2.getRow());
                this.resultMatrix[i][j] = result;
            }
        }
    }

    public void display(Matrix m1,Matrix m2, String operator){
        if(this.resultMatrix == null){
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
        for (int[] ls : this.resultMatrix) {
            for (int j = 0; j < this.resultMatrix[0].length; j++) {
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
