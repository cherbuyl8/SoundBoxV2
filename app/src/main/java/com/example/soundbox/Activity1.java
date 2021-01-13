package com.example.soundbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Activity1 extends AppCompatActivity {

    private static final String TAG = "sound";
    private MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

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
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }

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


    private void playSound(int resId) {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }
        mPlayer = MediaPlayer.create(this, resId);
        mPlayer.start();
    }

    public void onClickSon1(View v) {
        playSound(R.raw.coupdefeu);

        Log.i(TAG, "on click son 1 " + getLocalClassName());
    }

    public void onClickSon2(View v) {
        playSound(R.raw.cridewilhelm);

        Log.i(TAG, "on click son 2 " + getLocalClassName());
    }

    public void onClickMainActivity(View v) {
        Log.i(TAG, "on click main activity " + getLocalClassName());
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}