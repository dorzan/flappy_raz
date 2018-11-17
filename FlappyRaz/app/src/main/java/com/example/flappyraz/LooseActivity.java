package com.example.flappyraz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LooseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        int score = getIntent().getIntExtra("score",0);
       // int score = Score.score;

        setContentView(R.layout.loose_activity);
        TextView textView =  (TextView) this.findViewById(R.id.textView2);
        textView.setText(String.valueOf(score));
        AppConstants.initialization(this.getApplicationContext());
    }

    public void startGame(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}
