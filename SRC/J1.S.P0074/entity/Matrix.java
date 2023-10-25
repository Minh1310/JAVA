package entity;
import utils.Validation;

public class Matrix{

private int[][] matrix;
private int row;
private int column;
public Matrix() {
    matrix = new int[0][0];
}
public Matrix(int[][] matrix, int row, int column) {
    this.matrix = matrix;
    this.row = row;
    this.column = column;
}
public int[][] getMatrix() {
    return matrix;
}
public void setMatrix(int[][] matrix) {
    this.matrix = matrix;
}
public int getRow() {
    return row;
}
public void setRow(int row) {
    this.row = row;
}
public int getColumn() {
    return column;
}
public void setColumn(int column) {
    this.column = column;
}

public void inputValue(){
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < column; j++) {
            matrix[i][j] = Validation.getInt(
                    "Element matrix " + "[" + (i + 1) + "]" + "[" + (j + 1) + "]" + "=",
                    "Number is out of range!",
                    "Must be integer number",
                    0, 50/0);
        }
    }
}

public void input(int row, int column) {
    this.row = row;
    this.column = column;
    this.matrix = new int[row][column];
}

/**
     * Use to display  matrix
     */
    public void display(){
        if(matrix == null){
            System.out.println("Null");
            return;
        }
        for (int[] ls : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + ls[j] + "]");
            }
            System.out.println("");
        }
    }


}