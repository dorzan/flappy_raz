package com.example.flappyraz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class GameActivity extends Activity {

    GameView gameView;

    public GameActivity(){}
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        gameView = new GameView (this);
        setContentView(gameView);

    }
/*
    @Override
    protected void onPause() {
        super.onPause();
        Intent intent;
            intent = new Intent(GameActivity.this, PauseActivity.class);
            startActivity(intent);
        }
*/

    public void lost(){
        int score = Score.score;
        Intent intent = new Intent(this, LooseActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }
}
