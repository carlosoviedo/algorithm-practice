package crackingcodeinterview.ch1;

public class PalindromePermutation {
    /**
     * Assumes only ascii characters.
     *
     * Time: O(N)
     * Space: O(1)
     *
     * @param str
     * @return
     */
    public static boolean isPalindromePermutation(final String str) {
        int accumulator = 0, numChars = 0;
        char current;

        // N = str.length()
        // Time: O(N), Space: O(1)
        for (int i = 0; i < str.length(); i++) {
            current = str.charAt(i);
            if (!Character.isLetter(current)) {
                continue;
            }
            if (Character.isUpperCase(current)) {
                current = Character.toLowerCase(current);
            }
            accumulator ^= 1 << current - 'a';
            numChars++;
        }

        // Time: O(1)
        // Space: O(1)
        return numChars % 2 == 0 && accumulator == 0 || numChars % 2 == 1 && hasExactlyOneOne(accumulator);
    }

    /**
     * Time: O(1)
     * Space: O(1)
     *
     * @param value
     * @return
     */
    private static boolean hasExactlyOneOne(final int value) {
        int expected, numOnes = 0;
        for (int i = 0; i < 26; i++) {
            expected = (int) Math.pow(2, i);
            if ((value ^ expected) == 0) {
                numOnes++;
            }
        }
        return numOnes == 1;
    }
}
