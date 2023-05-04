package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.security.keystore.StrongBoxUnavailableException;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import java.util.*;

import static com.example.a8.R.color.gray;
import static com.example.a8.R.color.red;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        // Simply Do noting!
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        //int img[]={R.drawable.fr_1,R.drawable.fr_2,R.drawable.fr_3,R.drawable.fr_4,R.drawable.fr_5,R.drawable.fr_6};
        //ViewFlipper flipper = findViewById(R.id.flipper);

        final RelativeLayout layout =(RelativeLayout)findViewById(R.id.background);
//         layout.setBackgroundResource(R.drawable.fr_1);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        final Timer timer=new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {



            @Override
            public void run() {
                layout.setBackgroundResource(R.drawable.fr_1);
                try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                layout.setBackgroundResource(R.drawable.fr_2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                layout.setBackgroundResource(R.drawable.fr_3);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                layout.setBackgroundResource(R.drawable.fr_4);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                layout.setBackgroundResource(R.drawable.fr_5);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                layout.setBackgroundResource(R.drawable.fr_6);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                timer.cancel();
                switchhome();


            }

            },
                0,
                7000);
        //int flip=0;
        //flipper.setAutoStart(true);
//        for(int i=0;i<img.length;i++)
//        {
//            //  This will create dynamic image view and add them to ViewFlipper
//            //flipper.setAutoStart(true);
//            String s="fr_"+(i+1);
//            layout.setBackgroundResource(R.drawable.fr_1);
//
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//        }




    }

    public void switchhome()
    {
        Intent ganesh = new Intent(this,home.class);
        startActivity(ganesh);
    }


}