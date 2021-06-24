package com.example.humansafety.Simple_User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.humansafety.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Rescue extends AppCompatActivity {

    Button Btn_1122,Btn_Highway,Btn_Motorway,Btn_15,Btn_pcsw;
    private static final int CAll_PERMISSION_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescue);

        Btn_1122=findViewById(R.id.AR_Btn_Rescue);
        Btn_15=findViewById(R.id.AR_Btn_15);
        Btn_Highway=findViewById(R.id.AR_Btn_Highway);
        Btn_Motorway=findViewById(R.id.AR_Btn_motorway);
        Btn_pcsw=findViewById(R.id.AR_Btn_Pcsw);
        Btn_1122.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=1122;
                checkPermission(Manifest.permission.CALL_PHONE, CAll_PERMISSION_CODE,number,v);
            }

        });


        Btn_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=15;
                checkPermission(Manifest.permission.CALL_PHONE, CAll_PERMISSION_CODE,number,v);
            }
        });
        Btn_Motorway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=130;
                checkPermission(Manifest.permission.CALL_PHONE, CAll_PERMISSION_CODE,number,v);
            }
        });
        Btn_Highway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=1124;
                checkPermission(Manifest.permission.CALL_PHONE, CAll_PERMISSION_CODE,number,v);
            }
        });
        Btn_pcsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=1043;
                checkPermission(Manifest.permission.CALL_PHONE, CAll_PERMISSION_CODE,number,v);
            }
        });

    }
    public void DialNumber(int number)
    {

        String phoneNumber ="tel:"+number;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(phoneNumber));
        startActivity(intent);
        HashMap<String, Object> map= new HashMap<>();
        map.put("Number",phoneNumber);
        FirebaseDatabase.getInstance().getReference().child("Call Record").push().child("Rescue").setValue(map);

    }

    //Check Permission Granted or not and take permission from user.
    public void checkPermission(String permission, int requestCode,int number,View view)
    {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), permission) == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(Rescue.this, new String[] { permission }, requestCode);
        }
        else {
            DialNumber(number);

        }

    }
}