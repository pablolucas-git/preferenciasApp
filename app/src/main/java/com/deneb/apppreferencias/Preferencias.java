package com.deneb.apppreferencias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Preferencias extends AppCompatActivity {
    private Button btn_mirar;
    private Button btn_opcion1;
    private Button btn_opcion2;
    private TextView tv_enunciado;
    private ImageView iv_imagen;
    private int usuario = 0;
    private int respuestas[][];
    private int num_pregunta = 0;
    private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    private static final int REQUEST_CODE_OTRA = 0;
    private boolean otra;


    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if(requestCode == REQUEST_CODE_OTRA){
            if(data == null){
                return;
            }
            otra = AlguienMas.getOtra(data);
        }
        if (otra) {
            usuario++;
            num_pregunta = 0;
            cambiarPregunta();
        }
    }



    private void responder(int respuesta){
        respuestas[usuario][num_pregunta] = respuesta;
        if(usuario == 0){
            Toast.makeText(Preferencias.this, R.string.respuesta_almacenada,
                    Toast.LENGTH_SHORT).show();
        }
        else{
            if(respuesta == respuestas[usuario - 1][num_pregunta]){
                Toast.makeText(Preferencias.this, R.string.piensas_igual,
                        Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Preferencias.this, R.string.piensas_distinto,
                        Toast.LENGTH_SHORT).show();
            }
        }
        num_pregunta++;
        iv_imagen.setEnabled(true);
        btn_opcion2.setEnabled(false);
        btn_opcion1.setEnabled(false);
    }

    private void cambiarPregunta(){
        btn_opcion1.setText(preguntas.get(num_pregunta).getBtn_opcion1());
        btn_opcion2.setText(preguntas.get(num_pregunta).getBtn_opcion2());
        iv_imagen.setImageResource(preguntas.get(num_pregunta).getIv_imagen());
        tv_enunciado.setText(preguntas.get(num_pregunta).getTv_enunciado());
        btn_opcion1.setEnabled(true);
        btn_opcion2.setEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferencias);

        btn_mirar = (Button) findViewById(R.id.btn_mirar);
        btn_opcion1 = (Button) findViewById(R.id.btn_opcion1);
        btn_opcion2 = (Button) findViewById(R.id.btn_opcion2);
        iv_imagen = (ImageView) findViewById(R.id.pregImagen);
        tv_enunciado = (TextView) findViewById(R.id.tv_pregunta);

        Pregunta p1 = new Pregunta(R.string.p1_enunciado, R.string.p1_op1, R.string.p1_op2, R.drawable.p1);
        Pregunta p2 = new Pregunta(R.string.p2_enunciado, R.string.p2_op1, R.string.p2_op2, R.drawable.p2);
        Pregunta p3 = new Pregunta(R.string.p3_enunciado, R.string.p3_op1, R.string.p3_op2, R.drawable.p3);

        preguntas.add(p1);
        preguntas.add(p2);
        preguntas.add(p3);

        respuestas = new int[9999][preguntas.size()];
        iv_imagen.setEnabled(false);

        cambiarPregunta();

        btn_opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                responder(1);
            }
        });

        btn_opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                responder(2);
            }
        });

        iv_imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_imagen.setEnabled(false);
                if(num_pregunta >= preguntas.size()){
                    Intent i = new Intent(Preferencias.this, AlguienMas.class);
                    startActivityForResult(i, REQUEST_CODE_OTRA);
                }
                else{
                    cambiarPregunta();
                }

            }
        });


    }
}
