package com.dam2.android.quickpuzzle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.dam2.android.quickpuzzle.Draganddrop.ImageAdapter;

public class ProvaActivity extends Activity {

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.peca, R.drawable.peca,
            R.drawable.peca, R.drawable.peca,
            R.drawable.peca,  R.drawable.peca


    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this,mThumbIds));
    }
}
