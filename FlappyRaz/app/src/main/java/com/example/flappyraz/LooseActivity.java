package com.example.flappyraz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LooseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loose_activity);
        AppConstants.initialization(this.getApplicationContext());
    }

    public void startGame(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}
