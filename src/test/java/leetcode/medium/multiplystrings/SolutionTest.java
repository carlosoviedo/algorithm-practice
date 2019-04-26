package leetcode.medium.multiplystrings;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SolutionTest {

    private static Solution solution = new Solution();

    @Test
    public void multiply() {
        final String errorMsg = "Bad multiplication";
        String actual = solution.multiply("123", "456");
        assertThat(errorMsg, actual, is("56088"));
        actual = solution.multiply("8361594", "108273");
        assertThat(errorMsg, actual, is("905334867162"));
        actual = solution.multiply("9", "9");
        assertThat(errorMsg, actual, is("81"));
        actual = solution.multiply("333", "333");
        assertThat(errorMsg, actual, is("110889"));
    }
}