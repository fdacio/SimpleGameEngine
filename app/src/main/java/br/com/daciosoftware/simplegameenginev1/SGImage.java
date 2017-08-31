package br.com.daciosoftware.simplegameenginev1;

import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * Created by fdacio on 29/08/17.
 */
public class SGImage {

    private Bitmap mBitmap = null;
    private Point mDimensions = new Point();


    public SGImage(Bitmap bitmap){
        mBitmap = bitmap;
        mDimensions.set(mBitmap.getWidth(), mBitmap.getHeight());
    }

    public Bitmap getBitmap(){
        return mBitmap;
    }

    public Point getDimensions(){
        return mDimensions;
    }
}
