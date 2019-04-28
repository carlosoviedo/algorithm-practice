package crackingcodeinterview.ch1;

public class URLify {
    /**
     * N = realSize
     * Time complexity  = O(N)
     * Space complexity = O(N)
     *
     * @param url
     * @param realSize
     * @return
     */
    public static String encodeSpaces(final String url, final int realSize) {
        final char[] urlChars = url.toCharArray();
        int extraChars = url.length() - realSize;
        for (int i = realSize - 1; i >= 0; i--) {
            if (urlChars[i] != ' ') {
                urlChars[i + extraChars] = urlChars[i];
                urlChars[i] = ' ';
            } else {
                urlChars[i + extraChars] = '0';
                urlChars[i + extraChars - 1] = '2';
                urlChars[i + extraChars - 2] = '%';
                extraChars -= 2;

                if (extraChars == 0) {
                    break;
                }
            }
        }
        return new String(urlChars);
    }
}
