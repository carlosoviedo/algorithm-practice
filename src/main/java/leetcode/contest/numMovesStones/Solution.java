package leetcode.contest.numMovesStones;

public class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int x = Integer.MAX_VALUE, z = 0, y;

        if (a < x) {
            x = a;
        }
        if (b < x) {
            x = b;
        }
        if (c < x) {
            x = c;
        }

        if (a > z) {
            z = a;
        }
        if (b > z) {
            z = b;
        }
        if (c > z) {
            z = c;
        }

        y = a != x && a != z ? a
            : b != x && b != z ? b
            : c;

        // Check out which is further away to get the max moves from it
        int lgap = y - x - 1,
            lmin = lgap > 0 ? 1 : 0,
            rgap = z - y - 1,
            rmin = rgap > 0 ? 1 : 0,
            min = lgap == 1 || rgap == 1 ? 1 : lmin + rmin,
            max = lgap + rgap;

        return new int[]{min,max};
    }
}
