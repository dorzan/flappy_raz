package com.example.flappyraz;

import android.graphics.Canvas;

import java.util.concurrent.TimeUnit;

public class GameEngine {

    BackgroundImage backgroundImage;
    Raz raz;
    ObstacleList obstacleList;


    public GameEngine() {
        backgroundImage = new BackgroundImage();
        raz = new Raz();
        obstacleList = new ObstacleList();

    }

    public void updateAndDrawBackgroundImage(Canvas canvas, GameActivity activity) {
        //background
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if (backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth()) {
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
        if (backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() + AppConstants.getBitmapBank().getBackgroundWidth() - 10, backgroundImage.getY(), null);
        }

        /***** raz ****/
        if(raz.getY() + AppConstants.bitmapBank.getRaz().getHeight() > AppConstants.FLOOR_HEIGHT) {
            lost(activity);
        }
        raz.setSpeedY(raz.getSpeedY() + 3);
        if (raz.getY() > -400) {
            raz.setY(raz.getY() + raz.getSpeedY());
        }
        else raz.setY(-399);

        //canvas.drawBitmap(AppConstants.getBitmapBank().getRaz(), raz.getX(), raz.getY(), null);
        canvas.drawBitmap(AppConstants.getBitmapBank().getRaz(), raz.getX(), raz.getY(), null);


        /***** obstacles *****/
        if(checkObstacleHit())
            lost(activity);
        if (obstacleList.getHead().getPos() < -AppConstants.getBitmapBank().getGilWidth() )
            obstacleList.removeHead();

        if(obstacleList.getLast().getPos()<AppConstants.SCREEN_WIDTH-600 )
            obstacleList.insertObstacle();

        drawAndMoveObstacles(canvas);
    }

    private void drawAndMoveObstacles(Canvas canvas){
        Obstacle temp = obstacleList.getHead();
        while (temp != null){
            for(int i = 0 ; i < temp.getHeight() ; i++) {
                canvas.drawBitmap(AppConstants.getBitmapBank().getGil(), temp.getPos(), i * AppConstants.getBitmapBank().getGilHeight(), null);
            }
            for(int i = 0 ; i < obstacleList.getNumOfFaces() - temp.getHeight() ; i++) {
                canvas.drawBitmap(temp.getFace(), temp.getPos(), AppConstants.FLOOR_HEIGHT - (i +1) * AppConstants.getBitmapBank().getGilHeight(), null);
            }

            temp.setPos(temp.getPos()-6);
            if (temp == obstacleList.getLast()){
                break;
            }
            temp=temp.getNext();
        }
    }

    public void lost(GameActivity activity){
        activity.lost();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

       // activity.lost();

    }

    public boolean checkObstacleHit() {
        Obstacle temp = obstacleList.getHead();
        while (temp != null) {
            if (raz.getX() + AppConstants.bitmapBank.getRaz().getWidth() > temp.getPos() && raz.getX() < temp.getPos() + temp.getFace().getWidth())
                if (raz.getY() < temp.getHeight() * temp.getFace().getHeight() ||
                        raz.getY() + AppConstants.getBitmapBank().getRaz().getHeight() > AppConstants.FLOOR_HEIGHT -   temp.getFace().getHeight() * ( obstacleList.getNumOfFaces() - temp.getHeight()))
                    return true;
            temp=temp.getNext();
        }
        return false;
    }

}
