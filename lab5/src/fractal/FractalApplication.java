package fractal;

import koch.Koch;
import mountain.Mountain;
import tree.Tree;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[3];
		fractals[2] = new Mountain(300, 20.0);
		fractals[1] = new Koch(300);
		fractals[0] = new Tree(180,90,30.0);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
