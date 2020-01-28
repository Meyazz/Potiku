package com.example.potiku;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Artikel2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel2);
    }

    public void openWeb(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        // Parse the location and create the intent.

        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse("https://www.fimela.com/lifestyle-relationship/read/4035582/4-tanda-pola-dietmu-berdampak-buruk-bagi-kesehatanmu"));
        startActivity(webIntent);
    }
}
