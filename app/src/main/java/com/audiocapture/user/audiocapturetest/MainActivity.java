package com.audiocapture.user.audiocapturetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.io.IOException;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    private Button startBtn;
    private Button stopBtn;
    private Button playBtn;
    private Button stopPlayBtn;
    private TextView text;
    private AudioRecordPlay mARP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text1);
        // store it to sd card
        mARP = new AudioRecordPlay();
        mARP.init();

        startBtn = (Button)findViewById(R.id.start);
        startBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mARP.start();
                text.setText("Recording Point: Recording");
                startBtn.setEnabled(false);
                stopBtn.setEnabled(true);

                Toast.makeText(getApplicationContext(), "Start recording...",
                        Toast.LENGTH_SHORT).show();
            }
        });

        stopBtn = (Button)findViewById(R.id.stop);
        stopBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mARP.stop();
                stopBtn.setEnabled(false);
                playBtn.setEnabled(true);
                text.setText("Recording Point: Stop recording");

                Toast.makeText(getApplicationContext(), "Stop recording...",
                        Toast.LENGTH_SHORT).show();
            }
        });

        playBtn = (Button)findViewById(R.id.play);
        playBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mARP.play();

                playBtn.setEnabled(false);
                stopPlayBtn.setEnabled(true);
                text.setText("Recording Point: Playing");

                Toast.makeText(getApplicationContext(), "Start play the recording...",
                        Toast.LENGTH_SHORT).show();
            }
        });

        stopPlayBtn = (Button)findViewById(R.id.stopPlay);
        stopPlayBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (mARP.myPlayer != null) {
                    mARP.stopPlay();
                    playBtn.setEnabled(true);
                    stopPlayBtn.setEnabled(false);
                    text.setText("Recording Point: Stop playing");

                    Toast.makeText(getApplicationContext(), "Stop playing the recording...",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
