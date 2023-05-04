package com.example.a8;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class chamgegame extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        // Simply Do noting!
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_chamgegame);



//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {



                //The key argument here must match that used in the other activity

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long value=0;
                Bundle extras = getIntent().getExtras();
                if(extras !=null)
                value=extras.getLong("key");

                timer.cancel();
                back(value);

            }

        }, 1200, 1200);
    }
    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void back(final long value)
    {
        Intent ganesh = new Intent(this,Game.class);
        //overridePendingTransition(R.anim.fade_out,R.anim.fade_in);
        long ts=value+7000;
        ganesh.putExtra("key",ts);
        startActivity(ganesh);
    }
}