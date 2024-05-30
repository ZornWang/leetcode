package top100.DoublePointer;


public class Solution11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution11().maxArea(height));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left != right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

//    // 遍历
//    public int maxArea(int[] height) {
//        int result = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = 0; j < height.length; j++) {
//                result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
//            }
//        }
//        return result;
//    }
}
