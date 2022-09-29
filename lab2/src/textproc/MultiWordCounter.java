package textproc;

import java.util.HashMap;

public class MultiWordCounter implements TextProcessor {
    HashMap<String,Integer> words = new HashMap<String,Integer>();

    public MultiWordCounter(String[] words) {
        for (String s : words) {
            this.words.put(s, 0);
        }
    }

    public void process(String word) {
		for (String key : words.keySet())  {
            if (key.equals(word)) {
                words.merge(key, 1, Integer::sum);
            }
            
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
