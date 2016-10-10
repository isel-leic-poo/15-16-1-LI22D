package poo.demos.points;

public class Point3D extends Point {

    private final int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
        this(0, 0, 0);
    }

    @Override
    public String toJsonString() {
        return "{ x: " + x + ", y: " + y +
                ", z: " + z + " }";
    }
}
