package com.anwesome.ui.colorpallete;

import android.app.Activity;
/**
 * Created by anweshmishra on 28/04/17.
 */
public class ColorPallete {
    private Activity activity;
    private ColorPalleteView colorPalleteView;
    public ColorPallete(Activity activity) {
        this.activity = activity;
    }
    public void show() {
        if(colorPalleteView == null) {
            colorPalleteView = new ColorPalleteView(activity);
            activity.setContentView(colorPalleteView);
        }
    }
}
