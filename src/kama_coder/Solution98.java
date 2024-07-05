package kama_coder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution98 {
    public static List<List<Integer>> result = new ArrayList<>();
    public static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] graph = new int[n + 1][n + 1];

        while (m-- > 0) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();

            graph[s][t] = 1;
        }

        path.add(1);
        dfs(graph, 1, n);

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (List<Integer> list : result) {
                for (int i = 0; i < list.size() - 1; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println(list.get(list.size() - 1));
            }
        }

        scanner.close();
    }

    public static void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (graph[x][i] == 1) {
                path.add(i);
                dfs(graph, i, n);
                path.remove(path.size() - 1);
            }
        }
    }
}
