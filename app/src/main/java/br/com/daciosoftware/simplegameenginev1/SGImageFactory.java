package br.com.daciosoftware.simplegameenginev1;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by fdacio on 29/08/17.
 */
public class SGImageFactory {

    protected Context mContext = null;

    public SGImageFactory(Context context){
        mContext = context;
    }

    public SGImage createImage(String filename){

        Bitmap bitmap = null;

        try{
            AssetManager assetManager = mContext.getAssets();
            InputStream inputStream = assetManager.open(filename);
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        }catch (IOException e){

            return null;
        }
        SGImage image = new SGImage(bitmap);

        return image;
    }

    public SGImage createImage(int resourceId){

        Bitmap bitmap = null;

        try{
            Resources resources = mContext.getResources();
            InputStream inputStream = resources.openRawResource(resourceId);
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        }catch (IOException e){
            return null;
        }
        SGImage image = new SGImage(bitmap);

        return image;
    }

}
