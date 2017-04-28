package com.anwesome.ui.colorpallete;

import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anweshmishra on 28/04/17.
 */
public class MovementController {
    private Map<Character,ColorSlider> colorSliderMap = new LinkedHashMap<>();
    private View view;
    private ColorArea colorArea;
    public MovementController(View view,Map<Character,ColorSlider> colorSliders,ColorArea colorArea) {
        this.view = view;
        this.colorSliderMap = colorSliders;
        this.colorArea = colorArea;
    }
    public void handleTouch(MotionEvent event) {

        if(colorSliderMap.values().size() == 3) {
            for (ColorSlider colorSlider : colorSliderMap.values()) {
                if (colorSlider.handleTouch(event)) {
                    adjustColor();
                }
            }
        }
    }
    private void adjustColor() {
        int a = 255,r = colorSliderMap.get('r').getValue(),g = colorSliderMap.get('g').getValue(),b = colorSliderMap.get('b').getValue();
        int newColor = Color.argb(a,r,g,b);
        colorArea.updateColor(newColor);

        Log.d("newColor",String.format("(%d,%d,%d)",r,g,b));
        view.postInvalidate();
    }
}
