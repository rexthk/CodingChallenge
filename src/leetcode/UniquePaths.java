package leetcode;

/**
 * @author rexthk
 * A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
 * How many possible unique paths are there?
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 1)); // 1
        System.out.println(uniquePaths(1, 2)); // 1
        System.out.println(uniquePaths(3, 2)); // 3
        System.out.println(uniquePaths(7, 3)); // 28
    }

    private static int uniquePaths(int m, int n) {
        if (n <= 0 || m <= 0) return 0;
        if (n == 1 || m == 1) return 1;

        int[][] memo = new int[n][m];

        // base cases
        memo[0][0] = 0;
        for (int i = 1; i < m; i++) memo[0][i] = 1;
        for (int i = 1; i < n; i++) memo[i][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }

        return memo[n - 1][m - 1];
    }
}
