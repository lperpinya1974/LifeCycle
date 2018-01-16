package com.exemple.profedam.lifecycle;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

private String txtHora;
private int numNotificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificar("onCreate");
        if (savedInstanceState == null) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            this.txtHora = sdf.format(new Date());



        }

        else
        {
            this.txtHora = savedInstanceState.getString("hora");
        }

        TextView tvHora = (TextView) findViewById(R.id.tvHora);
        tvHora.setText (this.txtHora);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("hora", this.txtHora);
    }

    @Override
    protected void onPause() {
        super.onPause();
       notificar("onPause");
    }


    @Override
    protected void onResume() {
        super.onResume();
        notificar("onResume");
    }


    @Override
    protected void onStart() {
        super.onStart();
        notificar("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        notificar("onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notificar ("onDestroy");
    }

    @Override
    protected void onStop() {


        super.onStop();
        notificar("onStop");
    }


    public void notificar (String mensaje)
    {
        Toast.makeText (this, mensaje, Toast.LENGTH_SHORT).show();
        Log.i ("tag", mensaje);
        //TODO canviar a notificacions
        android.support.v4.app.NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setContentTitle("Mensaje de Alerta")
                        .setContentText(mensaje)
                        .setContentInfo(mensaje)
                        .setTicker("Alerta!");
 /* Obtener el notificationManager del teléfono */

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

/* Decirle al manager que añada mBuilder */

        mNotificationManager.notify(numNotificacion, mBuilder.build());
        numNotificacion++;
    }

}
