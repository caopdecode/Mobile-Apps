package com.example.aleatoriojuego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText limite_inf;
    EditText limite_sup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        limite_inf = findViewById(R.id.limite_inf);
        limite_sup = findViewById(R.id.limite_sup);
    }

    public void aleatorio (View view) {
        String liminf = limite_inf.getText().toString();
        String limsup = limite_sup.getText().toString();



        if (liminf.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Ingrese por favor valores todos los valores", Toast.LENGTH_LONG).show();
            return;
        } else {
            if (liminf.equals("0")) {
                limite_inf.setError("Por favor inserte un valor diferente de 0");
                return;
            }
        }

        if (limsup.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Ingrese por favor valores todos los valores", Toast.LENGTH_LONG).show();
            return;
        } else {
            if (limsup.equals("0")) {
                limite_sup.setError("Por favor inserte un valor diferente de 0");
                return;
            }
        }

        /*if (liminf.equals("") || limsup.equals("")){
            limite_inf.setError("Por favor inserte limite inferior");
            limite_sup.setError("Por favor inserte limite superior");
            Toast.makeText(getApplicationContext(), "Ingrese por favor valores todos los valores", Toast.LENGTH_LONG).show();
        } else if (liminf.equals("0") || limsup.equals("0")) {
            if (liminf.equals("0")){
            limite_inf.setError("Por favor inserte un valor diferente de 0");
            } else{
            limite_sup.setError("Por favor inserte un valor diferente de 0");
            }
            Toast.makeText(getApplicationContext(), "Ingrese por favor valores diferentes a 0", Toast.LENGTH_LONG).show();
        } else if (sup < inf){
            Toast.makeText(getApplicationContext(), "El limite superior, no puede ser menor que el limite inferior ", Toast.LENGTH_LONG).show();
        } else { */
        int inf = Integer.parseInt(liminf);
        int sup = Integer.parseInt(limsup);
        int aleatorioNum = (int) ((Math.random() * (sup - inf)) + inf);
        String numberVar = Integer.toString(aleatorioNum);
        //Toast.makeText(getApplicationContext(), "El numero es: " + aleatorioNum, Toast.LENGTH_LONG).show();
        Intent adivinar = new Intent(this, MainActivity2.class);
        adivinar.putExtra("numAleatorio", numberVar);
        startActivity(adivinar);
      //}
    }
}