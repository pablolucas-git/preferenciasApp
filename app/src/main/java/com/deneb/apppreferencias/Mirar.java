package com.deneb.apppreferencias;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Mirar extends AppCompatActivity {

    private Button btn_hazlo;
    private TextView tv_respuesta;
    private ImageView iv_mirar;


    public static Intent newIntent(Context packageContext, int resultado, int pregunta, int imagen){

        Intent i = new Intent(packageContext, Mirar.class);
        i.putExtra(EXTRA_RESPUESTA, resultado);
        i.putExtra(EXTRA_PREGUNTA, pregunta);
        i.putExtra(EXTRA_IMAGEN, imagen);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mirar);

        btn_hazlo = (Button) findViewById(R.id.btn_hazlo);



    }
}
