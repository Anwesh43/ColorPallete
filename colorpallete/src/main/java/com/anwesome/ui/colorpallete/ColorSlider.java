package com.anwesome.ui.colorpallete;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;

/**
 * Created by anweshmishra on 28/04/17.
 */
public class ColorSlider {
    private float x,y,w,h;
    private char colorChar;
    private int color;
    private ColorSliderCircle colorSliderCircle;
    public ColorSlider(char colorChar,int color) {
        this.colorChar = colorChar;
        this.color = color;
        this.colorSliderCircle = new ColorSliderCircle();
    }
    public void setDimension(float x,float y,float w,float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        paint.setColor(Color.parseColor("#9E9E9E"));
        canvas.drawRoundRect(new RectF(0,0,w,h),Math.max(w/10,h/10),Math.max(w/10,h/10),paint);
        canvas.save();
        Path path = new Path();
        path.addRect(new RectF(-Math.max(w/10,h/10),y,colorSliderCircle.x,h), Path.Direction.CCW);
        canvas.clipPath(path);
        paint.setColor(color);
        canvas.drawRoundRect(new RectF(0,0,w,h),Math.max(w/10,h/10),Math.max(w/10,h/10),paint);
        canvas.restore();
        canvas.restore();
    }
    public boolean handleTouch(MotionEvent event) {
        float x = event.getX(),y = event.getY();
        if(x>=this.x+colorSliderCircle.x-colorSliderCircle.r && x<=this.x+colorSliderCircle.x+colorSliderCircle.r  && y>=this.y && y<=this.y+h) {

        }
        return false;
    }
    private class ColorSliderCircle {
        private float x,y,r;
        private boolean isDown = false;
        public ColorSliderCircle() {
            this.y = h/2;
            this.r = h/2+h/30;
            this.x = ColorSlider.this.x+r;
        }
        public void draw(Canvas canvas,Paint paint) {
            paint.setColor(color);
            canvas.drawCircle(x,y,r,paint);
        }
        public boolean handleTap(MotionEvent event) {
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if(!isDown) {
                        isDown = true;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    if(isDown) {
                        x = event.getX()-ColorSlider.this.x;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if(!isDown) {
                        isDown = false;
                    }
                    break;
            }
            return isDown;
        }
    }
}
