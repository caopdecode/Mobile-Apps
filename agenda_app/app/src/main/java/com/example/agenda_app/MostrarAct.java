package com.example.agenda_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MostrarAct extends AppCompatActivity {

    TextView txt_nomAct;
    TextView txt_datosAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        txt_nomAct = (TextView) findViewById(R.id.txt_nomAct);
        txt_datosAct = (TextView) findViewById(R.id.txt_datosAct);

        String nombre_act = getIntent().getStringExtra("nombre");

        txt_nomAct.setText(nombre_act);
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos_act = preferencias.getString(nombre_act,"");

        txt_datosAct.setText(datos_act);
    }

    public void cerrar(View view){
        finish();
    }
}