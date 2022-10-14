package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookReaderApplication {
    public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
    "halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
    "södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
    "öland", "östergötland" };

    public static void main(String[] args) throws FileNotFoundException {

        Set<String> stopwords = new HashSet<String>();
        Scanner scan = new Scanner(new File("lab2/undantagsord.txt"), "UTF-8");
        while (scan.hasNext()) {
            stopwords.add(scan.next().toLowerCase());
        }
        scan.close();

        GeneralWordCounter gWCounter = new GeneralWordCounter(stopwords);
        BookReaderController bRController = new BookReaderController(gWCounter);

        Scanner s = new Scanner(new File("lab2/nilsholg.txt"), "UTF-8");
        s.findWithinHorizon("\uFEFF", 1);
        s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
        while (s.hasNext()) {
            String word = s.next().toLowerCase();
            gWCounter.process(word);
        }

        s.close();
    }
}
