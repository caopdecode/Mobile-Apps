package com.example.video_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView repvideo;
    Intent fileIntent;
    Button button;

    TextView txt_ruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repvideo = (VideoView) findViewById(R.id.repvideo);
        button = (Button) findViewById(R.id.button);

        MediaController controles = new MediaController(this);
        repvideo.setMediaController(controles);
        controles.setAnchorView(repvideo);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                fileIntent.setType("*/*");
                startActivityForResult(fileIntent, 10);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 10:
                if (resultCode == RESULT_OK){
                    //String ruta = data.getData().getPath();
                    Uri uri = data.getData();
                    //txt_ruta.setText(uri);
                    repvideo.setVideoURI(uri);
                    repvideo.start();


                }
                break;
        }
    }
}