package leetcode;

/**
 * @author rexthk
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}));

    }

    private static int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int i = 0;
        int j = height.length - 1;
        int max = 0;

        while (i < j) {
            int smaller = height[i] < height[j] ? i : j;
            int area = (j - i) * height[smaller];
            max = Math.max(area, max);

            if (height[i] > height[j]) j--;
            else i++;
        }

        return max;
    }
}
