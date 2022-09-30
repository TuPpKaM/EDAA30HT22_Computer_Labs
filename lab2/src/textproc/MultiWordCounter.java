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
        if (words.containsKey(word)) {
            words.merge(word, 1, Integer::sum);
        }
	}

    public String[] report() {
        String[] result = new String[words.size()];
        int i = 0;
        for (String key : words.keySet())  {
            result[i] = key + ": " + words.get(key);
            i++;
        }
        return result;
	}
}
