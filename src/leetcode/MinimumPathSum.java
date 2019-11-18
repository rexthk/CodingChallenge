package leetcode;

/**
 * @author rexthk
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(input));
    }

    private static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] memo = new int[m][n];
        memo[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            memo[i][0] = memo[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            memo[0][i] = memo[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = grid[i][j] + Math.min(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        return memo[m - 1][n - 1];
    }
}
