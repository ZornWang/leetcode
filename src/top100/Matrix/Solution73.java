package top100.Matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution73 {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new Solution73().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> lines = new HashSet<>();
        // 行
        int m = matrix.length;
        // 列
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    lines.add(j);
                }
            }
        }
        for (Integer row : rows) {
            for (int i = 0; i < n; i++) {
                matrix[row][i] = 0;
            }
        }
        for (Integer line : lines) {
            for (int i = 0; i < m; i++) {
                matrix[i][line] = 0;
            }
        }
    }
}
