package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registroActivity extends AppCompatActivity {
    //DECLARACION DE VARIABLES OBJETOS INTERFAZ GRAFICA
    EditText txt_nombreuser, txt_nombre, txt_correo, txt_contra;
    Button btn_registrar, button;

    dbUsuario db;

    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //SE SOLICITAN OBJETOS A PARTIR DE SU ID
        txt_nombreuser = (EditText) findViewById(R.id.txt_nombreuser);
        txt_nombre = (EditText) findViewById(R.id.txt_nombre);
        txt_correo = (EditText) findViewById(R.id.txt_correo);
        txt_contra = (EditText) findViewById(R.id.txt_contra);
        btn_registrar = (Button) findViewById(R.id.btn_registrar);
        button = (Button) findViewById(R.id.button);

        //SE CREA UN OBJETO DE LA CLASE DBUSUARIO CON EL FIN DE PODER LLAMAR LOS METODOS PARA EL MANEJO DE LA BASE DE DATOS
        db = new dbUsuario(this);

        //SE CREA METODO PARA ASIGNAR UNA ACCION AL BOTON REGISTRAR
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SE CREA UN OBJETO DE LA CLASE USUARIO, PARA PODER ACCEDER A LAS VARIABLES DE DICHA CLASE
                //LAS CUALES ALMACENAN INFORMACION DE CADA USUARIO
                usuario u = new usuario();

                //SE LE ASIGNA A LAS VARIABLES DE LA CLASE USUARIO LOS DATOS INGRESADOS EN LOS CAMPOS DE REGISTRO
                u.setNom_user(txt_nombreuser.getText().toString());
                u.setNombre(txt_nombre.getText().toString());
                u.setCorreo_e(txt_correo.getText().toString());
                u.setContrasena(txt_contra.getText().toString());

                //POR MEDIO DE UN IF SE EVALUA QUE LOS CAMPOS NO ESTEN VACIOS, Y QUE EL USUARIO NO ESTE EN LA BASE DE DATOS
                //PARA PODER PROCEDER CON EL REGISTRO E INSERTAR LOS DATOS.
                if (!u.isNull()){
                    Toast.makeText(getApplicationContext(), "Por favor rellene todos los campos", Toast.LENGTH_LONG).show();
                } else if (u.isNull()){
                    db.insertUser(u);
                    Toast.makeText(getApplicationContext(), "¡REGISTRO COMPLETO!", Toast.LENGTH_LONG).show();
                    Intent i3 = new Intent(registroActivity.this, MainActivity.class);
                    startActivity(i3);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Ya existe el usuario ingresado", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "El usuario es: " + u.getNom_user(), Toast.LENGTH_LONG).show();
                }
            }
        });

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0){
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    public int hideSystemBars(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    //METODO PARA DARLE UNA ACCION AL BOTON DE YA TENGO UNA CUENTA
    public void ini (View view){
        Intent i4 = new Intent(registroActivity.this, MainActivity.class);
        startActivity(i4);
    }
}