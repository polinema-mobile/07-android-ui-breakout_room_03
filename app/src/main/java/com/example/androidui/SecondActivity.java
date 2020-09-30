package com.example.androidui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_detail);

        Bundle b = getIntent().getExtras();

        TextView nama = (TextView) findViewById(R.id.edtNama);
        TextView nim = (TextView) findViewById(R.id.edtNim);
        TextView tglLahir = (TextView) findViewById(R.id.edtTglLahir);
        TextView jeniskelamin = (TextView) findViewById(R.id.edtJenisKelamin);
        TextView jurusan = (TextView) findViewById(R.id.edtJurusan);

        nama.setText(b.getCharSequence("Nama"));
        nim.setText(b.getCharSequence("Nim"));
        tglLahir.setText(b.getCharSequence("Tanggal Lahir"));
        jeniskelamin.setText(b.getCharSequence("Jenis Kelamin"));
        jurusan.setText(b.getCharSequence("Jurusan"));
    }
}