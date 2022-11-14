package mountain;

import fractal.*;

public class Mountain extends Fractal {
    int length;

    /** Creates an object that handles Mountain's fractal. 
	 * @param length the length of the triangle side
	 */
	public Mountain(int length) {
		super();
		this.length = length;
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
        Point point = new Point((int) (turtle.getWidth() / 2.0 - length / 2.0), (int)
        (turtle.getHeight() / 2.0 + Math.sqrt(3.0) * length / 4.0));

        //setup triangle points, TODO make it cleaner
		Point p1 = new Point(point.getX(),point.getY());
        turtle.moveTo(p1.getX(), p1.getY());
        turtle.penUp();
        turtle.setDirection(0);
		turtle.forward(length);
        Point p2 = new Point( (int )(turtle.getX()),(int )(turtle.getY()) );
        turtle.setDirection(120);
		turtle.forward(length);
        Point p3 = new Point( (int )(turtle.getX()),(int )(turtle.getY()) );
        //-----


		fractalTriangle(turtle,order,length,p1,p2,p3);
	}

	/* 
	 * Reursive method: Draws a recursive triangle inside triangle. 
	 */
	private void fractalTriangle(TurtleGraphics turtle, int order, int length, Point p1, Point p2, Point p3) {
		if (order == 0) {
            turtle.moveTo(p1.getX(), p1.getY());
			turtle.penDown();
			turtle.forwardTo(p2.getX(),p2.getY());
            turtle.forwardTo(p3.getX(),p3.getY());
            turtle.forwardTo(p1.getX(),p1.getY());
            turtle.penUp();

			} else {
                turtle.moveTo(p1.getX(), p1.getY());
                turtle.penDown();
                turtle.forwardTo(p2.getX(),p2.getY());
                turtle.forwardTo(p3.getX(),p3.getY());
                turtle.forwardTo(p1.getX(),p1.getY());
                turtle.penUp();

                Point newP1 = new Point( ((p1.getX()+p2.getX())/2) , ((p1.getY()+p2.getY())/2) );
                Point newP2 = new Point( ((p2.getX()+p3.getX())/2) , ((p2.getY()+p3.getY())/2) );
                Point newP3 = new Point( ((p3.getX()+p1.getX())/2) , ((p3.getY()+p1.getY())/2) );

                fractalTriangle(turtle, order-1, length/2, p1, newP1, newP3);
                fractalTriangle(turtle, order-1, length/2, p2, newP1, newP2);
                fractalTriangle(turtle, order-1, length/2, p3, newP2, newP3);
                fractalTriangle(turtle, order-1, length/2, newP1, newP2, newP3);
            }
	}
    
}
