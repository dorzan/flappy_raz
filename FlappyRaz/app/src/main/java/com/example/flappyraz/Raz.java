package com.example.flappyraz;

public class Raz {

    private int speedX, speedY, razX, razY;

    public Raz(){
        speedX=3;
        speedY=0;
        razX=500;
        razY=500;
    }

    public int getX(){
        return razX;
    }

    public int getY(){
        return razY;
    }

    public void setX(int razX){
        this.razX = razX;
    }

    public void setY(int razY){
        this.razY = razY;
    }

    public int getSpeedX(){
        return speedX;
    }

    public int getSpeedY(){
        return speedY;
    }
    public void setSpeedX(int speedX){
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY){
        this.speedY = speedY;
    }
}
