package com.exemple.profedam.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

private String txtHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificar("onCreate");
        if (savedInstanceState == null) {
            Calendar dataActual = Calendar.getInstance();
            int hora = dataActual.get(Calendar.HOUR_OF_DAY);
            int minut = dataActual.get(Calendar.MINUTE);
            int segon = dataActual.get(Calendar.SECOND);


            this.txtHora = "Hora: " + hora + ":" + minut + ":" + segon;
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
    }

}
