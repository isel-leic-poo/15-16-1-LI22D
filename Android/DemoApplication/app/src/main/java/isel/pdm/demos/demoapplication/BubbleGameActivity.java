package isel.pdm.demos.demoapplication;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class BubbleGameActivity extends Activity {

    private static final int STEP_INTERVAL = 10;

    // Animation support objects
    private Handler messageQueue;
    private Runnable step;

    // Views
    private BubbleView bubbleView;
    private ViewGroup container;

    private void doMovementStep() {
        bubbleView.getModel().moveBy(3, 3);
        bubbleView.invalidate();

        if(!bubbleView.isInBounds()) {
            container.removeView(bubbleView);
            bubbleView = null;
            return;
        };

        messageQueue.postDelayed(step, STEP_INTERVAL);
    }

    private void initAnimation() {
        messageQueue = new Handler();
        step = new Runnable() {
            @Override
            public void run() {
                doMovementStep();
            }
        };
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bubble_game_activity);

        bubbleView = (BubbleView) findViewById(R.id.bubbleView);
        container = (ViewGroup) findViewById(R.id.bubbleContainer);

        bubbleView.setModel(new Bubble(new Point(400, 400), 100));
        bubbleView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent evt) {

                if(evt.getAction() != MotionEvent.ACTION_DOWN)
                    return false;

                final Bubble model = ((BubbleView) view).getModel();
                if(model.collidesWith((int) evt.getX(), (int) evt.getY())) {
                    container.removeView(view);
                    return true;
                };

                messageQueue.post(step);
                return false;
            }
        });

        initAnimation();
    }
}
