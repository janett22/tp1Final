package com.example.trabajopractico1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class HacerLlamada extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean conectado =intent.getExtras().getBoolean("connected");

        if(conectado){
        Toast.makeText(context, "Se va a realizar una llamada", Toast.LENGTH_LONG).show();
          Intent i=new Intent(intent.ACTION_CALL, Uri.parse("tel: +54 266 457-5882"));
          context.startActivity(i);
        }


    }
}
