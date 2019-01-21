package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and an integer k, break up the string into multiple texts such that each text has a length of k or less.
 * You must break it up so that words don't break across lines. If there's no way to break the text up, then return null.
 * You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.
 * For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return:
 * ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.
 */

public class Problem57 {
    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog";
        Arrays.stream(breakup(text)).forEach(System.out::println);
    }

    private static String[] breakup(String text) {
        if (text.isBlank()) return new String[]{};

        String[] split = text.split(" ");

        List<String> result = new ArrayList<>();
        var builder = new StringBuilder();
        int i;
        for (i = 0; i < split.length; ) {
            if (split[i].length() + builder.length() + 1 <= 10) {
                if (builder.length() > 0) builder.append(" ");
                builder.append(split[i]);
                i++;
            } else {
                result.add(builder.toString());
                builder = new StringBuilder();
            }
        }

        if (builder.length() > 0) result.add(builder.toString());

        return result.toArray(new String[0]);
    }
}
