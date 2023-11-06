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
            this.matrix[i][j] = Validation.getInt(
                    "Element matrix " + "[" + (i + 1) + "]" + "[" + (j + 1) + "]" + "=",
                    "Number is out of range!",
                    "Must be integer number",
                    0, Integer.MAX_VALUE);
        }
    }
}

public void input(int row, int column) {
    this.row = Validation.getInt(
            "Enter your row", 
            "Out range", "Invalid number", 
            1, row);
    this.column = Validation.getInt(
            "Enter your column", 
            "Out range", "Invalid number", 
            1, column);
    this.matrix = new int[this.row][this.column];
}

/**
     * Use to display  matrix
     */
    public void display(){
        if(this.matrix == null){
            System.out.println("Null");
            return;
        }
        for (int[] ls : this.matrix) {
            for (int j = 0; j < column; j++) {
                System.out.print("[" + ls[j] + "]");
            }
            System.out.println("");
        }
    }


}