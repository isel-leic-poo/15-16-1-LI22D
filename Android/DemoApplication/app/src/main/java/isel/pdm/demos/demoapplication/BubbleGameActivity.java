package isel.pdm.demos.demoapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleGameActivity extends Activity {

    private static Random random = new Random();

    private static final int MIN_RADIUS = 20;
    private static final int MAX_RADIUS = 100;

    private static final int STEP_INTERVAL = 10;

    // Animation support objects
    private Handler messageQueue;
    private Runnable step;
    private int stepCount;

    // Bubble information
    private Point screenSize;

    // Views
    private ViewGroup container;
    private Bitmap unscaledImage;

    // Current score
    private Score currentScore;

    private void removeBubbles(List<BubbleView> bubblesToRemove) {
        for(BubbleView bubbleView : bubblesToRemove) {
            container.removeView(bubbleView);
        }
    }

    /**
     * Creates a new bubble view and its associated bubble model instance. The size and movement
     * direction are generated randomly within predefined intervals.
     */
    private void createBubble() {

        // Have we initialized the field that holds information regarding the screen center?
        if(screenSize == null) {
            // No. Let's do it then.
            screenSize = new Point();
            getWindowManager().getDefaultDisplay().getSize(screenSize);
        }

        Log.v("DEMO", currentScore.toString());
        if(currentScore.hasLost())
            return;

        // TODO: Deal with magic numbers
        final int radius = (random.nextInt(20) + 1) * 10;
        final int dX = random.nextInt(7) - 3, dY = random.nextInt(7) - 3;

        final BubbleView bubbleView = new BubbleView(this);
        bubbleView.setUnscaledImage(unscaledImage);
        bubbleView.setModel(new Bubble(new Point(screenSize.x / 2, screenSize.y / 2), radius, dX, dY));
        container.addView(bubbleView);
    }

    /**
     * Method that performs an animation step and schedules the next animation step.
     * The animation stops when the bubble is destroyed or when it leaves the visible screen area.
     */
    private void doMovementStep() {
        if(container.getChildCount() == 0)
            return;

        final List<BubbleView> toRemove = new ArrayList<>();
        for (int idx = 0; idx < container.getChildCount(); ++idx) {
            final BubbleView bubbleView = (BubbleView) container.getChildAt(idx);
            bubbleView.getModel().moveStep();
            bubbleView.invalidate();

            if (!bubbleView.isInScreenBounds()) {
                toRemove.add(bubbleView);
                currentScore.countLoss();
            }
        }

        removeBubbles(toRemove);

        if(container.getChildCount() != 0) {
            // Let's schedule the next animation step
            messageQueue.postDelayed(step, STEP_INTERVAL);
        }

        stepCount = ++stepCount % 50;
        if(stepCount == 0)
            createBubble();
    }

    /**
     * Initializes the data structures required to perform the animation
     */
    private void initAnimation() {
        messageQueue = new Handler();
        stepCount = 0;
        step = new Runnable() {
            @Override
            public void run() {
                doMovementStep();
            }
        };
    }

    /**
     * Starts the animation.
     */
    private void startAnimation() {
        // We start the animation by scheduling the first animation step
        createBubble();
        messageQueue.post(step);
    }

    /** {@inheritDoc} */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bubble_game_activity);

        unscaledImage = BitmapFactory.decodeResource(
                getResources(), R.drawable.b64
        );
        currentScore = new Score();

        container = (ViewGroup) findViewById(R.id.bubbleContainer);
        container.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent evt) {

                if(evt.getAction() != MotionEvent.ACTION_DOWN)
                    return false;

                if(container.getChildCount() == 0) {
                    startAnimation();
                    return true;
                }

                final List<BubbleView> toRemove = new ArrayList<>();
                for (int idx = 0; idx < container.getChildCount(); ++idx) {
                    final BubbleView bubbleView = (BubbleView) container.getChildAt(idx);
                    final Bubble model = bubbleView.getModel();
                    if(model.collidesWith((int) evt.getX(), (int) evt.getY())) {
                        toRemove.add(bubbleView);
                        currentScore.countHit();
                        break;
                    }
                }

                if (toRemove.isEmpty()) {
                    createBubble();
                } else {
                    removeBubbles(toRemove);
                }
                return true;
            }
        });

        initAnimation();
    }
}
