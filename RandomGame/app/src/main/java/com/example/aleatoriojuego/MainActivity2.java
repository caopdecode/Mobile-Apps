package com.example.aleatoriojuego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText num_adivina;
    private int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        num_adivina = findViewById(R.id.num_adivina);
    }

    public void adivinar (View view) {
        String numAleatorio = getIntent().getStringExtra("numAleatorio");
        String numAdivina = num_adivina.getText().toString();

        int numAle = Integer.parseInt(numAleatorio);
        int numAdi = Integer.parseInt(numAdivina);



        if (numAdivina.equals("")) {
            Toast.makeText(getApplicationContext(), "Por favor ingrese un numero para adivinar", Toast.LENGTH_LONG).show();
        } else if (numAdivina.equals("0")) {
            Toast.makeText(getApplicationContext(), "Ingrese por favor valores diferentes a 0", Toast.LENGTH_LONG).show();
        } else if (numAdi > numAle) {
            c = c + 1;
            Toast.makeText(getApplicationContext(), "Numero incorrecto. El numero a adivinar es menor, llevas " + c + " intentos", Toast.LENGTH_LONG).show();
        } else if (numAdi < numAle) {
            c = c + 1;
            Toast.makeText(getApplicationContext(), "Numero incorrecto. El numero a adivinar es mayor, llevas " + c + " intentos", Toast.LENGTH_LONG).show();
        } else {
            c = c + 1;
            Toast.makeText(getApplicationContext(), "Felicidades, adivinaste el numero correcto en " + c + " intentos", Toast.LENGTH_LONG).show();
        }
    }
}