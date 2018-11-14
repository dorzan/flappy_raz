package com.example.flappyraz;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {
    Bitmap background, raz, obstacle, gil, play;

    public BitmapBank(Resources res) {
        background=BitmapFactory.decodeResource(res, R.drawable.d7ca67278858823d19c95902aa84494c);
        background = scaleImage(background);
        raz=BitmapFactory.decodeResource(res, R.drawable.raz);
        raz = raz.createScaledBitmap(raz,200,200,false);
        gil=BitmapFactory.decodeResource(res, R.drawable.gil);
        gil = gil.createScaledBitmap(gil,150,150,false);
        play=BitmapFactory.decodeResource(res, R.drawable.play);
    }

    //return background bitmap
    public Bitmap getBackground(){
        return background;
    }

    public Bitmap getRaz(){
        return raz;
    }

    public Bitmap getGil() {
        return gil;
    }

    public int getGilHeight(){
        return gil.getHeight();
    }

    public int getGilWidth(){
        return gil.getWidth();
    }

    //return background width
    public int getBackgroundWidth(){
        return background.getWidth();
    }

    //return background height
    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImage (Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth()/getBackgroundHeight();
        /*
        we'll multiply widthHeightRatio with screen Height to get scaled width of the bitmap
        then call createScaledBitmap() to create a new bitmap, scaled from an existing bitmap, when possible
         */
        int backgroundScaleWidth = (int)widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
