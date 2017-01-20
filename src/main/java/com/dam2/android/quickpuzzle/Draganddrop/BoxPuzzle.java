package com.dam2.android.quickpuzzle.Draganddrop;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by oriol on 21/01/17.
 */

public class BoxPuzzle extends View{
    private static final String TAG = "BoxView";
    public BoxPuzzle(Context context) {
        super( context );
    }

    public BoxPuzzle(Context context, AttributeSet attrs) {
        super( context, attrs );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(),event.getY());
        String action ="";
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                break;
        }
        Log.i(TAG,action+"at x="+current.x+",y="+current.y);
        return true;
    }
}
