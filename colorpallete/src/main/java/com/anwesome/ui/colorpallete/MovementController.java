package com.anwesome.ui.colorpallete;

import android.graphics.Color;
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
    public MovementController(View view,Map<Character,ColorSlider> colorSliders) {
        this.view = view;
        this.colorSliderMap = colorSliders;
    }
    public void handleTouch(MotionEvent event) {
        List<ColorSlider> colorSliders = (List)colorSliderMap.values();
        if(colorSliders.size() == 4) {
            for (ColorSlider colorSlider : colorSliders) {
                if (colorSlider.handleTouch(event)) {
                    adjustColor();
                }
            }
        }
    }
    private void adjustColor() {
        int a = colorSliderMap.get('a').getValue(),r = colorSliderMap.get('r').getValue(),g = colorSliderMap.get('g').getValue(),b = colorSliderMap.get('b').getValue();
        int newColor = Color.argb(a,r,g,b);
        view.postInvalidate();
    }
}
