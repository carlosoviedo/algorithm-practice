package crackingcodeinterview.ch1;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PalindromePermutationTest {
    private static final String NOT_DETECTED = "Palindrome not detected";
    private static final String DETECTED = "Palindrome detected";

    @Test
    public void isPalindromePermutation() {
        String permutation = "em r,iueR ,sdr dimr rus";
        assertThat(NOT_DETECTED, PalindromePermutation.isPalindromePermutation(permutation), is(true));

        permutation = "va Iee e ni aces sEav, cab? ne";
        assertThat(NOT_DETECTED, PalindromePermutation.isPalindromePermutation(permutation), is(true));
    }

    @Test
    public void isNotPalindromePermutation() {
        String notPermutation = "This is not a palindrome permutation";
        assertThat(DETECTED, PalindromePermutation.isPalindromePermutation(notPermutation), is(false));

        notPermutation = "Another example of not a permutation";
        assertThat(DETECTED, PalindromePermutation.isPalindromePermutation(notPermutation), is(false));
    }

    @Test
    public void palindromePermutationTestsFromCTCI() {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda"};

        assertThat(NOT_DETECTED, PalindromePermutation.isPalindromePermutation(strings[0]), is(true));
        assertThat(NOT_DETECTED, PalindromePermutation.isPalindromePermutation(strings[1]), is(true));
        assertThat(NOT_DETECTED, PalindromePermutation.isPalindromePermutation(strings[2]), is(true));
        assertThat(NOT_DETECTED, PalindromePermutation.isPalindromePermutation(strings[3]), is(true));
        assertThat(DETECTED, PalindromePermutation.isPalindromePermutation(strings[4]), is(false));
    }
}