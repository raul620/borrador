package com.example.borrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clearPreferences();
    }


    public void clearPreferences()
    {


        try {
            Process p = Runtime.getRuntime().exec("su");
            DataOutputStream dos = new DataOutputStream(p.getOutputStream());
            dos.writeBytes("pm clear com.netflix.mediaclient\n");
            dos.writeBytes("exit\n");
            dos.flush();
            dos.close();
            p.waitFor();
            moveTaskToBack(true);
            int q = android.os.Process.myPid();
            android.os.Process.killProcess(q);
        } catch (IOException e) {
            moveTaskToBack(true);
            int q = android.os.Process.myPid();
            android.os.Process.killProcess(q);
            e.printStackTrace();

        } catch (InterruptedException e) {
            moveTaskToBack(true);
            int q = android.os.Process.myPid();
            android.os.Process.killProcess(q);
            e.printStackTrace();

        }


    }
}
