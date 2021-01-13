package com.example.soundbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "sound";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "on create " + getLocalClassName());
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

    public void onClickActivity1(View v) {
        Log.i(TAG, "on click activity 1 " + getLocalClassName());
        Intent intent = new Intent( this, Activity1.class);
        startActivity(intent);
    }

    public void onClickActivity2(View v) {
        Log.i(TAG, "on click activity 2 " + getLocalClassName());
        Intent intent = new Intent( this, Activity2.class);
        startActivity(intent);
    }

    public void onClickActivity3(View v) {
        Log.i(TAG, "on click activity 3 " + getLocalClassName());
        Intent intent = new Intent( this, Activity3.class);
        startActivity(intent);
    }
}