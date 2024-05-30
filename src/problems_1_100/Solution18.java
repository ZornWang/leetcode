package problems_1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    public static void main(String[] args) {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        System.out.println(new Solution18().fourSum(nums, target).toString());
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 一级剪枝
            if (nums[i] > 0 && nums[i] > target) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                // 二级剪枝
                if (nums[i] + nums[j] > 0 && nums[i] + nums[j] > target) break;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    // 注意溢出
                    if ((long) nums[i] + nums[j] + nums[left] + nums[right] > target) right--;
                    else if ((long) nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
