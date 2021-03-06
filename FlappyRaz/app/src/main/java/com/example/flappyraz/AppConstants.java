package com.example.flappyraz;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {
    static BitmapBank bitmapBank; //Bitmap object reference
    static GameEngine gameEngine; // GameEngine object reference
    static int SCREEN_WIDTH, SCREEN_HEIGHT, FLOOR_HEIGHT,DISTANCE_BETWEEN_OBSTACLES;


    public static void initialization(Context context){
        setScreenSize(context);
        bitmapBank = new BitmapBank(context.getResources());
        gameEngine = new GameEngine();
        FLOOR_HEIGHT = SCREEN_HEIGHT - 240;
        DISTANCE_BETWEEN_OBSTACLES = SCREEN_WIDTH-600;
    }

    //Return BitmapBank instance
    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }

    //return gameEngine
    public static GameEngine getGameEngine(){
        return gameEngine;
    }



    private static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;

    }
}
