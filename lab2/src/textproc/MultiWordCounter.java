package textproc;

import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor {
    Map<String,Integer> words = new HashMap<String,Integer>();

    public MultiWordCounter(String[] words) {
        for (String s : words) {
            this.words.put(s, 0);
        }
    }

    public void process(String word) {
		if (words.containsKey(word)) {
                words.merge(word, 1, Integer::sum);
            }
	}

    public void report() {
        System.out.println("-----------------------------");
        for (String key : words.keySet())  {
            System.out.println(key + ": " + words.get(key));
        }
        System.out.println("-----------------------------");
	}
}
