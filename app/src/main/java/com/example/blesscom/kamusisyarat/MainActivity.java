package com.example.blesscom.kamusisyarat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton bt1 = (ImageButton)findViewById(R.id.bt1);
        ImageButton bt2 = (ImageButton) findViewById(R.id.bt2);
        ImageButton bt3 = (ImageButton) findViewById(R.id.bt3);
        ImageButton bt4 = (ImageButton) findViewById(R.id.bt4);
        ImageButton bt5 = (ImageButton) findViewById(R.id.bt5);





        bt1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent pindah = new Intent (MainActivity.this,Kamus.class);
                startActivity(pindah);
                // menghubungkan antar activity dengan intent

            }
        });


        bt2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent pindah = new Intent (MainActivity.this,AngkaHuruf.class);
                startActivity(pindah);
                // menghubungkan antar activity dengan intent

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent pindah = new Intent (MainActivity.this,Imbuhan.class);
                startActivity(pindah);
                // menghubungkan antar activity dengan intent

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent pindah = new Intent (MainActivity.this,TunaGrahita.class);
                startActivity(pindah);
                // menghubungkan antar activity dengan intent

            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent pindah = new Intent (MainActivity.this,TentangApk.class);
                startActivity(pindah);
                // menghubungkan antar activity dengan intent

            }
        });

        ImageButton exit = (ImageButton)findViewById(R.id.btexit);

        exit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                moveTaskToBack(true);
            }

        });
    }
}



