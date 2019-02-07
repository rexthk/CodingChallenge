package leetcode;

/**
 * @author rexthk
 * Given a string, find the length of the longest substring without repeating characters.
 */

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("ibaz"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("   "));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int leftIndex = 0; // sliding window left index
        int result = 0;
        int[] charCount = new int[256]; // use ASCII array to record char occurrence in order to save memory

        for (int rightIndex = 0; rightIndex < s.length(); ) {
            if (charCount[s.charAt(rightIndex)] > 0) {
                // if the count for the rightmost char is > 0, reduce the left window and decrease the charCount for that leftmost char
                // in another words, maintain all count equal to 1
                charCount[s.charAt(leftIndex++)]--;
                continue;
            }
            charCount[s.charAt(rightIndex++)]++; // else, we can enlarge the window as large as possible, and record the charCount

            int currentLength = rightIndex - leftIndex;
            result = currentLength > result ? currentLength : result; // keep track the new increased window size
        }

        return result;
    }
}
