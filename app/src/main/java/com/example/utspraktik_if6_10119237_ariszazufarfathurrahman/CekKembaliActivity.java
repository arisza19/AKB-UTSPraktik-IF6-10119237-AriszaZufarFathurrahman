package com.example.utspraktik_if6_10119237_ariszazufarfathurrahman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CekKembaliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_kembali);


        // get intent
        Intent intent = getIntent();
        String message = intent.getExtras().getString("nik");
        String message2 = intent.getExtras().getString("nama");
        String message3 = intent.getExtras().getString("tanggal");
        String message4 = intent.getExtras().getString("jk");
        String message5 = intent.getExtras().getString("relasi");
        String message6 = intent.getExtras().getString("jenis");
        // capture
        EditText editText = findViewById(R.id.text_NIK);
        editText.setText(message);
        EditText editText2 = findViewById(R.id.text_Nama);
        editText2.setText(message2);
        EditText editText3 = findViewById(R.id.Text_tglLahir);
        editText3.setText(message3);
        EditText editText4 = findViewById(R.id.Text_gender);
        editText4.setText(message4);
        EditText editText5 = findViewById(R.id.Text_relasi);
        editText5.setText(message5);
        EditText editText6 = findViewById(R.id.text_jenistes);
        editText6.setText(message6);


    }
    public void pindahhalaman (View view){
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
    }
    public void back (View view){
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }
}