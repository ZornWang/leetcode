package top100.SlidingWindow;

import java.util.*;

/*
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
 * 不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * */
public class Solution438 {
    public static void main(String[] args) {
        String s = "aa";
        String p = "bb";
        System.out.println(new Solution438().findAnagrams(s, p).toString());
    }

    /*
     * 滑动窗口
     * 先创建和p长度一样的窗口
     * 然后掐头去尾判断即可
     * */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + p.length()) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                result.add(i + 1);
            }
        }
        return result;
    }
    //over time
//    public List<Integer> findAnagrams(String s, String p) {
//        Map<Character, Integer> map = new HashMap<>();
//        char[] charArray = s.toCharArray();
//        for (char c : p.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        List<Integer> result = new ArrayList<>();
//        Map<Character, Integer> window = new HashMap<>();
//        for (int i = 0; i < charArray.length - p.length() + 1; i++) {
//            for (int j = i; j < i + p.length(); j++) {
//                window.put(charArray[j], window.getOrDefault(charArray[j], 0) + 1);
//            }
//            if (map.equals(window)) result.add(i);
//            window.clear();
//        }
//        return result;
//    }
}
