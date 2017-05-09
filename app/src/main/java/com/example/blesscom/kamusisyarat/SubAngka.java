package com.example.blesscom.kamusisyarat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * Created by Blesscom on 3/7/2017.
 */
public class SubAngka extends Activity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    Button next;
    Button prev;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angka);

        viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);
        next=(Button) findViewById(R.id.next);
        prev=(Button)findViewById(R.id.prev);

        next.setOnClickListener(this);
        prev.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v==next){
            viewFlipper.showNext();
        }
        else if(v==prev){
            viewFlipper.showPrevious();
        }
    }
}
