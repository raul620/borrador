package com.example.borrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clearPreferences();
    }


    public void clearPreferences()
    {
        try { //clearing app data
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("pm clear com.netflix.mediaclient");
            Log.d("myTag", "borro");

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("myTag", "no borro");
    }
    }
}
