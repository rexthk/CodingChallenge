package leetcode;

/**
 * @author rexthk
 * A robot is located at the top-left corner of a m x n grid
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(input));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) return 0;

        int[][] memo = new int[m][n];
        memo[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                if (n == 1) return 0;
                memo[i][0] = 0;
            } else memo[i][0] = memo[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                if (m == 1) return 0;
                memo[0][i] = 0;
            }
            memo[0][i] = obstacleGrid[0][i] == 1 ? 0 : memo[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) memo[i][j] = 0;
                else memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
        return memo[m - 1][n - 1];
    }
}
