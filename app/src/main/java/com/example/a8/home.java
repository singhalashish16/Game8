package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        // Simply Do noting!
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_home);


        final MediaPlayer ring= MediaPlayer.create(this,R.raw.gametune_thandihawa);
        ring.start();

        Button start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ring.stop();
                opengame();
            }
        });

        Button inst = findViewById(R.id.inst);
        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ring.stop();
                openinst1();
            }
        });


    }

    public void opengame()
    {
        Intent ganesh = new Intent(this,Game.class);
        //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        startActivity(ganesh);
    }
    public void openinst1()
    {
        Intent ganesh = new Intent(this,inst1.class);
        //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        startActivity(ganesh);
    }


}