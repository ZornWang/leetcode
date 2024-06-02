package top100.Matrix;

import java.util.ArrayList;
import java.util.List;

/*
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 1. 为输出的四个边界设立标志位
 * 2. 单独定义循环轮数，并且处理特殊情况
 * 3. 通过判断总输出个数，提前终止循环
 */
public class Solution54 {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{6, 9, 7}};
        System.out.println(new Solution54().spiralOrder(matrix).toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        int nums = m * n;
        int loop = Math.max(m, n) / 2;
        while (loop > 0) {
            for (int i = left; i < right && nums > 0; i++) {
                result.add(matrix[top][i]);
                nums--;
            }
            for (int i = top; i < bottom && nums > 0; i++) {
                result.add(matrix[i][right]);
                nums--;
            }
            for (int i = right; i > left && nums > 0; i--) {
                result.add(matrix[bottom][i]);
                nums--;
            }
            for (int i = bottom; i > top && nums > 0; i--) {
                result.add(matrix[i][left]);
                nums--;
            }

            top++;
            bottom--;
            left++;
            right--;

            loop--;
        }
        if (nums != 0 && (m * n) % 2 == 1) {
            result.add(matrix[m / 2][n / 2]);
        }
        return result;
    }
}
