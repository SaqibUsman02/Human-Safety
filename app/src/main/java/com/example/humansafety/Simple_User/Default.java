package com.example.humansafety.Simple_User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.humansafety.R;

public class Default extends AppCompatActivity {
    Button Alert,MissingChild,Harrasment,Feedback,Rescue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        Alert =findViewById(R.id.AD_BTN_Alert);
        MissingChild =findViewById(R.id.AD_BTN_MissingChild);
        Feedback =findViewById(R.id.AD_BTN_Feedback);
        Rescue =findViewById(R.id.AD_BTN_Rescue);
        Harrasment=findViewById(R.id.AD_BTN_Harrassment);

        Alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertFunction(v);
            }
        });

        MissingChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MissingChildFunction(v);
            }
        });
        Feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedbackFunction(v);
            }
        });
        Rescue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RescueFunction(v);
            }
        });
        Harrasment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HarrasmentFunction(v);
            }
        });

    }
    public void AlertFunction(View view)
    {
startActivity(new Intent(getApplicationContext(), com.example.humansafety.Simple_User.Alert.class));

    }
    public void MissingChildFunction(View view)
    {
        startActivity(new Intent(getApplicationContext(), com.example.humansafety.Simple_User.MissingChild.class));

    }
    public void FeedbackFunction(View view)
    {
        startActivity(new Intent(getApplicationContext(), com.example.humansafety.Simple_User.Feedback.class));
    }
    public void RescueFunction(View view)
    {
        startActivity(new Intent(getApplicationContext(), com.example.humansafety.Simple_User.Rescue.class));
    }
    public void HarrasmentFunction(View view)
    {
        startActivity(new Intent(getApplicationContext(), Harrassment.class));
    }

}