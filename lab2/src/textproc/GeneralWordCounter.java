package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GeneralWordCounter implements TextProcessor {
    HashMap<String,Integer> words = new HashMap<String,Integer>();
    Set<String> stopwords = new TreeSet<String>();

    public GeneralWordCounter() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("lab2/undantagsord.txt"), "UTF-8");
        while (scan.hasNext()) {
			stopwords.add(scan.next().toLowerCase());
		}
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

    public void report() {
        /* for (String key : words.keySet())  {
            if (words.get(key)>=200) {
                System.out.println(key + ": " + words.get(key));
            }
        } */
        
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(words.entrySet());
        wordList.sort( (w1 , w2) -> { //falling by amount then rising name
            if (w2.getValue()-w1.getValue()==0) {
                return w1.getKey().compareTo(w2.getKey());
            } else {
                return w2.getValue()-w1.getValue();
            }
        });


        System.out.println("-----------------------------");
        for (int i =0; i<10; i++) {
            System.out.println(wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
        }
        System.out.println("-----------------------------");
	}
}

