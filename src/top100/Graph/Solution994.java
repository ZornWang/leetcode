package top100.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(new Solution994().orangesRotting(grid));
    }

    private static final int[][] DIRECTIONS = new int[][]{
            {0, 1}, // 右
            {0, -1}, // 左
            {1, 0}, // 下
            {-1, 0} // 上
    };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = -1;
        while (!queue.isEmpty() && freshCount > 0) {
            for (int i = queue.size(); i > 0; i--) {
                int[] position = queue.poll();
                for (int[] direction : DIRECTIONS) {
                    assert position != null;
                    int newX = position[0] + direction[0];
                    int newY = position[1] + direction[1];
                    if (newX >= 0 && newX < grid.length &&
                            newY >= 0 && newY < grid[0].length &&
                            grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        freshCount--;
                    }
                }
            }
            minutes++;
        }

        return freshCount > 0 ? -1 : (minutes == -1 ? 0 : minutes + 1);
    }
}
