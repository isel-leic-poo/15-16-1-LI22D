package isel.pdm.demos.demoapplication;

import android.graphics.Point;

/**
 * Class whose instances represent bubbles.
 *
 * TODO: Document
 */
public class Bubble {

    private final Point center;
    private final int radius;

    private final int dX, dY;

    public Bubble(Point center, int radius, int dX, int dY) {
        this.center = center;
        this.radius = radius;
        this.dX = dX;
        this.dY = dY;
    }

    public boolean collidesWith(int x, int y) {
        int dX = x - center.x;
        int dY = y - center.y;
        return radius >= Math.sqrt(dX*dX + dY*dY);
    }

    public boolean isInBounds(int width, int height) {
        return getLeft() < width && getRight() > 0 && getTop() < height && getBottom() > 0;
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

    public void moveStep() {
        center.x += dX;
        center.y += dY;
    }
}
