package com.example.agenda_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actividades extends AppCompatActivity {
    TextView txt_saludo;

    EditText nomActivity;

    EditText tipoActivity;
    EditText fecha;

    EditText descActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        txt_saludo = findViewById(R.id.txt_saludo);
        nomActivity = findViewById(R.id.nomActivity);
        tipoActivity = findViewById(R.id.tipoActivity);
        descActivity = findViewById(R.id.descActivity);
        fecha = findViewById(R.id.fecha);

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirDialogo();
            }
        });

        cargarPreferencias();
    }

    private void abrirDialogo(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                fecha.setText(String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year));

            }
        }, 2023, 0, 1);
        dialog.show();
    }

    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("datosUser", Context.MODE_PRIVATE);

        String user = preferences.getString("username", "No existe un usuario");

        txt_saludo.setText("Bienvenido/a " + user);
    }

    public void guardarActividad(View view){
        String nombre_act = nomActivity.getText().toString();
        String datos_act = nomActivity.getText().toString()+"\n"+tipoActivity.getText().toString()+"\n"+fecha.getText().toString()+"\n"+descActivity.getText().toString();

        SharedPreferences agendashared = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = agendashared.edit();
        obj_editor.putString(nombre_act, datos_act);
        obj_editor.commit();

        nomActivity.setText("");
        tipoActivity.setText("");
        fecha.setText("");
        descActivity.setText("");
    }

    public void buscar(View view){
        if(nomActivity.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe ingresar un nombre para buscar", Toast.LENGTH_SHORT).show();
        }else{
            Intent mostrar = new Intent(this, MostrarAct.class);
            mostrar.putExtra("nombre", nomActivity.getText().toString());
            startActivity(mostrar);
        }
    }
}