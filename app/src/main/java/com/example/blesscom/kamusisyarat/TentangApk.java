package com.example.blesscom.kamusisyarat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Blesscom on 3/7/2017.
 */
public class TentangApk  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentangapk);


        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(TentangApk.this,MainActivity.class));			// inten kembali
                finish();
            }
        });
    }





}
