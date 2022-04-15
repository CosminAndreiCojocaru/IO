package flf;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlfReader {

    public static Map<Character, List<String>> getDictionary(Path path) {

        Map<Character, List<String>> mappings = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            FlfHeader header = readHeader(reader);
//            System.out.println(header);
            skipLines(reader, header.getCommentLines());
            for (int i = 32; i <= 126; i++) {
                Character c = (char) i;
                mappings.put(c, readAsciiArtCharacter(reader, header.getHeight()));
            }

        } catch (IOException x) {
            System.err.println("IOException: " + x);
        }
        return mappings;
    }

    public static Map<Character, StringBlock> flfCharacters(Path path) {

        Map<Character, StringBlock> mappings = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            FlfHeader header = readHeader(reader);
            skipLines(reader, header.getCommentLines());
            for (int i = 32; i <= 126; i++) {
                Character c = (char) i;
                mappings.put(c, new StringBlock(readAsciiArtCharacter(reader, header.getHeight())));
            }

        } catch (IOException x) {
            System.err.println("IOException: " + x);
        }
        return mappings;
    }


    private static FlfHeader readHeader(BufferedReader reader)
            throws IOException {
        //read line (or use Scanner)
        //split line (or use Scanner)
        //create and populate FlfHeader object
        String headerLine = reader.readLine();
        String[] tokens = headerLine.split(" ");
        char hardBlank = tokens[0].charAt(tokens[0].length() - 1);
        int height = Integer.parseInt(tokens[1]);
        int commentedLines = Integer.parseInt(tokens[5]);
        return new FlfHeader(hardBlank, height, commentedLines);
    }

    private static void skipLines(BufferedReader reader, int lineCount) throws IOException {
        //read "lineCount" number of lines
        //from reader and ignore the results
        for (int i = 0; i < lineCount; ++i) {
            reader.readLine();
        }
    }

    public static void printAsciiArtCharacter(List<String> asciiArtCharacter) {
        for (String line : asciiArtCharacter) {
            System.out.println(line);
        }
    }

    private static List<String> readAsciiArtCharacter(BufferedReader reader, int lineCount) throws IOException {
        //read "lineCount" number of lines
        //from reader and add the results to a list
        List<String> asciiCharacter = new ArrayList<>();
        for (int i = 0; i < lineCount; ++i) {
            String line = reader.readLine();
            line = line.replace("$", " ");
            line = line.replace("@", "");
            System.out.println(line);
            //     line.replace(characterul pe care vrem sa-l inlocuim, caracterul cu care o sa fie inlocuit )
            asciiCharacter.add(line);
        }
        return asciiCharacter;
    }
}
