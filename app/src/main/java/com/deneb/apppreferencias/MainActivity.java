package com.deneb.apppreferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_si;
    private Button btn_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_si = (Button) findViewById(R.id.btn_si);
        btn_no = (Button) findViewById(R.id.btn_no);

        btn_si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.alla_vamos,
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, Preferencias.class);
                startActivity(i);
            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.como_quieras,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}