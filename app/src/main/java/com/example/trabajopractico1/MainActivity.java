package com.example.trabajopractico1;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

 private HacerLlamada hLL;

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
             && checkSelfPermission(Manifest.permission.CALL_PHONE)
             != PackageManager.PERMISSION_GRANTED) {
         requestPermissions(new String []{Manifest.permission.CALL_PHONE}, 1000);
     }
//probando cambios
 }


    @Override
    protected void onResume() {
        super.onResume();
        hLL= new HacerLlamada();
        registerReceiver(hLL, new IntentFilter("android.hardware.usb.action.USB_STATE"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(hLL);

    }

}