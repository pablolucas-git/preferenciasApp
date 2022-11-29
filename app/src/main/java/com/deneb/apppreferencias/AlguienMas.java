package com.deneb.apppreferencias;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AlguienMas extends AppCompatActivity {
    private Button btn_otra;
    private Button btn_ninguna;
    private static final String EXTRA_OTRA = "com.deneb.apppreferencias.otra";


   private void otraRonda(boolean otra){
       Intent data = new Intent();
       data.putExtra(EXTRA_OTRA, otra);
       setResult(RESULT_OK, data);
   }

    public static boolean getOtra(Intent result){
        return result.getBooleanExtra(EXTRA_OTRA, false);
    }

   @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.otrapersona);

       btn_ninguna = (Button) findViewById(R.id.btn_ninguna);
       btn_otra = (Button) findViewById(R.id.btn_otra);


       btn_otra.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               otraRonda(true);
               finish();
           }
       });
       btn_ninguna.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               otraRonda(false);
               finish();
           }
       });
   }

}
