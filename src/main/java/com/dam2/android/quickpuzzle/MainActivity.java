package com.dam2.android.quickpuzzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        findViewById(R.id.btPlay).setOnClickListener(this);
        findViewById(R.id.btPlayMyPhoto).setOnClickListener(this);
    }
    public void onClick(View arg0) {
        switch(arg0.getId()){
            case R.id.btPlay:
                Intent intent = new Intent(this, ProvaActivity.class);
                startActivity(intent);
                break;
            case R.id.btPlayMyPhoto:
                Intent intent2 = new Intent(this, ProvaActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
