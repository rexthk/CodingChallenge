package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rexthk
 * Given a string, find the length of the longest substring without repeating characters.
 */

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int leftIndex = 0; // sliding window left index
        int result = 0;
        Set<Character> set = new HashSet<>();

        for (int rightIndex = 0; rightIndex < s.length(); ) {
            if (set.contains(s.charAt(rightIndex))) { // if the set already contains the char, reduce the left window
                set.remove(s.charAt(leftIndex++));
                continue;
            }
            set.add(s.charAt(rightIndex++)); // else, we can enlarge the window as large as possible

            int currentLength = rightIndex - leftIndex;
            result = currentLength > result ? currentLength : result; // keep track the new increased window size
        }

        return result;
    }
}
