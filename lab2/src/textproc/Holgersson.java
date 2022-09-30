package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();

		ArrayList<TextProcessor> proList = new ArrayList<TextProcessor>();
		proList.add(new SingleWordCounter("nils"));
		proList.add(new SingleWordCounter("norge"));
		//proList.add(new MultiWordCounter(REGIONS));
		proList.add(new GeneralWordCounter());

		Scanner s = new Scanner(new File("lab2/nilsholg.txt"), "UTF-8");
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			for (TextProcessor p : proList) {
				p.process(word);
			}
		}

		s.close();
		/* for (TextProcessor p : proList) {
			p.report();
		} */
		
		long t1 = System.nanoTime();
		TreeMap<String,String[]> displayU = new TreeMap<String,String[]>();
		String[] timeResult = {(t1-t0)/1000000.0+" s"};
		displayU.put("Time:", timeResult);
		displayU.put("1 Results:", proList.get(0).report());
		displayU.put("2 Results:", proList.get(1).report());
		displayU.put("3 Results:", proList.get(2).report());

		UserView u = new UserView("Result display", displayU);
	}
}