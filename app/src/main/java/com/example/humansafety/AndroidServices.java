package com.example.humansafety;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.humansafety.Simple_User.Alert;
import com.example.humansafety.Simple_User.Default;

public class AndroidServices extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        startActivity(new Intent(this, Messages.class));

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }
}


