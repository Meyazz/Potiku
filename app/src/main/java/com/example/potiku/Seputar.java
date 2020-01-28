package com.example.potiku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Seputar extends AppCompatActivity {

    private TextView satu, dua, tiga, empat, lima, enam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seputar);

        satu = (TextView) findViewById(R.id.txt1);
        dua = (TextView) findViewById(R.id.txt2);
        tiga = (TextView) findViewById(R.id.txt3);
        empat = (TextView) findViewById(R.id.txt4);
        lima = (TextView) findViewById(R.id.txt5);
        enam = (TextView) findViewById(R.id.txt6);

        satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Seputar.this, Artikel1.class);
                startActivity(intent);
            }
        });

        dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Seputar.this, Artikel2.class);
                startActivity(intent);
            }
        });

        tiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Seputar.this, Artikel3.class);
                startActivity(intent);
            }
        });

        empat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Seputar.this, Artikel4.class);
                startActivity(intent);
            }
        });

        lima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Seputar.this, Artikel5.class);
                startActivity(intent);
            }
        });

        enam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Seputar.this, Artikel6.class);
                startActivity(intent);
            }
        });
    }

//    public void artikel1(View view) {
//        Intent intent = new Intent(this, Artikel1.class);
//        startActivity(intent);
//    }
//
//    public void artikel2(View view) {
//        Intent intent = new Intent(this, Artikel2.class);
//        startActivity(intent);
//    }
//
//    public void artikel3(View view) {
//        Intent intent = new Intent(this, Artikel3.class);
//        startActivity(intent);
//    }
//
//    public void artikel4(View view) {
//        Intent intent = new Intent(this, Artikel4.class);
//        startActivity(intent);
//    }
//
//    public void artikel5(View view) {
//        Intent intent = new Intent(this, Artikel5.class);
//        startActivity(intent);
//    }
//
//    public void artikel6(View view) {
//        Intent intent = new Intent(this, Artikel6.class);
//        startActivity(intent);
//    }
}



