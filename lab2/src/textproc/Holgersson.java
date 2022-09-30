package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
		proList.add(new MultiWordCounter(REGIONS));
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
		for (TextProcessor p : proList) {
			p.report();
		}

		long t1 = System.nanoTime();
		System.out.println("-----------------------------");
		System.out.println("time: "+ (t1-t0)/1000000.0 +" ms");
		System.out.println("-----------------------------");
		String[] rows = {(t1-t0)/1000000.0+" s"};
		UserView u = new UserView("Results", rows);
	}
}