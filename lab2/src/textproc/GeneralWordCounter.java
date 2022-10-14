package textproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor {
    Map<String,Integer> words = new HashMap<String,Integer>();
    Set<String> stopwords = new HashSet<String>();

    public GeneralWordCounter(Set<String> stopwords) {
        this.stopwords=stopwords;
    }

    public void process(String word) {
		if (!(stopwords.contains(word))) {
            if (words.containsKey(word)) {
                words.merge(word, 1, Integer::sum);
            } else {
                words.put(word, 1);
            }
        }
	}

    public List<Map.Entry<String, Integer>> getWordList() {
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(words.entrySet());
        return wordList;
        }
        

    public void report() {
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(words.entrySet());
        wordList.sort((w1 , w2) -> w1.getKey().compareTo(w2.getKey())); 
        wordList.sort((w1 , w2) -> w2.getValue()-w1.getValue());   //falling by amount then rising name

        System.out.println("-----------------------------");
        for (int i =0; i<10; i++) {
            System.out.println(wordList.get(i));
        }
        System.out.println("-----------------------------");
	}
}

