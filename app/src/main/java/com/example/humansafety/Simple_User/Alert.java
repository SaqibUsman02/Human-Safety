package com.example.humansafety.Simple_User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.humansafety.AndroidServices;
import com.example.humansafety.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static android.view.KeyEvent.KEYCODE_VOLUME_DOWN;
import static android.view.KeyEvent.KEYCODE_VOLUME_UP;

public class Alert extends AppCompatActivity {
    Spinner spinner;
    List<String> spinnerList = new ArrayList<>();
    EditText contact, message, location;
    Button btn_Save, btn_SendAlert;
    FirebaseAuth auth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String msg;
    String num;
    String Save_Spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        spinner = findViewById(R.id.AA_Spinner_AlertType);
        contact = findViewById(R.id.AA_TIET_contact);
        message = findViewById(R.id.AA_TIET_message);
        location = findViewById(R.id.AA_TIET_location);
        btn_Save = findViewById(R.id.AA_btn_save);
        btn_SendAlert = findViewById(R.id.AA_btn_Alert);


        spinnerList.add("Emergency");
        spinnerList.add("Accident");
        spinnerList.add("Disaster");
        spinnerList.add("Theft");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, spinnerList);
        spinner.setAdapter(arrayAdapter);


        auth = FirebaseAuth.getInstance();
        String uid = auth.getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Alert");


        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference().child("Alert").child(uid).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {

                    Map<String, Object> map = (Map<String, Object>) task.getResult().getValue();
                    String num = map.get("Contact").toString();
                    String Locate = map.get("Location").toString();
                    String msg = map.get("Message").toString();
                    String s=map.get("Alert Type").toString();
                    contact.setText("" + num);
                    location.setText("" + Locate);
                    message.setText("" + msg);

                }
            }
        });



        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save_Spinner=spinner.getSelectedItem().toString();

                String get_Contact = contact.getText().toString();
                String get_Message = message.getText().toString();
                String get_Location = location.getText().toString();
                HashMap<String, Object> map = new HashMap<>();
                map.put("Contact", get_Contact);
                map.put("Message", get_Message);
                map.put("Location", get_Location);
                map.put("Alert Type",Save_Spinner);

                if (get_Contact.isEmpty() || get_Location.isEmpty() || get_Message.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Empty DATA", Toast.LENGTH_SHORT).show();
                } else {
                    databaseReference.child(auth.getCurrentUser().getUid()).setValue(map);

                }

                startService(new Intent(getApplicationContext(), AndroidServices.class));

            }
        });

        btn_SendAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(getApplicationContext(), "Uppppppppppp", Toast.LENGTH_SHORT).show();
                SendMessage();
            } else {
                ActivityCompat.requestPermissions(Alert.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_PHONE_STATE}, 100);
            }

            }
        });


    }


//    //it will check any key press in android phone
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//
//        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
//            event.startTracking();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    @Override
//    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
//            Toast.makeText(this, "execute", Toast.LENGTH_SHORT).show();
//
//            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
//
//                Toast.makeText(this, "Uppppppppppp", Toast.LENGTH_SHORT).show();
//                SendMessage();
//            } else {
//                ActivityCompat.requestPermissions(Alert.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_PHONE_STATE}, 100);
//            }
//
//        }
//        return super.onKeyLongPress(keyCode, event);
//
//    }
//
////    //it will execute when key is released
////    @Override
////    public boolean onKeyUp(int keyCode, KeyEvent event) {
////        if(keyCode== KeyEvent.KEYCODE_VOLUME_UP) {
////            end=System.currentTimeMillis() - save1;
////            res=end/1000;
//            int s=(int)res;
//            Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
//            if(s>=45) {
//                Toast.makeText(this, "kkkkkkkk"+res, Toast.LENGTH_SHORT).show();
//            }00002

//            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
//
//                Toast.makeText(this, "Uppppppppppp", Toast.LENGTH_SHORT).show();
//                SendMessage();
//            } else {
//                ActivityCompat.requestPermissions(Alert.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_PHONE_STATE}, 100);
////            }
//        }
//        return super.onKeyUp(keyCode, event);
//    }

        public void SendMessage () {

            num = contact.getText().toString();
            msg = message.getText().toString();

            if (num != null && msg != null) {
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(num, null, msg, null, null);
                    Toast.makeText(this, "Send Successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("ExBySMS", e.toString());
                }
            } else {
                Toast.makeText(this, "Not Send", Toast.LENGTH_SHORT).show();

            }
        }


    }
