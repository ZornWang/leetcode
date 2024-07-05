package problems_701_800;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution797 {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new Solution797().allPathsSourceTarget(graph).toString());
    }

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.push(0);
        dfs(graph, 0, graph.length - 1);
        return result;
    }

    void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i : graph[x]) {
            path.push(i);
            dfs(graph, i, n);
            path.pop();
        }
    }
}
