package FirstChapter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommaso on 05/05/2018.
 * If there is a 0, replace row and column with 0
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        boolean firstRow= false, firstColumn= false;
        int row = 4, column = 6;
        int[][] matrix = new int[row][column];

        // Initialize and print matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        printMatrix(matrix);

        // Find Zeros and Replace Them (Using support array)
        /*List<Point> listZero = findZero(matrix);
        for (Point pair  : listZero) {
            replace(pair.x, pair.y, matrix);
        }*/

        // Find Zeros and Replace Them (Without using space)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 && matrix[i][j] == 0) {
                    firstRow = true;
                }

                if (j == 0 && matrix[i][j] == 0) {
                    firstColumn = true;
                }

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Row
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Column
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        //FirstRow or FirstColumn
        if (firstRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColumn) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        // Print final matrix
        System.out.println("");
        printMatrix(matrix);
    }

    // Works using an additional Array
    private static List<Point> findZero(int[][] matrix) {
        List<Point> listZero = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    listZero.add(new Point(i, j));
                }
            }
        }

        return listZero;
    }

    // Works using an additional Array
    private static int[][] replace(int i, int j, int[][] matrix) {
        for (int index = 0; index < matrix[i].length; index++) {
            matrix[i][index] = 0;
        }

        for (int index = 0; index < matrix.length; index++) {
            matrix[index][j] = 0;
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
