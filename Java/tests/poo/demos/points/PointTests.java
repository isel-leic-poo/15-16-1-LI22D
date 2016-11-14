package poo.demos.points;

import org.junit.Assert;
import org.junit.Test;

public class PointTests {

    private void printJson(Point p) {
        System.out.println(p);
    }

    @Test
    public void testToJsonString() {

        Point p1 = new Point(2, 4);
        Point3D p2 = new Point3D(1, 2, 3);
        Point p3 = p2;

        printJson(p1);
        printJson(p2);
        printJson(p3);
    }

    @Test
    public void equals_onTwoEqualPoints_returnsTrue() {
        Point p1 = new Point(2, 4);
        Point p2 = new Point(2, 4);

        Assert.assertTrue(p1.equals(p2));
    }

    @Test
    public void equals_onTwoDifferentPoints_returnsFalse() {
        Point p1 = new Point(2, 4);
        Point p2 = new Point(2, 2);

        Assert.assertFalse(p1.equals(p2));
    }

    @Test
    public void equals_onSamePoint_returnsTrue() {
        Point p1 = new Point(2, 4);
        Point p2 = p1;

        Assert.assertTrue(p1.equals(p2));
    }
}
