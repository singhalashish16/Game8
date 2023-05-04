package com.example.a8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        // Simply Do noting!
    }
    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game);

        long value=System.currentTimeMillis();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getLong("key");
            //The key argument here must match that used in the other activity
        }
        long timestart= value;


        final Button[] b=new Button[8];
        b[1]=(Button) findViewById(R.id.b1);
        b[2]=(Button) findViewById(R.id.b2);
        b[3]=(Button) findViewById(R.id.b3);
        b[4]=(Button) findViewById(R.id.b4);
        b[5]=(Button) findViewById(R.id.b5);
        b[6]=(Button) findViewById(R.id.b6);
        b[7]=(Button) findViewById(R.id.b7);


        final Button[] s=new Button[8];
        s[1]=(Button) findViewById(R.id.s1);
        s[2]=(Button) findViewById(R.id.s2);
        s[3]=(Button) findViewById(R.id.s3);
        s[4]=(Button) findViewById(R.id.s4);
        s[5]=(Button) findViewById(R.id.s5);
        s[6]=(Button) findViewById(R.id.s6);
        s[7]=(Button) findViewById(R.id.s7);

        for(int i=1;i<=7;i++)
            s[i].setBackgroundColor(Color.parseColor("#6A6767"));

         int[] arr=new int[8];
         int setcount=1;
        while(setcount<=3)
        {
            Random random=new Random();
            int r=random.nextInt(7)+1;
            if(arr[r]==0)
            {
                arr[r]=1;
                setcount++;
            }
        }
        //arr[1]=1;

        for(int i=1;i<=7;i++) {
            if(arr[i]==1)
            s[i].setBackgroundColor(Color.parseColor("#FF0000"));
        }

        for(int i=1;i<=7;i++)
            b[i].setBackgroundColor(Color.parseColor("#6A6767"));

        long delay=400,period=800;
        int playcount=12;

        fun(b,arr,delay,period,playcount,timestart);
//        delay=400;period=800;playcount=15;
//        fun(b,rs1,rs2,delay,period,playcount);



    }


   // @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void change(long timestart)
    {
        Intent ganesh = new Intent(this,loseActivity.class);
//        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        long ts=timestart;
        ganesh.putExtra("key",ts);
        startActivity(ganesh);
//        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
//        Intent intent = new Intent(this, loseActivity.class);
//        startActivity(intent, options.toBundle());
//        finish();
    }
    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void repeat(long timestart)
    {
//        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
//        Intent intent = new Intent(this, chamgegame.class);
//        startActivity(intent, options.toBundle());
        Intent ganesh = new Intent(this,chamgegame.class);
        long ts=timestart;
        ganesh.putExtra("key",ts);
        //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        startActivity(ganesh);
    }

    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void fun(final Button[] b, final int[] arr, final long t1, final long t2, final int playcount,final long timestart)
    {


        final Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {


                                      int c=0;
                                      int play=playcount;
                                      int prevr=0;

                                      //long tempdelay=t1;
                                      @Override
                                      public void run() {
                                          //Called each time when 1000 milliseconds (1 second) (the period parameter)
                                          //int c=0;

                                          int click=0;
                                          if(c==0 && playcount==12)
                                          {
                                              try {
                                                  Thread.sleep(3000);
                                              } catch (InterruptedException e) {
                                                  e.printStackTrace();
                                              }

                                              c=1;
                                          }
                                          for(int i=1;i<=7;i++)
                                              b[i].setBackgroundColor(Color.parseColor("#6A6767"));
                                          try {
                                              Thread.sleep(t1);
                                          } catch (InterruptedException e) {
                                              e.printStackTrace();
                                          }


                                          Random random=new Random();
                                          int r=random.nextInt(7)+1;
                                          if(r==prevr)
                                          {
                                              while(r==prevr)
                                                  r=random.nextInt(7)+1;
                                          }

                                          b[r].setBackgroundColor(Color.parseColor("#FF0000"));
                                          prevr=r;
                                          if(arr[r]==1)
                                          {
                                              long time=System.currentTimeMillis();

                                              while(System.currentTimeMillis()-time<=t2)
                                              {
                                                  if(b[r].isPressed())
                                                  {
                                                      click=1;
                                                      break;
                                                  }
                                              }

                                              if(click==0) {
                                                  timer.cancel();
                                                  change(timestart);
                                              }

                                          }
                                          else
                                          {
                                              long time=System.currentTimeMillis();

                                              while(System.currentTimeMillis()-time<=t2)
                                              {
                                                  if(b[r].isPressed())
                                                  {
                                                      timer.cancel();
                                                      change(timestart);
                                                  }
                                              }
                                          }

                                          if(t2<=400) {
                                              timer.cancel();
                                              play=2;
                                              repeat(timestart);

                                          }

                                          play--;
                                          if(play==0) {
                                              timer.cancel();
                                              extra(b,arr,(t1-50),(t2-100),11,timestart);
                                          }
                                      }

                                  },
                t2,
                t2);

    }
    public void extra(final Button[] b,final int[] arr,final long t1,final long t2,final int playcount,final long timestart)
    {
        fun(b,arr,t1,t2,playcount,timestart);
    }
}