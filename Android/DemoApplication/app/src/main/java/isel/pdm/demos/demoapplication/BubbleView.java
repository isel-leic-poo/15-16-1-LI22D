package isel.pdm.demos.demoapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Class whose instances represent visual manifestations of bubbles.
 */
public class BubbleView extends View {

    private Bubble model;
    private Paint brush;

    private void initBrush() {
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setStyle(Paint.Style.FILL_AND_STROKE);
        brush.setStrokeWidth(1);

    }

    public BubbleView(Context context) {
        this(context, null, 0);
    }

    public BubbleView(Context ctx, AttributeSet attrs) {
        this(ctx, attrs, 0);
    }

    public BubbleView(Context ctx, AttributeSet attrs, int defStyle) {
        super(ctx, attrs, defStyle);
        initBrush();
    }

    public void setModel(Bubble bubble) {
        model = bubble;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.v("Paulo", "onDraw() called");
        if(model != null) {
            canvas.drawOval(
                    model.getLeft(),
                    model.getTop(),
                    model.getRight(),
                    model.getBottom(),
                    brush
            );
        }
    }

    public boolean isInBounds() {
        return model.getTop() < getHeight() && model.getLeft() < getWidth();
    }

    public Bubble getModel() {
        return model;
    }
}
