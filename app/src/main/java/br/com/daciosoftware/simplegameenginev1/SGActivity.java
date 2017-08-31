package br.com.daciosoftware.simplegameenginev1;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by fdacio on 15/08/17.
 */
public class SGActivity extends Activity {

    public static final String TAG = "SimpleGameEngine";
    private SGPreferences mPrefereces;

    public enum SGOrientatio{
        LANDSCAPE,
        PORTRAIT
    }

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        mPrefereces = new SGPreferences(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart chamado.");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume chamado.");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart chamado.");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause chamado.");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop chamado.");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy chamado.");
    }

    public void enabledKeepScreenOn(){

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public void setOrientation(SGOrientatio orientation){

        switch (orientation){

            case LANDSCAPE:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
            case PORTRAIT:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
        }
    }

    public void enabledFullScreen(){
        Window window = getWindow();

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.requestFeature(Window.FEATURE_NO_TITLE);

        if(Build.VERSION.SDK_INT >= 19){

            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    public SGPreferences getPreferences(){

        return mPrefereces;

     }


}
