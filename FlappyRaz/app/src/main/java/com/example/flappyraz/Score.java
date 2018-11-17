package com.example.flappyraz;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;

public class Score {

    public static int score;
    Paint paint;

    public Score(){
        paint = new Paint();
        score = 0;
        //paint.setColor(ContextCompat.getColor(null, R.color.colorPrimary));
        paint.setColor((Color.YELLOW));
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(100);
    }

    public String getScore() {
        return String.valueOf(score);
    }

    public Paint getPaint() {
        return paint;
    }

    public void incrementScore(){
        score++;
    }
}
