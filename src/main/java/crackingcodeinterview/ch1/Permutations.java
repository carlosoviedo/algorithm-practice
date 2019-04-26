package crackingcodeinterview.ch1;

import java.util.HashMap;
import java.util.Map;

public class Permutations {
    /**
     * N = (thisStr || thatStr).length()
     * Time complexity: O(N)
     * Space complexity: O(N)
     *
     * @param thisStr
     * @param thatStr
     * @return
     */
    public static boolean isPermutation(final String thisStr, final String thatStr) {
        if (thisStr == null || thatStr == null || thisStr.length() != thatStr.length()) {
            return false;
        }

        Character current;
        Integer found;
        final Map<Character, Integer> occurrences = new HashMap<>(thisStr.length() * 100 / 75 + 1);

        for (int i = 0; i < thisStr.length(); i++) {    // O(N)
            current = thisStr.charAt(i);
            found = occurrences.getOrDefault(current, 0);
            occurrences.put(current, found + 1);
        }

        boolean different = false;
        for (int i = 0; i < thatStr.length(); i++) {
            current = thatStr.charAt(i);
            different |= current != thisStr.charAt(i);
            found = occurrences.get(current);
            if (found == null) {
                return false;
            } else if (found == 1) {
                occurrences.remove(current);
            } else {
                occurrences.put(current, found - 1);
            }
        }
        return different && occurrences.isEmpty();
    }
}
