package top100.SubString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 */
public class Solution560 {
    public static void main(String[] args) {
        int[] nums = {-1, -1, 1};
        int k = 0;
        System.out.println(new Solution560().subarraySum(nums, k));
    }

    // 前缀和
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
//    // 枚举
//    public int subarraySum(int[] nums, int k) {
//        int result = 0;
//
//        for (int start = 0; start < nums.length; start++) {
//            int current = 0;
//            for (int end = start; end >= 0; end--) {
//                current += nums[end];
//                if (current == k) {
//                    result++;
//                }
//            }
//        }
//
//        return result;
//    }
}
