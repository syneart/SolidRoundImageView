package com.syneart.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.syneart.solidroundimageview.R;

/**
 * SolidRoundImageView
 */
public class SolidRoundImageView extends ImageView {
    private static final int defaultColor = 0xFF000000;
    private Context mContext;
    private int mSolidColor;
    private int defaultWidth = 0;
    private int defaultHeight = 0;

    public SolidRoundImageView(Context context) {
        super(context);
        mContext = context;
    }

    public SolidRoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setCustomAttributes(attrs);
    }

    public SolidRoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        setCustomAttributes(attrs);
    }

    public void setSolidColor(int color) {
        mSolidColor = color;
    }

    private void setCustomAttributes(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.solid_round_imageview_attrs);
        mSolidColor = typedArray.getColor(R.styleable.solid_round_imageview_attrs_solidColor, defaultColor);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        this.measure(0, 0);

        if (defaultWidth == 0) {
            defaultWidth = getWidth();

        }
        if (defaultHeight == 0) {
            defaultHeight = getHeight();
        }

        int radius = (defaultWidth < defaultHeight ? defaultWidth
                    : defaultHeight) / 2;
        drawSolidCircle(canvas, radius / 2, mSolidColor);

    }

    private void drawSolidCircle(Canvas canvas, int radius, int color) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(defaultWidth / 2, defaultHeight / 2, radius, paint);
    }

}