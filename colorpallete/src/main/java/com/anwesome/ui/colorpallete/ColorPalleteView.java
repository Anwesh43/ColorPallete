package com.anwesome.ui.colorpallete;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by anweshmishra on 28/04/17.
 */
public class ColorPalleteView extends View{
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Map<Character,ColorSlider> colorSliderMap = new LinkedHashMap<>();
    private ColorArea colorArea = new ColorArea(Color.BLACK);
    private MovementController movementController;
    private int time = 0;
    public ColorPalleteView(Context context) {
        super(context);
        initColorSliderMap();
    }
    public void initColorSliderMap() {
        colorSliderMap.put('r',new ColorSlider('r',Color.RED));
        colorSliderMap.put('g',new ColorSlider('g',Color.GREEN));
        colorSliderMap.put('b',new ColorSlider('b',Color.BLUE));
    }
    public void onDraw(Canvas canvas) {
        if(time == 0){
            int w = canvas.getWidth(),h = canvas.getHeight();
            int colorAreaSize = Math.min(w,h)/2;
            colorArea.setDimension(w/2-colorAreaSize/2,h/3-colorAreaSize/2,Math.min(w,h)/2,Math.min(w,h)/2);
            int sliderH = Math.min(w,h)/15,sliderW = 4*w/5,sliderX = w/10,sliderY = h/2+h/6;
            for(ColorSlider colorSlider:colorSliderMap.values()) {
                colorSlider.setDimension(sliderX,sliderY,sliderW,sliderH);
                sliderY += 2*sliderH;
            }
            movementController = new MovementController(this,colorSliderMap,colorArea);
        }
        canvas.save();
        for(ColorSlider colorSlider:colorSliderMap.values()) {
            colorSlider.draw(canvas,paint);
        }
        canvas.restore();
        colorArea.draw(canvas,paint);
        time++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        movementController.handleTouch(event);
        return true;
    }
}
