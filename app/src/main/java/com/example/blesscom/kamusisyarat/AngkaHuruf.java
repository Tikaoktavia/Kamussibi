package com.example.blesscom.kamusisyarat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;


public class AngkaHuruf extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angkahuruf);

        ImageButton btangka = (ImageButton) findViewById(R.id.btawal);
        ImageButton bthuruf = (ImageButton) findViewById(R.id.btakhir);

        btangka.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent pindah = new Intent (AngkaHuruf.this,SubAngka.class);
                startActivity(pindah);
                //menghubungkan antar activity dengan intent
            }
        });

        bthuruf.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent pindah = new Intent (AngkaHuruf.this,SubHuruf.class);
                startActivity(pindah);
                // menghubungkan antar activity dengan intent

            }
        });
    }

}
