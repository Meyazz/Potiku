package com.example.potiku;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Artikel1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel1);
    }

    public void openWeb(View view){
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        // Parse the location and create the intent.

        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse("https://www.fimela.com/lifestyle-relationship/read/4094087/jadi-lebih-sering-buang-air-besar-ternyata-ini-tanda-yang-sehat"));
        startActivity(webIntent);


    }
}
