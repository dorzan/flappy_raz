package com.example.flappyraz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Obstacle {

    int height, face, pos, speed;
    Obstacle next;


    public Obstacle(){
        speed = 3;
        height = (int )(Math.random() * 6 + 1);
        face = 1;
        pos = AppConstants.SCREEN_WIDTH;
    }

    public int getHeight() {
        return height;
    }

    public Bitmap getFace() {
        if (face == 1)
            return AppConstants.getBitmapBank().getGil();
        else return null;
    }

    public Obstacle getNext() {
        return next;
    }

    public int getPos() {
        return pos;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public void setNext(Obstacle next) {
        this.next = next;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
