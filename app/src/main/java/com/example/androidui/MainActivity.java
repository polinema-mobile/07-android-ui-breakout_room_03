package com.example.androidui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.app.DatePickerDialog;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText tglLahir;
    Spinner jurusan;
    RadioGroup jeniskelamin;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nama = (EditText) findViewById(R.id.edtNama);
        final EditText nim = (EditText) findViewById(R.id.edtNim);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tglLahir = (EditText) findViewById(R.id.edtTglLahir);
        tglLahir.setInputType(InputType.TYPE_NULL);
        tglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        jeniskelamin = (RadioGroup) findViewById(R.id.rdJenisKelamin);
        jeniskelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioLakiLaki:
                        gender  = "Laki-Laki";
                        break;
                    case R.id.radioPerempuan:
                        gender = "Perempuan";
                        break;
                }
            }
        });

        jurusan = (Spinner) findViewById(R.id.spinJurusan);
        jurusan.setOnItemSelectedListener(new ItemSelectedListener());

        Button btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                intent.putExtra("Nama", nama.getText().toString());
                intent.putExtra("Nim", nim.getText().toString());
                intent.putExtra("Tanggal Lahir", tglLahir.getText().toString());
                intent.putExtra("Jenis Kelamin", gender);
                intent.putExtra("Jurusan", jurusan.getSelectedItem().toString());

                startActivity(intent);
            }
        });
    }

    private void showDateDialog(){

        Calendar newCalendar = Calendar.getInstance();


        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tglLahir.setText(dateFormatter.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {

        String firstItem = String.valueOf(jurusan.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            firstItem.equals(String.valueOf(jurusan.getSelectedItem())); {

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}