package base2.mantis.test.utils;

import de.svenjacobs.loremipsum.LoremIpsum;

public class TextMockUtils {
    private static final LoremIpsum loremIpsum = new LoremIpsum();

    public static String getWords(int qty) {
        return loremIpsum.getWords(qty);
    }

    public static String getParagraph() {
        return loremIpsum.getParagraphs(1);
    }
}
