package leetcode.contest.n135.boomerang;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void testIsBoomerang() {
        testBoomerang(new int[][]{{1,1},{2,3},{3,2}}, true, "Boomerang not detected");

    }

    @Test
    public void testIsNotBoomerang() {
        testBoomerang(new int[][]{{0,0},{1,1},{1,1}}, false, "Boomerang detected");
    }

    private void testBoomerang(final int[][] points, final boolean expected, final String errorMessage) {
        assertThat(errorMessage, solution.isBoomerang(points), is(expected));
    }
}