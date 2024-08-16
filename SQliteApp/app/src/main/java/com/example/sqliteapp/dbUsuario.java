package com.example.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class dbUsuario {
    //SE CREAN VARIABLES RELACIONADAS A LA BASE DE DATOS
    Context c;
    usuario u;
    ArrayList<usuario> lista;
    SQLiteDatabase sql;
    String db = "DBUsuarios";
    String table = "CREATE TABLE IF NOT EXISTS usuarios (nom_user VARCHAR PRIMARY KEY, nombre VARCHAR, correo_e VARCHAR, password VARCHAR)";
    //SE INICIALIZAN VARIABLES EMPLEADAS EN METODOS COMO CONTADORES
    int a = 0;
    int x = 0;
    int val = 0;

    //SE CREA LA BASE DE DATOS CON METODO DBUSUARIO
    public dbUsuario(Context c){
        this.c = c;

        sql = c.openOrCreateDatabase(db, c.MODE_PRIVATE, null);
        sql.execSQL(table);
        u = new usuario();
    }

    //METODO PARA INSERTAR USUARIOS DENTRO DE LA TABLA DE LA BASE DE DATOS
    public void insertUser(usuario u){
        usuario us = new usuario();
        if (!u.getNom_user().isEmpty()){
            sql.execSQL("INSERT INTO usuarios (nom_user, nombre, correo_e, password) VALUES('"+u.getNom_user()+"', '"+u.getNombre()+"', '"+u.getCorreo_e()+"', '"+u.getContrasena()+"')");
        } else {}
    }

    public int buscar(String u){
        lista = selectUsuario();
        for (usuario us:lista){
            if (us.getNom_user().equals(u)){
                x++;
            }
        }
        return x;
    }

    public void consultar(String u){
        usuario us = new usuario();

        Cursor datos = sql.rawQuery("SELECT * FROM usuarios WHERE nom_user =" + us.getNom_user().equals(u), null);

        if(datos.moveToFirst()){
            val++;
            sql.close();
        } else {
            sql.close();
        }
    }

    public ArrayList<usuario> selectUsuario(){
        ArrayList<usuario> lista = new ArrayList<usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("SELECT * FROM usuarios", null);
        if (cr != null && cr.moveToFirst()){
            do {
                usuario u = new usuario();
                u.setNom_user(cr.getString(1));
                u.setNombre(cr.getString(2));
                u.setCorreo_e(cr.getString(3));
                u.setContrasena(cr.getString(4));
                lista.add(u);
            } while(cr.moveToNext());
        }
        return lista;
    }

    public int consulta(String u){
        Cursor cr = sql.rawQuery("SELECT * FROM usuarios", null);
        if (cr != null && cr.moveToFirst()){
            do {
                if (cr.getString(0).equals(u)){
                    a++;
                }
            } while(cr.moveToNext());
        }
        return a;
    }

    //METODO PARA VERIFICAR USUARIO Y CONTRASEÑA PARA PODER INICIAR SESION
    public int login(String u, String p){
       Cursor cr = sql.rawQuery("SELECT * FROM usuarios", null);
        if (cr != null && cr.moveToFirst()){
            do {
                if (cr.getString(0).equals(u) && cr.getString(3).equals(p)){
                    a++;
                }
            } while(cr.moveToNext());
        }
        return a;
    }

    public usuario getUsuario(String u, String p){
        lista = selectUsuario();
        for(usuario us:lista){
            if (us.getNom_user().equals(u) && us.getContrasena().equals(p)){
                return us;
            }
        }
        return null;
    }
}
