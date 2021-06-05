package com.fathsbs.utspraktik_akb1_10118039_fatahillahsatriabimaseno;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PreviewDataActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_data);

        //ambil data yang dilempar
        Intent intent = getIntent();
        String NIK = intent.getStringExtra("NIK");
        String NAMA = intent.getStringExtra("NAMA");
        String Ttl = intent.getStringExtra("TTL");
        String Jk = intent.getStringExtra("JK");
        String hub = intent.getStringExtra("Hubungan");

        TextView Nama,Nik,TTl,jk,hubun;
        jk = findViewById(R.id.isiJK);
        TTl = findViewById(R.id.isiTTL);
        Nik = findViewById(R.id.isiNIK);
        Nama = findViewById(R.id.isiNama);
        hubun = findViewById(R.id.isiHubungan);

        Nik.setText(NIK);
        Nama.setText(NAMA);
        TTl.setText(Ttl);
        jk.setText(Jk);
        hubun.setText(hub);

        Button kembali;
        kembali = findViewById(R.id.buttonUbah);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pindahHalamanKembali(v);
            }
        });

    }

    public void pindahHalamanKembali(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
