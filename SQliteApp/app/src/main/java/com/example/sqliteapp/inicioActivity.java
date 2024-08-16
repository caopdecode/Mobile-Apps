package com.example.sqliteapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class inicioActivity extends AppCompatActivity {
    //DECLARACION DE VARIABLES OBJETOS INTERFAZ GRAFICA
    AnimatedBottomBar bottom_bar;
    Button btn_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        //SE SOLICITAN OBJETOS A PARTIR DE SU ID
        bottom_bar = findViewById(R.id.bottom_bar);

        replace(new homeFragment());

        bottom_bar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NonNull AnimatedBottomBar.Tab tab1) {
               if (tab1.getId()==R.id.home){
                   replace(new homeFragment());
               } else if (tab1.getId()==R.id.functions){
                   replace(new functionsFragment());
               }else if (tab1.getId()==R.id.profile) {
                   replace(new profileFragment());
               } else if (tab1.getId()==R.id.settings){
                   replace(new settingsFragment());
               }
            }

            @Override
            public void onTabReselected(int i, @NonNull AnimatedBottomBar.Tab tab) {

            }
        });
    }

    private void replace(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }
}