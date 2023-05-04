package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class loseActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_lose);

        long value=0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             value = extras.getLong("key");
            //The key argument here must match that used in the other activity
        }

        TextView score=findViewById(R.id.score);
        long ans=System.currentTimeMillis()-value-4000;
        double print=(double)(ans/1000.0);
        DecimalFormat df = new DecimalFormat("#.##");
        score.setText("Score: "+df.format(print)+" sec");

        Button start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                opengame();
            }
        });
    }

    public void opengame()
    {
        Intent ganesh = new Intent(this,Game.class);
        //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        startActivity(ganesh);
    }
}