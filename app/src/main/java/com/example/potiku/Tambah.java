package com.example.potiku;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Tambah extends AppCompatActivity {

    EditText edtid, edtnama, edtfungsi, edtharga;

    Spinner spjenis;

    Button tambah;

    RequestQueue requestQueue;

    String txtid, txtnama, txtjenis, txtfungsi, txtharga;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        edtid = (EditText) findViewById(R.id.id);
        edtnama = (EditText) findViewById(R.id.nama);
        edtfungsi = (EditText) findViewById(R.id.fungsi);
        edtharga = (EditText) findViewById(R.id.harga);

        spjenis = (Spinner) findViewById(R.id.spinner_jenis);

        tambah = (Button) findViewById(R.id.tambah);

        requestQueue = Volley.newRequestQueue(Tambah.this);

        progressDialog = new ProgressDialog(Tambah.this);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.setMessage("Please Wait, We are Inserting Your Data");
                progressDialog.show();

                GetValue();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, konfigurasi.URL_TAMBAH,
                        new Response.Listener<String>() {

                            @Override
                            public void onResponse(String ServerResponse) {

                                progressDialog.dismiss();
                                Toast.makeText(Tambah.this, ServerResponse, Toast.LENGTH_LONG).show();
                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(Tambah.this, volleyError.toString(), Toast.LENGTH_LONG).show();

                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("id", txtid);
                        params.put("nama_obat", txtnama);
                        params.put("jenis", txtjenis);
                        params.put("fungsi", txtfungsi);
                        params.put("harga", txtharga);

                        return params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(Tambah.this);

                requestQueue.add(stringRequest);

            }

        });

    }

    public void GetValue() {

        txtid = edtid.getText().toString();
        txtnama = edtnama.getText().toString();
        txtjenis = spjenis.getSelectedItem().toString();
        txtfungsi = edtfungsi.getText().toString();
        txtharga = edtharga.getText().toString();

    }
}
