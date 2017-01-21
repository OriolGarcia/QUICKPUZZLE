package com.dam2.android.quickpuzzle.Draganddrop;

import android.content.ClipData;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dam2.android.quickpuzzle.GameFragment;
import  com.dam2.android.quickpuzzle.R;

import java.util.zip.Inflater;

/**
 * Created by oriol on 21/01/17.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;
    private final Integer[] mThumbIds;

    public ImageAdapter(Context context, Integer[] mThumbIds) {
        this.context = context;
        this.mThumbIds = mThumbIds;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.item, null);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);


            imageView.setImageResource(mThumbIds[position]);

            imageView.setOnTouchListener(new MyTouchListener());

        } else {
            gridView = (View) convertView;
        }
        gridView.setOnDragListener(new MyDragListener());
        return gridView;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
 class MyTouchListener implements View.OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                    view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }
}
class MyDragListener implements View.OnDragListener {
    Context context;
    //Drawable enterShape = context.getResources().getDrawable(R.drawable.shape2);
  //  Drawable normalShape = context.getResources().getDrawable(R.drawable.shape);
//MyDragListener(Context context){this.context=context;}
    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                // do nothing
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
              //  v.setBackgroundDrawable(enterShape);
                break;
            case DragEvent.ACTION_DRAG_EXITED:
              //  v.setBackgroundDrawable(normalShape);
                break;
            case DragEvent.ACTION_DROP:
                // Dropped, reassign View to ViewGroup
                v.setX(event.getX());
                v.setY(event.getY());
               /* View view = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                LinearLayout container = (LinearLayout) v;
                container.addView(view);
                view.setVisibility(View.VISIBLE);*/
                break;
            case DragEvent.ACTION_DRAG_ENDED:
              //  v.setBackgroundDrawable(normalShape);
            default:
                break;
        }
        return true;
    }
}

