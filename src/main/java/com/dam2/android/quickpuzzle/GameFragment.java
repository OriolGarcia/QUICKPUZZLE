package com.dam2.android.quickpuzzle;

import android.content.ClipData;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    public Integer[] mThumbIds = {
            R.drawable.peca, R.drawable.peca,
            R.drawable.peca, R.drawable.peca,
            R.drawable.peca,  R.drawable.peca,
            R.drawable.peca,  R.drawable.peca,
            R.drawable.peca

    };

    public static GameFragment newInstance(){
        return new GameFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quickpuzzle,container,false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.fragment_quickpuzzle);

        // Instance of ImageAdapter Class
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter( new ImageAdapter2(mThumbIds) );
       // recyclerView.setOnDragListener(new MyDragListener());
        return v;
    }




    private class PecaHolder extends RecyclerView.ViewHolder{

        private ImageView mImage;
        private RelativeLayout rel;
        public PecaHolder(LayoutInflater inflater, ViewGroup container){

            super(inflater.inflate(R.layout.list_item, container,false));
            rel = (RelativeLayout) itemView.findViewById(R.id.containerpiecepuzzle);
            rel.setOnDragListener(new MyDragListener());

            mImage=(ImageView) rel.findViewById( R.id.list_item_image);
            mImage.setOnTouchListener(new MyTouchListener());
        }
    }

        private class ImageAdapter2 extends RecyclerView.Adapter<PecaHolder>{
            private Integer[] mThumbIds;
           // private Context context;

            public ImageAdapter2(Integer[] mThumbIds) {
                this.mThumbIds=mThumbIds;
                //this.context = context;
            }
            @Override
            public PecaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(getActivity() );
                return new PecaHolder( inflater,parent );
            }

            @Override
            public void onBindViewHolder(PecaHolder holder, int position) {
                if (position!= mThumbIds.length-1)
                holder.mImage.setImageResource( mThumbIds[position] );
                holder.rel.setId( position );


            }

            @Override
            public int getItemCount() {
                return mThumbIds.length;
            }
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
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                //  v.setBackgroundDrawable(enterShape);
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                //  v.setBackgroundDrawable(normalShape);
                break;
            case DragEvent.ACTION_DROP:
                // Dropped, reassign View to ViewGroup
                //v.setX(event.getX());
               // v.setY(event.getY());

                View view = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                RelativeLayout container = (RelativeLayout) v;
                container.getId();
                container.addView(view);
                view.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENDED:

                //  v.setBackgroundDrawable(normalShape);
            default:
                break;
        }
        return true;
    }
}