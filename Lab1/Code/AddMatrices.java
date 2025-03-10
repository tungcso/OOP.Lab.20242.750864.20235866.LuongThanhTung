import java.util.Scanner;

public class AddMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Luong Thanh Tung - Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.print("Luong Thanh Tung - Enter the number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sumMatrix = new int[rows][cols];

        System.out.println("Enter elements of first matrix" + "(Every " + cols + " elements of "+ rows+ " rows):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of second matrix" +"(Every " + cols +" elements of "+ rows+ " rows):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("\nFirst Matrix:");
        printMatrix(matrix1, rows, cols);

        System.out.println("\nSecond Matrix:");
        printMatrix(matrix2, rows, cols);

        System.out.println("\nSum of Matrices:");
        printMatrix(sumMatrix, rows, cols);

        sc.close();
    }

    private static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}