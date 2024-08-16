package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webviewActivity extends AppCompatActivity {

    WebView visorWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        visorWeb = (WebView) findViewById(R.id.visorWeb);

        String userUrl = getIntent().getStringExtra("urlweb");
        visorWeb.setWebViewClient(new WebViewClient());
        visorWeb.loadUrl("http://" + userUrl);
    }

    public void regresar (View view){
        Intent reg = new Intent(this, webActivity.class);
        startActivity(reg);
    }
}