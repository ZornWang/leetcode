package top100.Hash;

import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }
        int result = 0;
        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int length = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }
                result = Math.max(length, result);
            }
        }
        return result;
    }
}
