package com.example.wonsoyoung.myapplication05_2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //rotating image

        ImageView anim1= (ImageView) findViewById(R.id.image1);
        Animation animm = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        animm.setRepeatCount(android.view.animation.Animation.INFINITE);
        animm.setRepeatMode(android.view.animation.Animation.REVERSE);
        anim1.startAnimation(animm);


        //forward and backward image

        ImageView anim2 = (ImageView) findViewById(R.id.image2);
        TranslateAnimation animm2 = new TranslateAnimation(0.0f, -800.0f, 0.0f, 0.0f);
        animm2.setDuration(5000);
        animm2.setRepeatCount(android.view.animation.Animation.INFINITE);
        animm2.setRepeatMode(android.view.animation.Animation.REVERSE);
        anim2.startAnimation(animm2);


    }

}
