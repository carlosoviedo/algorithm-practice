package crackingcodeinterview.ch1;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class UniqueLettersTest {
    private static final String UNIQUE_LETTERS_STR = "xpwkolahygftcnm";
    private static final String NONUNIQUE_LETTERS_STR = "dfadfiorbjdskab";

    @Test
    public void isUnique() {
        isUniqueGeneric(UniqueLetters::isUnique);
    }

    @Test
    public void isUniqueNoMap() {
        isUniqueGeneric(UniqueLetters::isUniqueNoMap);
    }

    @Test
    public void isUniqueAscii() {
        isUniqueGeneric(UniqueLetters::isUniqueAscii);
    }

    private static void isUniqueGeneric(final Function<String, Boolean> fUnique) {
        final String errorMessage = "Unique letters with dictionary failed";

        boolean actual = fUnique.apply(UNIQUE_LETTERS_STR);
        assertThat(errorMessage, actual, is(true));

        actual = fUnique.apply(NONUNIQUE_LETTERS_STR);
        assertThat(errorMessage, actual, is(false));
    }
}