package poo.demos.points;

public class Point extends Object {

    protected final int x;
    protected final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public String toJsonString() {
        return "{ x: " + x + ", y: " + y + " }";
    }

    @Override
    public String toString() {
        return this.toJsonString();
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Point))
            return false;

        final Point theOther = (Point) other;
        if(this == theOther)
            return true;

        return this.x == theOther.x && this.y == theOther.y;
    }
}
