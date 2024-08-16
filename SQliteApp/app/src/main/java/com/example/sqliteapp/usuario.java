package com.example.sqliteapp;

public class usuario {
    //CREACION DE VARIABLES DEL USUARIO
    String Nom_user, Nombre, Correo_e, Password;

    //CONSTRUCTOR
    public usuario() {
    }

    //METODO PARA VERIFICAR QUE VALORES NO SEAN NULOS
    public boolean isNull(){
        if (Nom_user.equals("") || Nombre.equals("") || Correo_e.equals("") || Password.equals("")){
            return false;
        } else {
            return true;
        }
    }

    //CONSTRUCTOR DE CADA VARIABLE
    public usuario(String nom_user, String nombre, String correo_e, String password) {
        Nom_user = nom_user;
        Nombre = nombre;
        Correo_e = correo_e;
        Password = password;
    }

    //METODO TOSTRING DE CADA VARIABLE
    @Override
    public String toString() {
        return "usuario{" +
                "Nom_user='" + Nom_user + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Correo_e='" + Correo_e + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    //GETTERS Y SETTERS DE LAS VARIABLES
    public String getNom_user() {
        return Nom_user;
    }

    public void setNom_user(String nom_user) {
        Nom_user = nom_user;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo_e() {
        return Correo_e;
    }

    public void setCorreo_e(String correo_e) {
        Correo_e = correo_e;
    }

    public String getContrasena() {
        return Password;
    }

    public void setContrasena(String password) {
        Password = password;
    }
}
