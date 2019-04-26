package crackingcodeinterview.ch1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueLetters {
    /**
     * N = str.length()
     * Time complexity: O(N)
     * Space complexity: O(N)
     *
     * @param str
     * @return
     */
    public static boolean isUnique(final String str) {
        final int size = str.length() * 100 / 75 + 1;
        final Map<Character, Boolean> dict = new HashMap<>(size);
        for (char c : str.toCharArray()) {
            if (dict.containsKey(c)) {
                return false;
            }
            dict.put(c, true);
        }
        return true;
    }

    /**
     * N = str.length()
     * Time complexity: O(NLOGN)
     * Space complexity: O(N)
     *
     * @param str
     * @return
     */
    public static boolean isUniqueNoMap(final String str) {
        final char[] chars = str.toCharArray();
        Arrays.sort(chars);
        char prev = 0;
        for (char c : chars) {
            if (prev == c) {
                return false;
            }
            prev = c;
        }
        return true;
    }

    /**
     * N = str.length()
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param str
     * @return
     */
    public static boolean isUniqueAscii(final String str) {
        int unique = 0, charOffset;
        for (int i = 0; i < str.length(); i++) {
            charOffset = str.charAt(i) - 'a';
            if ((unique & (1 << charOffset)) != 0) {
                return false;
            }
            unique |= 1 << charOffset;
        }
        return true; 
    }
}
