package com.example.wonsoyoung.myapplication05_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickimg1(View view) {
        Intent myIntent = new Intent(this, Secondpage.class);
        startActivity(myIntent);
    }

    public void onClickimg2(View view) {
        Toast.makeText(getApplicationContext(), "Children: Two Children"+"\n"+"ggg", Toast.LENGTH_SHORT).show();
    }
}
