package poo.demos.points;

import org.junit.Assert;
import org.junit.Test;

public class Point3DTests {

    @Test
    public void equals_onTwoEqualPoints_returnsTrue() {
        Point3D p1 = new Point3D(2, 4, 1);
        Point3D p2 = new Point3D(2, 4, 1);

        Assert.assertTrue(p1.equals(p2));
    }

    @Test
    public void equals_onTwoDifferentPoints_returnsFalse() {
        Point3D p1 = new Point3D(2, 4, 1);
        Point3D p2 = new Point3D(2, 4, 5);

        Assert.assertFalse(p1.equals(p2));
    }

    @Test
    public void equals_onSamePoint_returnsTrue() {
        Point3D p1 = new Point3D(2, 4, 3);
        Point3D p2 = p1;

        Assert.assertTrue(p1.equals(p2));
    }
}
