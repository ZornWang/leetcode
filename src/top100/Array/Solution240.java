package top100.Array;

public class Solution240 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(new Solution240().searchMatrix(matrix, target));
    }

    // z字形查找，从右上角开始，左边均小于，下方均大于。目标值就在右上角的左下方
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0][0] > target) return false;

        int m = matrix.length, n = matrix[0].length;
        int col = 0, row = n - 1;

        while (col < m && row >= 0) {
            if (matrix[col][row] == target) {
                return true;
            }
            if (matrix[col][row] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
