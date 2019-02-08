package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rexthk
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 */
public class Anagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("abacbabc", "abc"));
        System.out.println(findAnagrams("abaacbabc", "abc"));
        System.out.println(findAnagrams("baa", "aa"));
        System.out.println(findAnagrams("ecbeaebabacd", "abc"));
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int leftIndex = 0;
        int hitCount = 0;

        int[] chars = new int[256];
        Arrays.fill(chars, 0);
        for (char c : p.toCharArray()) chars[c]++;

        for (int i = 0; i < s.length(); ) {
            int c = chars[s.charAt(i)];
            if (c == 0) {
                chars[s.charAt(leftIndex++)]++;
                hitCount--;
            } else {
                chars[s.charAt(i++)]--;
                hitCount++;
            }

            if (hitCount == p.length()) {
                result.add(leftIndex);
                chars[s.charAt(leftIndex)]++;
                hitCount--;
                leftIndex++;
            }
        }

        return result;
    }
}
