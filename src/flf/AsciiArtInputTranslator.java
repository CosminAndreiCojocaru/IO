package flf;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;


public class AsciiArtInputTranslator implements AutoCloseable {
    private Reader reader;
    private Map<Character, List<String>> dictionary;

    public AsciiArtInputTranslator(Reader reader, Map<Character, List<String>> dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public List<String> read() throws IOException {
        int character = reader.read();
//        if (character == -1) {
//            return null;
//        } else {
//            return dictionary.get(character);
//        }

        return character == -1 ? null : dictionary.get((char)character);
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
