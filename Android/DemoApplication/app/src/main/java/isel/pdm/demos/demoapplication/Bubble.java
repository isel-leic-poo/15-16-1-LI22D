package isel.pdm.demos.demoapplication;

import android.graphics.Point;

/**
 * Class whose instances represent bubbles.
 */
public class Bubble {

    private final Point center;
    private final int radius;

    public Bubble(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public boolean collidesWith(int x, int y) {
        int dX = x - center.x;
        int dY = y - center.y;
        return radius >= Math.sqrt(dX*dX + dY*dY);
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public int getTop() {
        return center.y - radius;
    }

    public int getBottom() {
        return center.y + radius;
    }

    public int getLeft() {
        return center.x - radius;
    }

    public int getRight() {
        return center.x + radius;
    }

    public void moveBy(int deltaX, int deltaY) {
        center.x += deltaX;
        center.y += deltaY;
    }
}
