package com.dam2.android.quickpuzzle.Draganddrop;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.media.Image;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.dam2.android.quickpuzzle.R;

/**
 * Created by oriol on 21/01/17.
 */

public class BoxPuzzle extends RelativeLayout{
    private static final String TAG = "BoxView";
    private LayoutInflater inflater;

    private ImageView mImage;
    int deviceWidth;

    public  BoxPuzzle (Context context) {
        this(context, null, 0);
    }

    public  BoxPuzzle (Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public  BoxPuzzle (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        final Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point deviceDisplay = new Point();
        display.getSize(deviceDisplay);
        deviceWidth = deviceDisplay.x;
    }


   /*
    public BoxPuzzle(Context context) {
        super( context );
        ImageView image = (ImageView) findViewById( R.id.iVcasella );
      image.setOnTouchListener(new OnTouchListener()
        {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDrag(data, shadowBuilder, view, 0);
                    view.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        })
        View.inflate(context, R.layout.activity_game_fragment, this);

    };*/
 /*
    public BoxPuzzle(Context context, AttributeSet attrs) {
        super( context, attrs );
        ImageView image = (ImageView) findViewById( R.id.iVcasella );
        View.inflate(context, R.layout.activity_game_fragment, this);
       image.setOnTouchListener(new OnTouchListener()
        {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDrag(data, shadowBuilder, view, 0);
                    view.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });
    }*/

}
