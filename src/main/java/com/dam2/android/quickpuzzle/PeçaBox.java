package com.dam2.android.quickpuzzle;

import android.content.Context;
import android.content.res.AssetManager;

/**
 * Created by oriol on 22/01/17.
 */

public class PeçaBox {
    private static final String TAG="PeçaBox";
    private static final String IMAGES_FOLDER= "imatges_exemple";
    private AssetManager mAssets;
    public PeçaBox(Context context,Integer[] mThumbIds ){
        mAssets= context.getAssets();
    }
    private void loadImages(){
        String[] imagesnames;

    }
}
