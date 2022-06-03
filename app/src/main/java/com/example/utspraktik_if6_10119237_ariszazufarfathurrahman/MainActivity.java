package com.example.utspraktik_if6_10119237_ariszazufarfathurrahman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
Developed by AriszaZufarFathurrahman
10119237
IF6
*/

public class MainActivity extends AppCompatActivity {

    private Button button1, button2;
    private TextView textView1, textView2, tglKonfirmasi;
    RadioGroup jenis_kelamin , radio_jenis;
    private String jk,relasi2,jenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.but_tgl);
        button2 = findViewById(R.id.tgl_pcr_konfirmasi);
        textView1 = findViewById(R.id.text_tanggal);
        textView2 = findViewById(R.id.text_tanggal_konfirmasi);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TampilTanggal1();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TampilTanggal2();
            }
        });

        RadioGroup jenisKelamin,relasi,radiojenis;

        radiojenis = findViewById(R.id.radiojenis);
        jenisKelamin = findViewById(R.id.radgender);

        radiojenis.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rapid:
                        jenis = "Rapid Antigen";
                        break;
                    case R.id.pcr:
                        jenis = "Pcr";
                }
            }
        });
        jenisKelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_male:
                        jk = "Laki - Laki";
                        break;
                    case R.id.rb_female:
                        jk = "Perempuan";
                }
            }
        });

        relasi = findViewById(R.id.radrelasi);

        relasi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.ortu:
                        relasi2 = "Orang tua";
                        break;
                    case R.id.suamiistri:
                        relasi2 = "Suami Istri";
                        break;
                    case R.id.anak:
                        relasi2 = "Anak";
                        break;
                    case R.id.kerabat:
                        relasi2 = "Kerabat";
                }
            }
        });

    }
    public  void pindahhalaman (View view){
        Intent intent = new Intent(this,CekKembaliActivity.class);
        EditText editText = (EditText) findViewById(R.id.text_NIK);
        EditText editText2 = (EditText) findViewById(R.id.text_nama);
        EditText editText3 = (EditText) findViewById(R.id.text_tanggal);
//        EditText editText6 = (EditText) findViewById(R.id.text_jenistes);


        String message = editText.getText().toString();
        String message2 = editText2.getText().toString();
        String message3 = editText3.getText().toString();
//        String message6 = editText6.getText().toString();

        intent.putExtra("nik", message);
        intent.putExtra("nama", message2);
        intent.putExtra("tanggal", message3);
        intent.putExtra("jk", jk);
        intent.putExtra("relasi", relasi2);
//        intent.putExtra("jenis", message6);
        startActivity(intent);
    }
    public void TampilTanggal1(){
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "data");
        datePickerFragment.setOnDateClickListener(new DatePickerFragment.onDateClickListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String tahun = ""+datePicker.getYear();
                String bulan = ""+(datePicker.getMonth()+1);
                String hari = ""+datePicker.getDayOfMonth();
                String text = hari+" - "+bulan+" - "+tahun;
                textView1.setText(text);
            }
        });
    }
    public void TampilTanggal2(){
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "data");
        datePickerFragment.setOnDateClickListener(new DatePickerFragment.onDateClickListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String tahun = ""+datePicker.getYear();
                String bulan = ""+(datePicker.getMonth()+1);
                String hari = ""+datePicker.getDayOfMonth();
                String text = hari+" - "+bulan+" - "+tahun;
                textView2.setText(text);
            }
        });
    }
}