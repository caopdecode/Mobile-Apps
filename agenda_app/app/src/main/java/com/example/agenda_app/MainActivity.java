package com.example.agenda_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText user;


    TextView txt_nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);

    }

    public void iniciosesion (View view) {
        SharedPreferences preferences = getSharedPreferences("datosUser", Context.MODE_PRIVATE);

        String usuario = user.getText().toString();
        String password = user.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", usuario);

        editor.commit();

        Intent agendanew = new Intent(this, Actividades.class);
        startActivity(agendanew);
    }

    public void cargarsesion (View view){
        Intent agendaold = new Intent(this, Actividades.class);
        startActivity(agendaold);
    }
}