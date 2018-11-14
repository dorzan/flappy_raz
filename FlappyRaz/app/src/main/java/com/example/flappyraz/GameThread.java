package com.example.flappyraz;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

    SurfaceHolder surfaceHolder; //Surfacegolder object reference
    boolean isRunning; // Flag to detect wether the thread is running or not
    long startTime, loopTime; // Loop start time and loop duration
    long DELAY = 20; // Delay in millisecondsbetween screen refreshes
    GameActivity activity;

    public GameThread(SurfaceHolder surfaceHolder, GameActivity activity) {
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
        this.activity = activity;


    }

    @Override
    public void run(){
        //looping until the boolean is false
        while (isRunning) {
            startTime = SystemClock.uptimeMillis();
            //locking the canvas
            Canvas canvas;
            canvas = surfaceHolder.lockCanvas(null);
            if(canvas != null){
                synchronized (surfaceHolder){
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas, activity);
                    //unlocking the canvas
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            //loop time
            loopTime = SystemClock.uptimeMillis() - startTime;
            //pausing here to make sure we update the right amnout per secong
            if(loopTime < DELAY){
                try{
                Thread.sleep(DELAY - loopTime);
                }catch(InterruptedException e){
                    Log.e("Interrupted", "Intterupted while sleeping");
                }

                }
        }
    }
    //Return wether the thread is running
    public boolean isRunning(){
        return isRunning;
    }

    // Sets the thread state, falsed = stopped, true = running
    public void setIsRunning(boolean state){
        isRunning= state;
    }
}
