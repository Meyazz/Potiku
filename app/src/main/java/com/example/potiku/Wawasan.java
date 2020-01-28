package com.example.potiku;

import android.content.Intent;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class Wawasan extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wawasan);

    }

    public void artikel1(View view) {
        Intent intent = new Intent(this, Artikel1.class);
        startActivity(intent);
    }

    public void artikel2(View view) {
        Intent intent = new Intent(this, Artikel2.class);
        startActivity(intent);
    }

    public void artikel3(View view) {
        Intent intent = new Intent(this, Artikel3.class);
        startActivity(intent);
    }

    public void artikel4(View view) {
        Intent intent = new Intent(this, Artikel4.class);
        startActivity(intent);
    }

    public void artikel5(View view) {
        Intent intent = new Intent(this, Artikel5.class);
        startActivity(intent);
    }

    public void artikel6(View view) {
        Intent intent = new Intent(this, Artikel6.class);
        startActivity(intent);
    }
}


