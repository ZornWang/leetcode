package kama_coder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution100 {
    public static int count;
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

        boolean[][] visited = new boolean[n][m];

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    // dfs
//                    count = 1;
//                    dfs(grid, visited, i, j);
                    // bfs
                    count = 0;
                    bfs(grid, visited, i, j);
                    result = Math.max(result, count);
                }
            }
        }
        System.out.print(result);
    }

    public static void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int n_x = x + dir[i][0];
            int n_y = y + dir[i][1];
            if (n_x < 0 || n_y < 0 || n_x >= grid.length || n_y >= grid[0].length) {
                continue;
            }
            if (!visited[n_x][n_y] && grid[n_x][n_y] == 1) {
                visited[n_x][n_y] = true;
                count++;
                dfs(grid, visited, n_x, n_y);
            }
        }
    }

    public static void bfs(int[][] grid, boolean[][] visited, int x, int y) {
        Deque<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        visited[x][y] = true;
        count++;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curx = cur[0];
            int cury = cur[1];
            for (int i = 0; i < 4; i++) {
                int n_x = curx + dir[i][0];
                int n_y = cury + dir[i][1];
                if (n_x < 0 || n_x >= grid.length || n_y < 0 || n_y >= grid[0].length) {
                    continue;
                }
                if (!visited[n_x][n_y] && grid[n_x][n_y] == 1) {
                    que.offer(new int[]{n_x, n_y});
                    visited[n_x][n_y] = true;
                    count++;
                }
            }
        }
    }
}
