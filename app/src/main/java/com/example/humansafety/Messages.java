package com.example.humansafety;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class Messages extends AppCompatActivity {

    String msg;
    String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
    }

    //it will check any key press in android phone
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {


        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            event.startTracking();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_VOLUME_UP) {
            Toast.makeText(this, "execute", Toast.LENGTH_SHORT).show();

            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "Uppppppppppp", Toast.LENGTH_SHORT).show();
                SendMessage();
            } else {
                ActivityCompat.requestPermissions(Messages.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_PHONE_STATE}, 100);
            }

        }
        return super.onKeyLongPress(keyCode, event);

    }

    public void SendMessage () {

        num = "+923085433194";
        msg = "Helloooo";

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