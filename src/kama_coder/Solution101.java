package kama_coder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution101 {
    public static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // 遍历左右侧
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) bfs(grid, i, 0);
            if (grid[i][m - 1] == 1) bfs(grid, i, m - 1);
        }
        //遍历上下侧
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) bfs(grid, 0, i);
            if (grid[n - 1][i] == 1) bfs(grid, n - 1, i);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        System.out.print(count);
        scanner.close();
    }

    public static void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int n_x = x + dir[i][0];
            int n_y = y + dir[i][1];
            if (n_x < 0 || n_y < 0 || n_x >= grid.length || n_y >= grid[0].length) continue;
            if (grid[n_x][n_y] == 0) continue;

            dfs(grid, n_x, n_y);
        }
    }

    public static void bfs(int[][] grid, int x, int y) {
        Deque<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        grid[x][y] = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curx = cur[0];
            int cury = cur[1];
            for (int i = 0; i < 4; i++) {
                int n_x = curx + dir[i][0];
                int n_y = cury + dir[i][1];
                if (n_x < 0 || n_x >= grid.length || n_y < 0 || n_y >= grid[0].length) continue;
                if (grid[n_x][n_y] == 1) {
                    que.offer(new int[]{n_x, n_y});
                    grid[n_x][n_y] = 0;
                }
            }
        }
    }
}
