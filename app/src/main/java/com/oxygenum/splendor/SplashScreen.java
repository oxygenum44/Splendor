package com.oxygenum.splendor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    public void click(View v){
        Intent intent = new Intent(SplashScreen.this, Game.class);
        startActivity(intent);
    }
}
