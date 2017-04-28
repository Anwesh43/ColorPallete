package com.anwesome.ui.colorpallete;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 28/04/17.
 */
public class ColorArea {
    private int color;
    private float x,y,w,h;
    public ColorArea(int color) {
        this.color = color;
    }
    public void setDimension(float x,float y,float w,float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        canvas.drawRoundRect(new RectF(x,y,x+w,y+h),Math.max(w,h)/10,Math.max(w,h)/10,paint);
    }
    public void updateColor(int color) {
        this.color = color;
    }
}
