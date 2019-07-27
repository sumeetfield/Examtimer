package com.example.examtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer m1,m2;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        System.exit(0);
    }


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m1=MediaPlayer.create(this,R.raw.tick);
        m2=MediaPlayer.create(this,R.raw.tong);

       final TextView done=findViewById(R.id.done);
       final TextView mnumber=findViewById(R.id.mnumber);

        new CountDownTimer(10000,1000  ){

            @Override
            public void onTick(long l ) {
                m1.start();
                mnumber.setText("Time : "+String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                done.setText("Time Over !!");
                m2.start();
                m1.stop();

            }
        }.start();

    }
}
