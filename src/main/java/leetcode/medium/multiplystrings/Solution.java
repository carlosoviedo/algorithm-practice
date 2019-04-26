package leetcode.medium.multiplystrings;

class Solution {
    private static final String ZERO = "0";
    private static final String ONE = "1";

    public String multiply(String num1, String num2) {
        if (ZERO.equals(num1) || ZERO.equals(num2)) {
            return "0";
        } else if (ONE.equals(num1)) {
            return num2;
        } else if (ONE.equals(num2)) {
            return num1;
        } else {
            final byte[][] multMatrix = createMultMatrix(num1, num2);
            return sum(multMatrix);
        }
    }

    private static byte[][] createMultMatrix(final String num1, final String num2) {
        final int num1Digits = num1.length(), num2Digits = num2.length(),
                numTotalDigits = num1Digits + num2Digits;
        final byte[][] multMatrix = new byte[num2Digits][numTotalDigits];
        int digit1, digit2, partialDigit, row, carry = 0;

        for (int i = num2Digits - 1; i >= 0; i--) {
            digit2 = Character.digit(num2.charAt(i), 10);
            row = num2Digits - i - 1;
            for (int j = num1Digits - 1; j >= 0; j--) {
                digit1 = Character.digit(num1.charAt(j), 10);
                partialDigit = digit1 * digit2 + carry;
                multMatrix[row][i + j + 1] = (byte) (partialDigit % 10);
                carry = partialDigit / 10;
            }

            if (carry > 0) {
                multMatrix[row][i] = (byte) carry;
            }
            carry = 0;
        }
        return multMatrix;
    }

    private static String sum(final byte[][] multMatrix) {
        final int numCols = multMatrix[0].length;
        int partialDigit = 0, carry = 0, digit;
        final char[] result = new char[numCols];

        for (int j = numCols - 1; j >= 0; j--) {
            for (int i = multMatrix.length - 1; i >= 0; i--) {
                partialDigit += multMatrix[i][j];
            }
            partialDigit += carry;
            digit = partialDigit % 10;
            carry = partialDigit / 10;
            result[j] = Character.forDigit(digit, 10);
            partialDigit = 0;
        }

        return result[0] != '0'
            ? new String(result)
            : new String(result, 1, result.length - 1);
    }
}