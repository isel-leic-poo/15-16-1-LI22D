package isel.pdm.demos.demoapplication;

/**
 * Class whose instances represent the player's score.
 */
public class Score {

    private int lostCount = 0;
    private int hitCount = 0;

    private static final int MAX_LOSSES = 10;

    public void countHit() {
        hitCount += 1;
    }

    public boolean countLoss() {
        lostCount += 1;
        return hasLost();
    }

    public int getLostCount() {
        return lostCount;
    }

    public int getHitCount() {
        return hitCount;
    }

    public boolean hasLost() {
        return lostCount >= MAX_LOSSES;
    }

    @Override
    public String toString() {
        return "Hits: " + hitCount + "; Escaped: " + lostCount;
    }
}
