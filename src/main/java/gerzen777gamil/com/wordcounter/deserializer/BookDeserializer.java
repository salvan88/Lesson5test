package gerzen777gamil.com.wordcounter.deserializer;

import gerzen777gamil.com.wordcounter.model.AllWords;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class BookDeserializer {

    public Map<String, Integer> deserializer(File file) throws IOException {

        Path path = Paths.get(file.getName());

        AllWords words = new AllWords();

        List<String> fileLines = Files.readAllLines(path);

        for (String line : fileLines) {

            ArrayList<String> thisLine = new ArrayList<>(Arrays.asList(line.split("[\\p{Z}\\p{P}\\p{N}\\p{C}\\p{S}]+")));

            for (String element : thisLine) {
                if(words.getWords().containsKey(element.toLowerCase())) {
                    int number = words.getWords().get(element.toLowerCase());
                    words.getWords().put(element.toLowerCase(), ++number);
                } else {
                    words.getWords().put(element.toLowerCase(), 1);
                }
            }
        }

        return words.getWords().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}