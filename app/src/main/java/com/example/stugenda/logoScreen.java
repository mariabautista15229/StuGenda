package com.example.stugenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class logoScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000;

    ImageView imageView;
    TextView textView;
    Animation moveAnim, fadeAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logo_screen);


        moveAnim = AnimationUtils.loadAnimation(this,R.anim.move_animation);
        fadeAnim = AnimationUtils.loadAnimation(this,R.anim.fade_animation);

        imageView = findViewById(R.id.logo);
        textView = findViewById(R.id.textView);


        imageView.setAnimation(moveAnim);
        textView.setAnimation(fadeAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent Intent = new Intent(logoScreen.this, menu.class);
                startActivity(Intent);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}