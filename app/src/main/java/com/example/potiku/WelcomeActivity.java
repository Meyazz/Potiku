package com.example.potiku;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }

    public void Tambah(View view) {
        Intent intent = new Intent(this, Tambah.class);
        startActivity(intent);
    }

    public void koleksiObat(View view) {
        Intent intent = new Intent(this, Koleksi.class);
        startActivity(intent);
    }

    public void BeliObat(View view) {
        Intent intent = new Intent(this, Seputar.class);
        startActivity(intent);
    }
}
