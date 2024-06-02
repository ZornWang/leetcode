package problems_1_100;

public class Solution35 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 7, 8, 9};
        int target = 4;
        System.out.println(new Solution35().searchInsert(nums, target));
    }

    // 左闭右开
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length; // target在左闭右闭区间，[l, r)
        while (l < r) { //l == r时, [l, r)区间无意义
            int mid = (r - l) / 2 + l;
            // mid大于target，更新右区间，去[l, mid)中寻找
            if (nums[mid] > target) {
                r = mid;
                // mid小于target，更新左区间，去[mid+1, r)中寻找
            } else if (nums[mid] < target) {
                l = mid + 1;
                // mid等于target，直接返回
            } else {
                return mid;
            }
        }
        return l;
    }

    // 左闭右闭
//    public int searchInsert(int[] nums, int target) {
//        int l = 0, r = nums.length - 1; // target在左闭右闭区间，[l, r]
//        while (l <= r) {
//            int mid = (r - l) / 2 + l;
//            // mid大于target，更新右区间，去[l, mid-1]中寻找
//            if (nums[mid] > target) {
//                r = mid - 1;
//            // mid小于target，更新左区间，去[mid+1, r]中寻找
//            } else if (nums[mid] < target) {
//                l = mid + 1;
//            // mid等于target，直接返回
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }
}
