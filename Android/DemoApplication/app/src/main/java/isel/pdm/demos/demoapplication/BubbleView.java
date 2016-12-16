package isel.pdm.demos.demoapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Class whose instances represent visual manifestations of bubbles.
 *
 * TODO: Document
 */
public class BubbleView extends View {

    private Bubble model;
    private Paint brush;
    private Bitmap image;
    private Bitmap unscaledImage;

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

    public void setUnscaledImage(Bitmap unscaledImage) {
        this.unscaledImage = unscaledImage;
    }

    public void setModel(Bubble bubble) {
        model = bubble;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(model != null) {
            if(image == null) {
                image = Bitmap.createScaledBitmap(
                        unscaledImage,
                        model.getRadius() * 2,
                        model.getRadius() * 2,
                        false
                );
            }
            canvas.drawBitmap(
                    image,
                    model.getLeft(),
                    model.getTop(),
                    brush
            );
        }
    }

    public boolean isInScreenBounds() {
        return model.isInBounds(getWidth(), getHeight());
    }

    public Bubble getModel() {
        return model;
    }
}
