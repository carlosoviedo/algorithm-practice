package crackingcodeinterview.ch1;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class URLifyTest {
    @Test
    public void encodeSpaces() {
        final String errorMessage = "Unescaping failed";

        String unescapedUrl = "Mr John Smith    ",
                expected = "Mr%20John%20Smith";
        assertThat(errorMessage, URLify.encodeSpaces(unescapedUrl, 13), is(expected));

        unescapedUrl = "This is fine, thank you        ";
        expected = "This%20is%20fine,%20thank%20you";
        assertThat(errorMessage, URLify.encodeSpaces(unescapedUrl, 23), is(expected));
    }
}