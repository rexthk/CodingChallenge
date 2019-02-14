package leetcode;

/**
 * @author rexthk
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("adc", "dcda"));
    }

    private static boolean checkInclusion(String s1, String s2) {
        int leftIndex = 0;
        int count = 0;
        int[] chars = new int[26]; // only contain low case letters, we can use a 26 size array to save space
        char[] s1Chars = s1.toCharArray();
        for (char c : s1Chars) chars[c - 'a']++;

        // if we encounter irrelevant char ( char outside s1 ), leftIndex will go beyond i,
        // to tackle this, we will still increase its count/freq, and the next iteration will enter the first if branch to balance it
        for (int i = 0, length = s2.length(); i < length; ) {
            if (chars[s2.charAt(i) - 'a'] > 0) {
                chars[s2.charAt(i) - 'a']--;
                i++;
                count++;

                if (count == s1Chars.length) return true;
            } else {
                chars[s2.charAt(leftIndex) - 'a']++;
                leftIndex++;
                count--;
            }
        }

        return false;
    }
}
