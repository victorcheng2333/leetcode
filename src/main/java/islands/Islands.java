package islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://sysmo.addev.com/flow/manage
 * 岛屿问题 - 岛屿数量
 * 参考1：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 * 参考2：https://leetcode-cn.com/problems/number-of-islands/solution/number-of-islands-shen-du-you-xian-bian-li-dfs-or-/
 */
public class Islands {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid[0] == null) return count;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    // 广度优先遍历
    void bfs(char[][] grid, int i, int j) {
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[]{i, j});
        while (!list.isEmpty()) {
            int[] cur = list.remove();
            i = cur[0]; j = cur[1];
            if (inArea(grid, i, j) && grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[] {i+1, j});
                list.add(new int[] {i-1, j});
                list.add(new int[] {i, j+1});
                list.add(new int[] {i, j-1});
            }
        }
    }

    // 深度优先遍历
    void dfs(char[][] grid, int i, int j) {
        if (!inArea(grid, i, j) || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    static boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

}
