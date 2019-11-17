package work;

/**
 * @author rexthk
 * Given an array of multipliers, numOfDraw, pass.
 * in each turn, the current multiplier will be added in the result,
 * and then you can choose either move to the next multiplier, or reset the multiplier to the first one.
 * if you move to the next multiplier, the numOfDraw will be decreased by 1;
 * if you deceide to reset the multiplier, the numOfDraw will be decrease by 1 + pass;
 * if the current multiplier is the last one in the array, you are forced to reset it.
 * starting from the first multiplier, while numOfDrawm > 0, find the maximum possible sum of multipliers
 */
public class CircularAutoBetMaxPossibleStake {
    public static void main(String[] args) {
        System.out.println(maxStakeBottomUp(new int[]{1, 2, 3, 4, 5}, 100, 20)); // 60
        System.out.println(maxStakeBottomUp(new int[]{1, 10, 1, 1, 1}, 100, 2)); // 277
        System.out.println(maxStakeBottomUp(new int[]{2, 4, 9, 5, 2, 3, 11}, 100, 2)); // 400
    }

    private static int maxStakeBottomUp(int[] multipliers, int numOfDraw, int pass) {
        if (multipliers == null || multipliers.length == 0) return 0;
        if (pass < 0) throw new Error();
        int[][] memo = new int[multipliers.length][numOfDraw];
        for (int i = 0; i < multipliers.length; i++) {
            memo[i][0] = multipliers[i]; // fill up base cases
        }
        int max = 0;
        for (int d = 1; d < numOfDraw; d++) {
            for (int m = 0; m < multipliers.length; m++) {
                int val1 = m + 1 == multipliers.length ? 0 : memo[m + 1][d - 1];
                int val2 = d - pass - 1 < 0 ? 0 : memo[0][d - pass - 1];
                memo[m][d] = d > numOfDraw - m ? 0 : multipliers[m] + Math.max(val1, val2);
                max = Math.max(max, memo[m][d]); // track max value
            }
        }
        return max;
    }

    private static int maxStakeTopDown(int[] multipliers, int numOfDraw, int pass) {
        if (multipliers == null || multipliers.length == 0) return 0;
        if (pass < 0) throw new Error();
        int[][] memo = new int[multipliers.length][numOfDraw];
        return maxStakeTopDown(0, multipliers, numOfDraw, pass, memo);
    }

    private static int maxStakeTopDown(int i, int[] multipliers, int numOfDraw, int pass, int[][] memo) {
        if (numOfDraw <= 0) return 0;
        if (i == multipliers.length - 1) {
            return multipliers[i] + maxStakeTopDown(0, multipliers, numOfDraw - 1 - pass, pass, memo);
        }
        int result = memo[i][numOfDraw - 1];
        if (result == 0) {
            if (numOfDraw == 1) result = multipliers[i];
            else {
                result = multipliers[i] + Math.max(maxStakeTopDown(i + 1, multipliers, numOfDraw - 1, pass, memo), maxStakeTopDown(0, multipliers, numOfDraw - 1 - pass, pass, memo));
            }
            memo[i][numOfDraw - 1] = result;
        }
        return result;
    }
}
