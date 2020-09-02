package gerzen777gamil.com.wordcounter.deserializer;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class DeserializerTest {

    @Test
    public void bookDeserializer() throws IOException {

        BookDeserializer bookDeserializer = new BookDeserializer();
        Map<String, Integer> words = bookDeserializer.deserializer(new File("book.txt"));

        System.out.println(words);
    }
}