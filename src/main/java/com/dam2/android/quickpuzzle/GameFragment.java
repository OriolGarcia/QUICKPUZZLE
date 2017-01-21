package com.dam2.android.quickpuzzle;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dam2.android.quickpuzzle.Draganddrop.ImageAdapter;

public class GameFragment extends Fragment {
    String msg="message";
    RelativeLayout.LayoutParams lParams;
public static GameFragment newInstance(){
    return new GameFragment();
}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_game_fragment,container,false);
        v.findViewById(R.id.myimage1).setOnTouchListener(new MyTouchListener());
       v.findViewById(R.id.myimage1).setOnTouchListener(new MyTouchListener());
        v.findViewById(R.id.myimage2).setOnTouchListener(new MyTouchListener());
        v.findViewById(R.id.myimage3).setOnTouchListener(new MyTouchListener());
        v.findViewById(R.id.myimage4).setOnTouchListener(new MyTouchListener());
        v.findViewById(R.id.topleft).setOnDragListener(new MyDragListener());
        v.findViewById(R.id.topright).setOnDragListener(new MyDragListener());
        v.findViewById(R.id.bottomleft).setOnDragListener(new MyDragListener());
        v.findViewById(R.id.bottomright).setOnDragListener(new MyDragListener());

        GridView gridview = (GridView) v.findViewById(R.id.gridview);
        //gridview.setAdapter(new ImageAdapter(getContext()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getContext(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }
    private final class MyTouchListener implements View.OnTouchListener {
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
        Drawable enterShape = getResources().getDrawable(R.drawable.shape2);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    }

}
