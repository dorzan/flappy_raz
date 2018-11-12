package com.example.flappyraz;

import android.graphics.Canvas;

public class GameEngine {

    BackgroundImage backgroundImage;
    Raz raz;

    public GameEngine(){
        backgroundImage = new BackgroundImage();
        raz = new Raz();
    }

    public void updateAndDrawBackgroundImage(Canvas canvas){
        //background
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if (backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth() ) {
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
        if(backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth()-AppConstants.SCREEN_WIDTH)){
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() + AppConstants.getBitmapBank().getBackgroundWidth()-10,backgroundImage.getY(), null);
        }

        //raz
        canvas.drawBitmap(AppConstants.getBitmapBank().getRaz(), raz.getX(), raz.getY(), null);
        raz.setSpeedY(raz.getSpeedY()+3);
        raz.setY(raz.getY()+raz.getSpeedY());
    }
}
