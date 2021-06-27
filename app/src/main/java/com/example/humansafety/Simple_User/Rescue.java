package com.example.humansafety.Simple_User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
import com.example.humansafety.RescuePanel.Highway_Notify;
import com.example.humansafety.RescuePanel.Motoway_Notify;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Rescue extends AppCompatActivity {

    Button Btn_1122,Btn_Motorway,Btn_15,Btn_pcsw;
    private static final int CAll_PERMISSION_CODE = 100;
    FirebaseAuth auth;
    DatabaseReference databaseReference;
    CardView Rescue1122,pcsw,mthigh,ranger,alert15,fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescue);
        Rescue1122=findViewById(R.id.Rescue_1122);
        pcsw=findViewById(R.id.Rescue_PCSW);
        mthigh=findViewById(R.id.Rescue_Alert15);
        ranger=findViewById(R.id.Rescue_MtHigh);
        alert15=findViewById(R.id.Rescue_Rangers);
        fire=findViewById(R.id.Rescue_Fire);
        auth=FirebaseAuth.getInstance();
        String uid=auth.getCurrentUser().getUid();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("Call Record");

        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=16;
                String text="Fire Brigade";

                checkPermission(Manifest.permission.CALL_PHONE, CAll_PERMISSION_CODE,number,v,text,uid);


            }
        });

        ranger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=042-99220030;
                String text="Rangers";

                checkPermission(Manifest.permission.CALL_PHONE, CAll_PERMISSION_CODE,number,v,text,uid);

            }
        });

        Rescue1122.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int number=1122;
                String text="Rescue1122";

                checkPermission(Manifest.permission.CALL_PHONE, CAll_PERMISSION_CODE,number,v,text,uid);
            }
        });




        alert15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=15;
                String text="15";
                checkPermission(Manifest.permission.CALL_PHONE, CAll_PERMISSION_CODE,number,v,text,uid);
            }
        });
        mthigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=130;
                String text="Motorway";

                checkPermission(Manifest.permission.CALL_PHONE, CAll_PERMISSION_CODE,number,v,text,uid);
            }
        });

        pcsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=1043;;
                String text="PCSW";
                checkPermission(Manifest.permission.CALL_PHONE, CAll_PERMISSION_CODE,number,v,text,uid);
            }
        });

    }
    public void DialNumber(int number,String text,String u)
    {

        String phoneNumber ="tel:"+number;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(phoneNumber));
        startActivity(intent);
        HashMap<String, Object> map= new HashMap<>();
        map.put("Number",phoneNumber);
        map.put("User",u);
        databaseReference.child(text).child(auth.getCurrentUser().getUid()).setValue(map);
//        FirebaseDatabase.getInstance().getReference().child("Call Record").push().child(text).setValue(map);

    }

    //Check Permission Granted or not and take permission from user.
    public void checkPermission(String permission, int requestCode,int number,View view,String text,String u)
    {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), permission) == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(Rescue.this, new String[] { permission }, requestCode);
        }
        else {
            DialNumber(number,text,u);

        }

    }
}