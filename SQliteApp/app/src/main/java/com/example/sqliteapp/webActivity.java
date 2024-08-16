package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class webActivity extends AppCompatActivity {

    EditText txt_url;
    Button btn_buscarWeb;
    Button btn_regresarfun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        txt_url = (EditText) findViewById(R.id.txt_url);
        btn_buscarWeb = (Button) findViewById(R.id.btn_buscarWeb);
        btn_regresarfun = (Button) findViewById(R.id.btn_regresarfun);
    }

    public void volverFun2 (View view){
        replace(new functionsFragment());
    }

    private void replace(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }

    public void navegarWeb(View view){
        Intent web = new Intent(this, webviewActivity.class);
        web.putExtra("urlweb", txt_url.getText().toString());
        startActivity(web);
    }
}