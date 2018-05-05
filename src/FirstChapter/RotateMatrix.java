package FirstChapter;

/**
 * Created by tommaso on 05/05/2018.
 * Rotate a matrix 90° to the right
 */
public class RotateMatrix {

    public static void main(String[] args) {

        int matrix_size = 4;
        int[][] matrix = new int[matrix_size][matrix_size];

        for (int i = 0; i < matrix_size; i++) {
            for (int j = 0; j < matrix_size; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        printMatrix(matrix);
        matrix = rotate_matrix(matrix);
        System.out.println("");
        printMatrix(matrix);
    }

    private static int[][] rotate_matrix(int[][] matrix) {
        int cycles_needed = matrix.length / 2;
        for (int i = 0; i < cycles_needed; i++) {
            int last = matrix.length - 1 - i;
            for (int j = i; j < last; j++) {
                int offset = j - i;
                int temp = matrix[i][j]; // Save first top element
                matrix[i][j] =  matrix[last-offset][i]; // Left->Top
                matrix[last-offset][i] = matrix[last][last-offset]; // Bottom->Left
                matrix[last][last-offset] = matrix[j][last]; //Right -> Bottom
                matrix[j][last] = temp; //Top->Right
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }
}