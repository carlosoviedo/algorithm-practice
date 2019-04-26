package crackingcodeinterview.ch1;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PermutationsTest {
    @Test
    public void isPermutation() {
        checkPermutation("mood", "doom", true);
        checkPermutation("apple", "papel", true);
        checkPermutation("hello", "llloh", false);
    }

    private static void checkPermutation(final String thisStr, final String thatStr, final boolean expected) {
        boolean result = Permutations.isPermutation(thisStr, thatStr);
        assertThat("Unexpected result", result, is(expected));
    }
}