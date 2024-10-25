import java.util.Scanner;
import java.util.Arrays;

public class MatrixAddition {

    public static void main(String[] args) {
        System.out.print("Input matrices' size (row col): ");
        @SuppressWarnings("resource")
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt(), col = scn.nextInt();
        int[][] matA = new int[row][col];
        int[][] matB = new int[row][col];

        System.out.println("Elements of matrix A:");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matA[i][j] =  scn.nextInt();
            }
        }

        System.out.println("Elements of matrix B:");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matB[i][j] =  scn.nextInt();
            }
        }
        
        int[][] matResult = new int[row][col];
        System.out.println("The sum of matrix A and B is:");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matResult[i][j] =  matA[i][j] + matB[i][j];
                System.out.print(matResult[i][j] + " ");
            }
            System.out.println();
        }  
    }
}