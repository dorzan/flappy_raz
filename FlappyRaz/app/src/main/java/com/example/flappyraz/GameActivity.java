package com.example.flappyraz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

public class GameActivity extends Activity {

    GameView gameView;

    public GameActivity(){}
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        gameView = new GameView (this);
        setContentView(gameView);

    }



    public void lost(){

        Intent intent = new Intent(this, LooseActivity.class);
        startActivity(intent);
        finish();
    }
}
