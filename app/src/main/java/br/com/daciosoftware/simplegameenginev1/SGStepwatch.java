package br.com.daciosoftware.simplegameenginev1;

import android.os.SystemClock;

/**
 * Created by fdacio on 25/08/17.
 */
public class SGStepwatch {

    protected long mCurrenTime;
    protected long mLastTime;
    protected float mElapsedTime;

    protected float tick(){
        if(mCurrenTime == 0){
            mLastTime = mCurrenTime = SystemClock.uptimeMillis();
        }
        else{
            mCurrenTime = SystemClock.uptimeMillis();
        }

        mElapsedTime = (mCurrenTime - mLastTime) / 1000.0f;
        mLastTime = mCurrenTime;
        return mElapsedTime;
    }
}
