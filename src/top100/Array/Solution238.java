package top100.Array;

import java.util.Arrays;

public class Solution238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution238().productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] L = new int[n], R = new int[n];

        L[0] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[n - 1] = 1;
        for (int i = n - 2; i > -1; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        for (int i = 0; i < n; i++) {
            answer[i] = R[i] * L[i];
        }
        return answer;
    }
}
