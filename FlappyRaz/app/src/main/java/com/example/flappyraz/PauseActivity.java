package com.example.flappyraz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class PauseActivity extends Activity {


    public PauseActivity(){}
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_activity);
        }

    protected void resume(){
        finish();
    }
}
