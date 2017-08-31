package br.com.daciosoftware.simplegameenginev1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.View;

/**
 * Created by fdacio on 23/08/17.
 */
public class SGView extends View {

    private Point mDimension = new Point();
    private boolean mHasStarted;
    private SGStepwatch mStepwatch = new SGStepwatch();
    private SGImageFactory mImageFactory;
    private SGRenderer mRenderer;

    public SGView(Context context){
        super(context);
        mImageFactory = new SGImageFactory(context);
        mRenderer = new SGRenderer();
    }

    @Override
    public void onDraw(Canvas canvas){

        step(canvas, mStepwatch.tick());

        invalidate();
    }

    public void step(Canvas canvas, float elapsedTimeInSecond){}

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight){

        mDimension.set(width, height);

        if(!mHasStarted){
            setup();
            mHasStarted = true;
        }
    }

    protected void setup(){}

    public Point getmDimensions(){
        return mDimension;
    }

    public SGImageFactory getmImageFactory(){
        return mImageFactory;
    }

    public SGRenderer getmRenderer(){
        return mRenderer;
    }
}
