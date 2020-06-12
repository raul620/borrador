package com.example.borrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.felipecsl.gifimageview.library.GifImageView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtil;

public class MainActivity extends AppCompatActivity {

    private GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //llamado de la funcion de limpieza al abrir el app Borrador
        gifImageView =findViewById(R.id.gifImageView);
        try{
            InputStream inputStream = getAssets().open("borrado.gif");
            byte[] bytes = IOUtil.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException ex)
        {
        }
        clearPreferences();
    }


    public void clearPreferences()
    {

        /* //metodo 1

        try { // clearing app data
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("pm clear com.netflix.mediaclient\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //**************************
        */

        //metodo 2

        try {
                   //adquirir nivel super usuario
                    Process p = Runtime.getRuntime().exec("su");
                    DataOutputStream dos = new DataOutputStream(p.getOutputStream());
                    //instruccion de borrado mediante nombre de paquete, se puede enviar n cantidad de paquetes
                    dos.writeBytes("pm clear com.netflix.mediaclient\n");
                    dos.writeBytes("pm clear com.hbo.android.app\n");
                    dos.writeBytes("pm clear com.amazon.avod.thirdpartyclient\n");
                    dos.writeBytes("pm clear tv.wuaki\n");
                    dos.writeBytes("pm clear com.dazn\n");
                    dos.writeBytes("pm clear es.plus.yomvi\n");
                    dos.writeBytes("pm clear ptv.bein.mena\n");
                    dos.writeBytes("pm clear com.spotify.music\n");
                    dos.writeBytes("pm clear com.amazon.mp3\n");
                    dos.writeBytes("pm clear com.soundcloud.android\n");
                    dos.writeBytes("pm clear deezer.android.app\n");
                    dos.writeBytes("pm clear com.aspiro.tidal\n");
                    dos.writeBytes("pm clear com.android.vending\n");
                    dos.writeBytes("pm clear com.google.android.gms\n");
                    dos.writeBytes("pm clear com.google.android.apps.maps\n");
                    dos.writeBytes("pm clear com.android.chrome\n");
                    dos.writeBytes("adb shell am start -n com.google.android.gsf.login/\n");
                    dos.writeBytes("adb shell am start -n com.google.android.gsf.login.LoginActivity\n");
                    dos.writeBytes("adb shell content insert --uri content://settings/secure --bind name:s:user_setup_complete --bind value:s:1\n");
                    dos.writeBytes("adb shell content insert --uri content://settings/secure --bind name:s:user_setup_complete --bind value:s:1\n");
                    dos.writeBytes("exit\n");
                    dos.flush();
                    dos.close();
                    p.waitFor();
                   /* //ir atras para minimizar la aplicacion
                    moveTaskToBack(true);
                    //cerrar la aplicacion luego de ejecutar el proceso de borrado
                    int q = android.os.Process.myPid();
                    android.os.Process.killProcess(q);*/

            new Handler().postDelayed(new Runnable(){
                public void run(){
                Destroy();
                }
            }, 3000);
                } catch (IOException e) {
                    /*//ir atras para minimizar la aplicacion
                    moveTaskToBack(true);
                    //cerrar la aplicacion luego de ejecutar el proceso de borrado
                    int q = android.os.Process.myPid();
                    android.os.Process.killProcess(q);*/
                    e.printStackTrace();

            new Handler().postDelayed(new Runnable(){
                public void run(){
                    Destroy();
                }
            }, 3000);

                } catch (InterruptedException e) {
                    /*//ir atras para minimizar la aplicacion
                    moveTaskToBack(true);
                    //cerrar la aplicacion luego de ejecutar el proceso de borrado
                    int q = android.os.Process.myPid();
                    android.os.Process.killProcess(q);*/
                    e.printStackTrace();

            new Handler().postDelayed(new Runnable(){
                public void run(){
                    Destroy();
                }
            }, 3000);

                }
            }


    protected void Destroy() {
        //ir atras para minimizar la aplicacion
        moveTaskToBack(true);
        //cerrar la aplicacion luego de ejecutar el proceso de borrado
        int q = android.os.Process.myPid();
        android.os.Process.killProcess(q);
    }
    }

