package tree;

import fractal.*;
import mountain.Point;
import java.awt.Color;
 

public class Tree extends Fractal {
    private int length;
    private int alpha;
    private Double dev;
    private String[] colors;
    
    public Tree(int length, int alpha, Double dev) {
        super();
        this.length = length;
        this.alpha = alpha;
        this.dev = dev;
        colors = new String[]{"#3e2723", "#3e2723", "#5d4037", "#5d4037", "#a1887f", "#a1887f", "#1b5e20", "#1b5e20", "#388e3c", "#388e3c", "#4caf50", "#81c784"};
    }

    @Override
    public String getTitle() {
        return "Tree";
    }

    @Override
    public void draw(TurtleGraphics g) {
        Point start = new Point(300,550);

        g.moveTo(0, 500);
        g.penDown();
        g.forwardTo(600, 500);
        fractalTree(g,start, order, length, alpha);
        
    }

    private void fractalTree(TurtleGraphics turtle, Point point, int order2, int length, double alpha){
        turtle.setColor(Color.decode(colors[order-order2]));

        if (order2 == 0) {
            turtle.moveTo(point.getX(), point.getY());
            turtle.setDirection(alpha);
			turtle.forward(length);
        } else {
            turtle.moveTo(point.getX(), point.getY());
            turtle.setDirection(alpha);
			turtle.forward(length);
            Point newPoint = new Point((int) (turtle.getX()),(int) (turtle.getY()));
            fractalTree(turtle, newPoint, order2-1, (int) ( length*0.67 ),alpha-dev);
            fractalTree(turtle, newPoint, order2-1, (int) ( length*0.67 ),alpha+dev);
            fractalTree(turtle, newPoint, order2-1, (int) ( length*0.33 ),alpha-(2 *dev));
            fractalTree(turtle, newPoint, order2-1, (int) ( length*0.33 ),alpha+(2* dev));
        }

    }
}
