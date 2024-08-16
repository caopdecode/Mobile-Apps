package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
   //DECLARACION DE VARIABLES OBJETOS INTERFAZ GRAFICA
   EditText txt_user;
   EditText txt_pass;
   Button btn_iniciar;
   Button btn_crear;
   dbUsuario db;
   private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SE SOLICITAN OBJETOS A PARTIR DE SU ID
        txt_user = (EditText) findViewById(R.id.txt_user);
        txt_pass = (EditText) findViewById(R.id.txt_pass);
        btn_iniciar = (Button) findViewById(R.id.btn_iniciar);
        btn_crear = (Button) findViewById(R.id.btn_crear);

        //SE CREA UN OBJETO DE LA CLASE DBUSUARIO CON EL FIN DE PODER LLAMAR LOS METODOS PARA EL MANEJO DE LA BASE DE DATOS
        db = new dbUsuario(this);

        //SE CREA METODO PARA ASIGNAR UNA ACCION AL BOTON INICIAR
        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SE CREAN DOS VARIABLES QUE ALMACENARAN LOS DATOS INGRESADOS EN EL CAMPO USER Y PASSWORD
                String u = txt_user.getText().toString();
                String p = txt_pass.getText().toString();

                //POR MEDIO DE UN IF SE EVALUA QUE LOS CAMPOS NO ESTEN VACIOS, Y QUE EL USUARIO ESTE EN LA BASE DE DATOS
                //PARA PODER PROCEDER CON EL INICIO DE SESION
                if(u.equals("") || p.equals("")){
                    Toast.makeText(getApplicationContext(), "Por favor rellene todos los campos", Toast.LENGTH_LONG).show();
                } else if(db.login(u,p)==1) {
                    //usuario ux = db.getUsuario(u,p);
                    Toast.makeText(getApplicationContext(), "Inicio de Sesión Exitoso", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(MainActivity.this, inicioActivity.class);
                    i2.putExtra("username", u);
                    //i2.putExtra("pass", ux.getContrasena());
                    startActivity(i2);
                } else{
                    Toast.makeText(getApplicationContext(), "Usuario y/o Password incorrectos", Toast.LENGTH_LONG).show();
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

    @Override
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



    /*public void iniciar (View view) {
        db = new dbUsuario(this);
        String u = txt_username.getText().toString();
        String p = txt_pass.getText().toString();

        if(u.equals("") || p.equals("")){
            Toast.makeText(getApplicationContext(), "Por favor rellene todos los campos", Toast.LENGTH_LONG).show();
        } else if(db.login(u,p)==1) {
            usuario ux = db.getUsuario(u,p);
            Toast.makeText(getApplicationContext(), "Inicio de Sesión Exitoso", Toast.LENGTH_LONG).show();
            Intent i5 = new Intent(MainActivity.this, inicioActivity.class);
            i5.putExtra("username", ux.getNom_user());
            i5.putExtra("pass", ux.getContrasena());
            startActivity(i5);
        } else{
            Toast.makeText(getApplicationContext(), "Usuario y/o Password incorrectos", Toast.LENGTH_LONG).show();
        }
    }*/

    //METODO PARA DARLE UNA ACCION AL BOTON DE REGISTRO
    public void registrar (View view){
        Intent i = new Intent(this, registroActivity.class);
        startActivity(i);
    }
}