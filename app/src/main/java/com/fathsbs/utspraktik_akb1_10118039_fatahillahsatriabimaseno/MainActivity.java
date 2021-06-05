/*
Tanggal Pengerjaan      : 05 Juni 2021
NIM                     : 10118039
Nama                    : Fatahillah Satria Bima Seno

 */
package com.fathsbs.utspraktik_akb1_10118039_fatahillahsatriabimaseno;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private String jk;
    private String hubungan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pindah;
        pindah = findViewById(R.id.btnPindah);

        EditText TTL;
        TTL = findViewById(R.id.isiTTL);
        TTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pindahHalaman(v);
            }
        });

        RadioGroup hubunganAnda;

        hubunganAnda = findViewById(R.id.hubungan);
        hubunganAnda.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.orangTuaPilih:
                        hubungan = "OrangTua";
                        break;
                    case R.id.suamiIstriPilih:
                        hubungan = "Suami/Istri";
                        break;
                    case R.id.anakPilih:
                        hubungan = "Anak";
                        break;
                    case R.id.kerabatPilih:
                        hubungan = "Kerabat Lainnya";
                        break;
                }
            }
        });

        RadioGroup jenisKelamin;

        jenisKelamin = findViewById(R.id.jk);

        jenisKelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.jkLaki:
                        jk = "Laki - Laki";
                        break;
                    case R.id.jkPerempuan:
                        jk = "Perempuan";
                }
            }
        });
    }

    public void pindahHalaman(View view){
        Intent intent = new Intent(this,PreviewDataActivity.class);
        EditText NIK,NAMA,ttl;
        String NIK2,NAMA2,TTl;


        NAMA = findViewById(R.id.isiNama);
        NAMA2 = NAMA.getText().toString();

        NIK = findViewById(R.id.isiNIK);
        NIK2 = NIK.getText().toString();

        ttl = findViewById(R.id.isiTTL);
        TTl = ttl.getText().toString();



        intent.putExtra("NIK", NIK2);
        intent.putExtra("NAMA", NAMA2);
        intent.putExtra("TTL", TTl);
        intent.putExtra("JK",jk);
        intent.putExtra("Hubungan",hubungan);

        startActivity(intent);


    }

    private void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        EditText TTL;
        TTL = findViewById(R.id.isiTTL);
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                TTL.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
}