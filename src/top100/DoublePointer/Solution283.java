package top100.DoublePointer;

import java.util.Arrays;

public class Solution283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right] = temp;
            }
            right++;
        }
    }
//    public void moveZeroes(int[] nums) {
//        int[] temps = new int[nums.length];
//        int notZero = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                temps[notZero++] = nums[i];
//            }
//        }
//        for (int i = notZero; i < temps.length; i++) {
//            temps[i] = 0;
//        }
//        System.arraycopy(temps, 0, nums, 0, temps.length);
//    }
}
