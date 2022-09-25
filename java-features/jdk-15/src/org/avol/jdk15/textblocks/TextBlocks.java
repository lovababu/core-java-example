package org.avol.jdk15.textblocks;

public class TextBlocks {

    public static void main(String[] args) {

        String jsonWithEscape = "{\"Hello\":\"World.\"}";  // prior to JDK 15, too many escape characters too difficulty to define.

        String jsonWithTextBlock = """
                    {"Hello":"World."}
                """;   // with text block 'enclosed with three double quotes'

        System.out.println(jsonWithEscape);
        System.out.println(jsonWithTextBlock);
    }
}
