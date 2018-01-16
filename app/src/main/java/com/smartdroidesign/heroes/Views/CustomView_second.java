package com.smartdroidesign.heroes.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mstara on 16/01/2018.
 */

public class CustomView_second extends View {

    private RectF mRectSquare;
    private Paint mPaintSquare;
    private Paint mPaintLine;


    public CustomView_second(Context context) {
        super(context);
        init(null);
    }

    public CustomView_second(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView_second(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView_second(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(@Nullable AttributeSet set ){
        mRectSquare = new RectF();
        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLine.setStrokeWidth(3);
        mPaintSquare.setStrokeWidth(2);
        mPaintLine.setColor(Color.WHITE);

        mPaintSquare.setColor(Color.WHITE);
        mPaintSquare.setStyle(Paint.Style.STROKE);



    }

    // CURRENTLY DISABLED AS THIS NEEDS TWEAKING

    /*@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // square 1
        mRectSquare.left = 12;
        mRectSquare.top = 70;
        mRectSquare.right =  mRectSquare.left + 20;
        mRectSquare.bottom =  mRectSquare.top + 20;
        canvas.drawRoundRect( mRectSquare,20,20,mPaintSquare);

        // labyrinth-pattern
        canvas.drawLine(35,80,1000,80, mPaintLine);
        canvas.drawLine(1000,80,1000,600, mPaintLine);
        canvas.drawLine(35,600,1000,600, mPaintLine);
        canvas.drawLine(35,600,35,1160, mPaintLine);
        canvas.drawLine(35,1160,1000,1160, mPaintLine);
        canvas.drawLine(1000,1160,1000,1360, mPaintLine);
        canvas.drawLine(35,1360,1000,1360, mPaintLine);

        // square 2
        mRectSquare.left = 12;
        mRectSquare.top = 1350;
        mRectSquare.right =  mRectSquare.left + 20;
        mRectSquare.bottom =  mRectSquare.top + 20;
        canvas.drawRoundRect( mRectSquare,20,20,mPaintSquare);

    }*/
}
