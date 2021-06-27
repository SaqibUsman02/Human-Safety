package com.example.humansafety.RescuePanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.humansafety.R;

public class Rescue_Default extends AppCompatActivity {

    Button btn_Motorway,btn_Highway,btn_15,btn_pcsw,btn_1122;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescue__default);
        btn_Motorway=findViewById(R.id.RAd_btn_motorway);
        btn_15=findViewById(R.id.RAd_btn_15);
        btn_Highway=findViewById(R.id.RAd_btn_highway);
        btn_pcsw=findViewById(R.id.RAd_btn_pcsw);
        btn_1122=findViewById(R.id.RAd_btn_Rescue);

        btn_Motorway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Motoway_Notify.class));

            }
        });
        btn_pcsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PCSW_Notify.class));

            }
        });
        btn_1122.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Rescue_Notify.class));

            }
        });
        btn_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Alert_15_Notify.class));

            }
        });
        btn_Highway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Highway_Notify.class));

            }
        });
    }
}