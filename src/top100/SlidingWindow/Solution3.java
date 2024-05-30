package top100.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        char[] charArray = s.toCharArray();
        int result = 0;
        int left = -1;
        for (int i = 0; i < charArray.length; i++) {
            if (i != 0) {
                window.remove(charArray[i - 1]);
            }
            while (left + 1 < charArray.length && !window.contains(charArray[left + 1])) {
                window.add(charArray[left++ + 1]);
            }
            result = Math.max(result, left - i + 1);
        }
        return result;
    }
}
