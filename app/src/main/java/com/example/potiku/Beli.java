package com.example.potiku;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Beli extends AppCompatActivity {

    private EditText edtid, edttgl, edtobat, edtnama, edtjenis, edtfungsi, edtharga, edtitem, btntanggal, edtbayar;

    private Spinner sp_dosis;

    private TextView txttotal, txtkembali, txtket;

    private Button btnhitung, btnbeli;

    private String idtransaksi, tanggal_trans, idobt, namaobat, jenisobat, fungsiobat, hargabarang, item, dosis, bayar, jumlahharga, uang_kembali, keterangan ;

    Calendar c;

    DatePickerDialog datePickerDialog;

    RequestQueue requestQueue;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli);

        edttgl = (EditText) findViewById(R.id.tgl_trans);

        btntanggal = (EditText) findViewById(R.id.tgl_trans);


        btntanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c = Calendar.getInstance();
                int day1 = c.get(Calendar.DAY_OF_MONTH);
                int month1 = c.get(Calendar.MONTH);
                int year1 = c.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(Beli.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        edttgl.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, day1, month1, year1);
                datePickerDialog.show();
            }
        });


                /*datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMont, int mDay) {

                        tanggalpinjam.setText(mDay + "/" + (mMont+1) + "/" + mYear);

                    }
                }, day, month, year);

                datePickerDialog.show();
            }
        });*/

        Intent intent = getIntent();

        idobt = intent.getStringExtra(konfigurasi.EMP_ID);

        edtid = (EditText) findViewById(R.id.idtrans);
        edtobat = (EditText) findViewById(R.id.id);
        edtnama = (EditText) findViewById(R.id.nama);
        edtjenis = (EditText) findViewById(R.id.jenis);
        edtfungsi = (EditText) findViewById(R.id.fungsi);
        edtharga = (EditText) findViewById(R.id.harga);
        edtitem = (EditText) findViewById(R.id.qty);
        edtbayar = (EditText) findViewById(R.id.uang_bayar);

        sp_dosis = (Spinner) findViewById(R.id.spinner_dosis);

        btnhitung = (Button) findViewById(R.id.hitung);
        btnbeli = (Button) findViewById(R.id.beli);

        txttotal = (TextView) findViewById(R.id.jumlah_harga);
        txtkembali = (TextView) findViewById(R.id.uang_kembali);
        txtket = (TextView) findViewById(R.id.keterangan);


        edtobat.setText(idobt);

        requestQueue = Volley.newRequestQueue(Beli.this);

        progressDialog = new ProgressDialog(Beli.this);

        getEmployee();

    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Beli.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_TAMPIL_PERSON, idobt);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String namaobatini = c.getString(konfigurasi.TAG_NAMA_OBAT);
            String jenisobatini = c.getString(konfigurasi.TAG_JENIS);
            String fungsiini = c.getString(konfigurasi.TAG_FUNGSI);
            String hargaini = c.getString(konfigurasi.TAG_HARGA);

            edtnama.setText(namaobatini);
            edtjenis.setText(jenisobatini);
            edtfungsi.setText(fungsiini);
            edtharga.setText(hargaini);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        btnhitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jumlahitem = edtitem.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();
                String bayar = edtbayar.getText().toString().trim();

                double jmlbeli = Double.parseDouble(jumlahitem);
                double hargaa = Double.parseDouble(harga);
                double bayaar = Double.parseDouble(bayar);
                double total = (jmlbeli * hargaa);
                txttotal.setText("Total Belanja : " + total);

                double kembali = (bayaar - total);

                if (bayaar < total){
                    txtket.setText("Keterangan : uang bayar kurang Rp " + (-kembali));
                    txtkembali.setText("Uang Kembali : Rp 0" );
                }else{
                    txtket.setText("Keterangan : Tunggu Kembalian");
                    txtkembali.setText("Uang Kembali : " + kembali);
                }


                //memberikan action pada tombol reset data
            }
        });

        btnbeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.setMessage("Please Wait, We are Inserting Your Data");
                progressDialog.show();

                GetValue();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, konfigurasi.URL_BELI,
                        new Response.Listener<String>() {

                            @Override
                            public void onResponse(String ServerResponse) {

                                progressDialog.dismiss();
                                Toast.makeText(Beli.this, ServerResponse, Toast.LENGTH_LONG).show();
                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(Beli.this, volleyError.toString(), Toast.LENGTH_LONG).show();

                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("id_beli" , idtransaksi);
                        params.put("tgl_beli", tanggal_trans);
                        params.put("id", idobt);
                        params.put("nama_obat", namaobat);
                        params.put("jenis", jenisobat);
                        params.put("fungsi", fungsiobat);
                        params.put("harga", hargabarang);
                        params.put("qty", item);
                        params.put("dosis", dosis);
                        params.put("uang_bayar", bayar);
                        params.put("jumlah_harga", jumlahharga);
                        params.put("uang_kembali", uang_kembali);
                        params.put("keterangan", keterangan);

                        return params;
                    }
                };


                RequestQueue requestQueue = Volley.newRequestQueue(Beli.this);

                requestQueue.add(stringRequest);

            }

        });

    }

    public void GetValue() {

        idtransaksi = edtid.getText().toString();
        tanggal_trans = edttgl.getText().toString();
        idobt = edtobat.getText().toString();
        namaobat = edtnama.getText().toString();
        jenisobat = edtjenis.getText().toString();
        fungsiobat = edtfungsi.getText().toString();
        hargabarang = edtharga.getText().toString();
        item = edtitem.getText().toString();
        dosis = sp_dosis.getSelectedItem().toString();
        bayar = edtbayar.getText().toString();
        jumlahharga = txttotal.getText().toString();
        uang_kembali = txtkembali.getText().toString();
        keterangan = txtket.getText().toString();

    }
}
