package gerzen777gamil.com.wordcounter.model;

import java.io.Serializable;
import java.util.*;

public class AllWords implements Serializable {
    private Map<String, Integer> words = new TreeMap<>();

    public Map<String, Integer> getWords() {
        return words;
    }

    public void setWords(Map<String, Integer> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "{" +
                "words:" + words +
                '}';
    }
}
