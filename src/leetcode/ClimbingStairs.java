package leetcode;

/**
 * @author rexthk
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(1)); // 1
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(3)); // 3
        System.out.println(climbStairs(4)); // 5
    }

    private static int climbStairs(int n) {
        if (n == 0) return 0;
        if (n <= 2) return n;

        int a = 1, b = 2, ans = 0;

        for (int i = 2; i < n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }
        return ans;
    }
}
