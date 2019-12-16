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
        //llamado de la funcion de limpieza al abrir el app Borrador
        clearPreferences();
    }


    public void clearPreferences()
    {


        try {
            //adquirir nivel super usuario
            Process p = Runtime.getRuntime().exec("su");
            DataOutputStream dos = new DataOutputStream(p.getOutputStream());
            //instruccion de borrado mediante nombre de paquete, se puede enviar n cantidad de paquetes
            dos.writeBytes("pm clear com.netflix.mediaclient\n");
            dos.writeBytes("exit\n");
            dos.flush();
            dos.close();
            p.waitFor();
            //ir atras para minimizar la aplicacion
            moveTaskToBack(true);
            //cerrar la aplicacion luego de ejecutar el proceso de borrado
            int q = android.os.Process.myPid();
            android.os.Process.killProcess(q);
        } catch (IOException e) {
            //ir atras para minimizar la aplicacion
            moveTaskToBack(true);
            //cerrar la aplicacion luego de ejecutar el proceso de borrado
            int q = android.os.Process.myPid();
            android.os.Process.killProcess(q);
            e.printStackTrace();

        } catch (InterruptedException e) {
            //ir atras para minimizar la aplicacion
            moveTaskToBack(true);
            //cerrar la aplicacion luego de ejecutar el proceso de borrado
            int q = android.os.Process.myPid();
            android.os.Process.killProcess(q);
            e.printStackTrace();

        }


    }
}
