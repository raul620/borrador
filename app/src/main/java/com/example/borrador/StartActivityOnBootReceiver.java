package com.example.borrador;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class StartActivityOnBootReceiver extends BroadcastReceiver {

    @Override
    //inicio de activodad al arrancar el dispositivo android
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}