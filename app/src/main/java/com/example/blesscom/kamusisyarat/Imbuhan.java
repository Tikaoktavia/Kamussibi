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

/**
 * Created by Blesscom on 3/7/2017.
 */
public class Imbuhan extends  AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imbuhan);


        ImageButton btawal = (ImageButton) findViewById(R.id.btawal);
        ImageButton btakhir = (ImageButton) findViewById(R.id.btakhir);
        ImageButton  btpartikel=(ImageButton)findViewById(R.id.btpartikel);


        btawal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent pindah = new Intent(Imbuhan.this, Awal.class);
                startActivity(pindah);
                // menghubungkan antar activity dengan intent
            }
        });

        btakhir.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent pindah = new Intent(Imbuhan.this, Akhir.class);
                startActivity(pindah);
                // menghubungkan antar activity dengan intent

            }
        });

        btpartikel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent pindah = new Intent(Imbuhan.this, Partikel.class);
                startActivity(pindah);
                // menghubungkan antar activity dengan intent

            }
        });
    }
}
