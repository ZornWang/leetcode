package top100.Graph;

public class Solution200 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        System.out.println(new Solution200().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nums_r = grid.length;
        int nums_c = grid[0].length;
        int result = 0;
        for (int i = 0; i < nums_r; i++) {
            for (int j = 0; j < nums_c; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    void dfs(char[][] grid, int r, int c) {
        int nums_r = grid.length;
        int nums_c = grid[0].length;

        if (r < 0 || c < 0 || r >= nums_r || c >= nums_c || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
