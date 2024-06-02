package top100.Array;

import java.util.Arrays;

public class Solution189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        new Solution189().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = nums.clone();
        for (int i = 0; i < n; i++) {
            nums[(k + i) % n] = temp[i];
        }
    }
}
