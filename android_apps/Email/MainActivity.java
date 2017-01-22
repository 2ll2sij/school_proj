package com.example.wonsoyoung.myemailapplication;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void test(int value) {Log.i("tag","reach here");}

    public void button3(View v){
        Button myBtn = (Button) findViewById(R.id.button3);

        Intent myIntent = new Intent(this, SecondActivity.class);   //explicit intent
        startActivity(myIntent);
        //a
        myBtn.setText("Hi");
    }

    public void radiobutton(View v){
        TextView txt = (TextView) findViewById(R.id.textView2);

//        txt.setText("Radio Button Selected");
        Toast.makeText(getApplicationContext(),"Radio Button selected",Toast.LENGTH_SHORT).show();

    }


    public void checkEmail(View v){
//        Log.i("xxxx","reach");
        String[] TO = {"andrew_yoong@sutd.edu.sg","Ayoong1@gmail.com"};
        String[] CC = {"andrew_yoong@sutd.edu.sg"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);     //implicit intent
//        Log.i("xxxx","reach1");

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");


//        startActivity(Intent.createChooser(emailIntent, "Send mail..."));

        try{
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        }
        catch(Exception e){

            Toast.makeText(getApplicationContext(),"no email can be sent",Toast.LENGTH_SHORT).show();

        }
    }

}
