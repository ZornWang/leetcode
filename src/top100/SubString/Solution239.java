package top100.SubString;

import java.util.*;

/*
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class Solution239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(nums, k)));
    }

    // priorityQueue
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] result = new int[n - k + 1];
        result[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            result[i - k + 1] = pq.peek()[0];
        }
        return result;
    }

//    // out of time
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] result = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            int[] sub = Arrays.copyOfRange(nums, i, i + k);
//            Arrays.sort(sub);
//            result[i] = sub[k - 1];
//        }
//        return result;
//    }
}
