package com.example.sqliteapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class camaraActivity extends AppCompatActivity {

    ImageView imgCamara;
    Button btn_camara;

    Button btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        imgCamara = (ImageView) findViewById(R.id.imgCamara);
        btn_camara = (Button) findViewById(R.id.btn_camara);
        btn_volver = (Button) findViewById(R.id.btn_volver);

        btn_camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrir_camara();
            }
        });
    }

    public void volverFun (){
        replace(new functionsFragment());
    }

    private void replace(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }

    public void abrir_camara () {
        Intent opencam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       //if (opencam.resolveActivity(getPackageManager()) != null){
            startActivityForResult(opencam, 1);
       // }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            imgCamara.setImageBitmap(imgBitmap);
        }
    }
}