package textproc;

public class SingleWordCounter implements TextProcessor {
	private String word;
	private int n;

	public SingleWordCounter(String word) {
		this.word = word;
		n = 0;
	}

	public void process(String w) {
		if (w.equals(word)) {
			n++;
		}
	}

	public String[] report() {
		String[] result = new String[1];
		result[0] = word + ": " + n;
        return result;
	}

}
