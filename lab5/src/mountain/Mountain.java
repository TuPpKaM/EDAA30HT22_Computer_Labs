package mountain;

import java.util.HashMap;

import fractal.*;

public class Mountain extends Fractal {
    int length;
    Double dev;
    HashMap<Side, Point> middles;

    /** Creates an object that handles Mountain's fractal. 
	 * @param length the length of the triangle side
     * @param dev the start value for calucating offset in the y-axis 
	 */
	public Mountain(int length, Double dev) {
		super();
		this.length = length;
        this.dev = dev;
        middles = new HashMap<Side, Point>();
	}

    /**
	 * Returns the title.
	 * @return the title
	 */
    @Override
    public String getTitle() {
        return "Mountain";
    }

    /** Draws the fractal.  
	 * @param turtle the turtle graphic object
	 */
    @Override
	public void draw(TurtleGraphics turtle) {
        Point p1 = new Point(150,429); //triangle , length 300 , a bit rotated
        Point p2 = new Point(450,379);
        Point p3 = new Point(350,119);

        turtle.penDown();
		fractalTriangle(turtle,order,length,p1,p2,p3,dev);
        turtle.penUp();
	}

	/** 
	 * Reursive method: Draws a recursive triangle inside triangle.
     * @param turtle the turtle graphic object
     * @param order the order of fractal
     * @param length the length of a side int he triangle
     * @param p1 the first corner of the outer triangle
     * @param p2 the secound corner of the outer triangle 
     * @param p3 the third corner of the outer triangle 
     * @param dev the start value for calucating offset in the y-axis 
	 */
	private void fractalTriangle(TurtleGraphics turtle, int order, int length, Point p1, Point p2, Point p3, Double dev) {
		if (order == 0) {
            turtle.moveTo(p1.getX(), p1.getY());     //start in 1 and then draw to 2, then to 3 and back to 1
		    turtle.forwardTo(p2.getX(),p2.getY());
            turtle.forwardTo(p3.getX(),p3.getY());
            turtle.forwardTo(p1.getX(),p1.getY());
		} else {
            Point p12 = checkMiddle(p1, p2, dev);
            Point p23 = checkMiddle(p2, p3, dev);
            Point p13 = checkMiddle(p1, p3, dev);

            fractalTriangle(turtle, order-1, length/2, p1, p12, p13, dev/2); // draws from corner 1 out to 2 and 3
            fractalTriangle(turtle, order-1, length/2, p12, p2, p23, dev/2); // draws from corner 2 out to 1 and 3
            fractalTriangle(turtle, order-1, length/2, p13, p23, p3, dev/2); // draws from corner 3 out to 1 and 2
            fractalTriangle(turtle, order-1, length/2, p12, p23, p13, dev/2); //center triangle connects them all up
        }
	}
    /** 
	 * Help method: Check if an exissting middle could be used for the side, otherwise makes a new one.
     * @param p1 the startpoint of the side
     * @param p2 the sendpoint of the side
     * @param dev the value used to calculate the offset
     * @return the middlepoint between p1 and p2
     */ 
    private Point checkMiddle(Point p1, Point p2, Double dev){
        Side side = new Side(p1,p2);
        if (middles.containsKey(side)) { //middle already exist for side, use existing point
            Point oldMiddleP = middles.get(side);
            middles.remove(side); //remove used side-point pair
            return oldMiddleP;

        } else { //middle doesn't exist, create a new one with offset
            int x = (p1.getX()+p2.getX())/2;
            int y = (int) (((p1.getY()+p2.getY())/2) + RandomUtilities.randFunc(dev));

            Point newMiddleP = new Point(x, y);
            middles.put(side, newMiddleP); //save new side-point pair in map
            return newMiddleP;
        }
    }
    
}
