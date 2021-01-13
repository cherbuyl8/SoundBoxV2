package com.example.soundbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Activity3 extends AppCompatActivity {

    private static final String TAG = "sound";
    private int PERMISSION_CODE = 21;
    private MediaRecorder mediaRecorder;
    private String recordFile;
    private TextView filenameText;

    private Chronometer recordTimer;

    private ImageButton recordButton;

    private boolean isRecording = false;

    private String recordPermission = Manifest.permission.RECORD_AUDIO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        recordTimer = findViewById(R.id.record_chrono);
        recordButton = findViewById(R.id.button_record);

        Log.i(TAG, "past value : " + getLocalClassName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "on start " + getLocalClassName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaRecorder != null) {
            mediaRecorder.release();
            mediaRecorder = null;
        }

        Log.i(TAG, "on stop " + getLocalClassName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "on destroy " + getLocalClassName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "on pause " + getLocalClassName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "on resume " + getLocalClassName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "on restart " + getLocalClassName());
    }

    public void onClickRecord(View v) {
        if(isRecording){
            //stop
            stopRecording();
            isRecording=false;
        }else{
            //start
            if(checkPermissions()){
                startRecording();
                isRecording=true;
            }
        }

        Log.i(TAG, "on click record " + getLocalClassName());
    }

    private boolean checkPermissions() {
        if(ActivityCompat.checkSelfPermission(getBaseContext(), recordPermission) == PackageManager.PERMISSION_GRANTED){
            return true;
        }else {
            ActivityCompat.requestPermissions(Activity3.this, new String[]{recordPermission}, PERMISSION_CODE);
            return false;
        }
    }

    private void stopRecording() {
        recordTimer.stop();

        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
    }

    private void startRecording() {
        recordTimer.setBase(SystemClock.elapsedRealtime());
        recordTimer.start();

        String recordPath = Environment.getExternalStorageDirectory().toString();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss", Locale.FRANCE);
        Date date = new Date();

        recordFile = "Recording_" + formatDate.format(date) + ".3gp";

        filenameText.setText("Recording, File Name : " + recordFile);

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(recordPath + "/" + recordFile);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);


        Log.i(TAG, "recording file Path : " + recordPath + "/" + recordFile + " " + getLocalClassName());

        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            Log.i(TAG, "recording prepare failed " + getLocalClassName());
        }

        mediaRecorder.start();
    }

    public void onClickMainActivity(View v) {
        Log.i(TAG, "on click main activity " + getLocalClassName());
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        //ceci est un test de commit3
    }
}