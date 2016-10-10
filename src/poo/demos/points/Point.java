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
    public boolean equals(Object obj) {
        // TODO: Fix me!
        return super.equals(obj);
    }
}
