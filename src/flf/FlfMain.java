package flf;

import org.apache.groovy.json.internal.Value;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.security.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.awt.Font;
import java.io.InputStream;

public class FlfMain {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> languages = new HashMap<>();
        Path filePath = Paths.get("resource", "bulbhead.flf");
        Path file = FileSystems.getDefault().getPath("resource", "bulbhead.flf");
        BasicFileAttributeView basicview = Files.getFileAttributeView(file, BasicFileAttributeView.class);

//        Map<Character, List<String>> dictionary = FlfReader.getDictionary(filePath);
        Map<Character, StringBlock> flfCharacters = FlfReader.flfCharacters(filePath);
        Map<Character, List<String>> dictionary1 = FlfReader.getDictionary(file);

        StringBlock sbH = flfCharacters.get('H');
        StringBlock sbI = flfCharacters.get('I');
        StringBlock sbExcl = flfCharacters.get('!');

        System.out.println(sbH.concat(sbI).concat(sbExcl));
        System.out.println(basicview);

//        try (FileReader fd = new FileReader("resource/in.txt");
//             BufferedReader bf = new BufferedReader(fd);
//             AsciiArtInputTranslator translator = new AsciiArtInputTranslator(bf, dictionary)) {
//            List<String> asciiArtCharacter;
//            while ((asciiArtCharacter = translator.read()) != null) {
//                FlfReader.printAsciiArtCharacter(asciiArtCharacter);
//            }

//        } catch (Exception e) {
//            System.out.println("Error");
//            e.printStackTrace();
////        }\n (enter) are codul ascii 10
//            System.out.println((int) '\n');
//
//        }
        File source = new File("resource/in.txt");
        File destination = new File("resource/out.txt");
        FileInputStream inputStream = new FileInputStream(source);
        FileOutputStream outputStream = new FileOutputStream(destination);
        int length = (int) source.length();
        byte[] buffer = new byte[length];

        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);

        }



    }

    }
