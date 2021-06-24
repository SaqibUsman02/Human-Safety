package com.example.humansafety.Simple_User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.humansafety.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Feedback extends AppCompatActivity {
    EditText edt_name,edt_comment;

    Button btn_Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        edt_name=findViewById(R.id.AF_ET_Name);
        edt_comment=findViewById(R.id.AF_ET_Detail);
        btn_Submit= findViewById(R.id.AF_btn_Submit);

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_name=edt_name.getText().toString();
                String get_comment=edt_comment.getText().toString();

                HashMap<String, Object> data = new HashMap<>();
                data.put("Name: ",get_name);
                data.put("Detail: ",get_comment);

                if(get_name.isEmpty() || get_comment.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Empty DATA", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    FirebaseDatabase.getInstance().getReference().child("Feedback").push().child("Feedback Record").setValue(data);

                }
            }
        });
    }
}