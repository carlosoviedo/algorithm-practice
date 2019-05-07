package leetcode.contest.n135.boomerang;

public class Solution {
    public boolean isBoomerang(int[][] points) {
        int xleft, xmiddle, xright, yleft, ymiddle, yright;

        // Assign left
        xleft = points[0][0];
        yleft = points[0][1];

        // Assign middle
        if (points[1][0] < xleft) {
            xmiddle = xleft;
            ymiddle = yleft;
            xleft = points[1][0];
            yleft = points[1][1];
        } else {
            xmiddle = points[1][0];
            ymiddle = points[1][1];
        }

        // Assign right
        if (points[2][0] < xleft) {
            xright = xmiddle;
            yright = ymiddle;
            xmiddle = xleft;
            ymiddle = yleft;
            xleft = points[2][0];
            yleft = points[2][1];
        } else if (points[2][0] < xmiddle) {
            xright = xmiddle;
            yright = ymiddle;
            xmiddle = points[2][0];
            ymiddle = points[2][1];
        } else {
            xright = points[2][0];
            yright = points[2][1];
        }

        boolean straightLine = yleft == ymiddle && ymiddle == yright ||
            xleft == xmiddle && xmiddle == xright ||
            (xmiddle - xleft == xright - xmiddle && ymiddle - yleft == yright - ymiddle);
        return !straightLine && !(xleft == xmiddle && yleft == ymiddle) && !(xmiddle == xright && ymiddle == yright)
                && !(xleft == xright && yleft == yright);
    }
}
