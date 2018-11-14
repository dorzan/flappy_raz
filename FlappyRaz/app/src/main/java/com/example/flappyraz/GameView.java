package com.example.flappyraz;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    GameThread gameThread;
    GameActivity activity;

    public GameView(Context context) {
        super(context);
        activity = (GameActivity)context;
        initView();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if(!gameThread.isRunning()){
            gameThread = new GameThread(holder, activity);
            gameThread.start();
        }
        else {
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(gameThread.isRunning()){
            gameThread.setIsRunning(false);
            boolean retry = true;
            while (retry) {
                try {
                    gameThread.join();
                    retry = false;
                }catch(InterruptedException e){}
                }
            }
            }


    void initView(){
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread = new GameThread(holder, activity);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN)
            AppConstants.gameEngine.raz.setSpeedY(-35);

        return true;
    }
}
