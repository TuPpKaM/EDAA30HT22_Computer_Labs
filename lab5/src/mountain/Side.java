package mountain;

public class Side {
    Point p1;
    Point p2;
    
    public Side(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override // copied from instructions
        public int hashCode() {
        return p1.hashCode() + p2.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        Side side2 = (Side) o;
        // should be equal even if the points are flipped, as it's the same line
        return (this.p1==side2.p1 && this.p2==side2.p2) || (this.p2==side2.p1 && this.p1==side2.p2);
    }

    
}
