package com.example.humansafety.Simple_User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.humansafety.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Alert extends AppCompatActivity {
    Spinner spinner;
    List<String> spinnerList=new ArrayList<>();
    EditText contact,message,location;
    Button btn_Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        spinner=findViewById(R.id.AA_Spinner_AlertType);
        contact=findViewById(R.id.AA_ET_Contact);
        message=findViewById(R.id.AA_ET_Message);
        location=findViewById(R.id.AA_ET_Location);
        btn_Submit=findViewById(R.id.AA_btn_Submit);
        spinnerList.add("Emergency");
        spinnerList.add("Accident");
        spinnerList.add("Disaster");
        spinnerList.add("Theft");
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,spinnerList);
        spinner.setAdapter(arrayAdapter);

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String get_Contact = contact.getText().toString();
                String get_Message = message.getText().toString();
                String get_Location = location.getText().toString();
                HashMap<String, Object> map= new HashMap<>();
                map.put("Contact",get_Contact);
                map.put("Message",get_Message);
                map.put("Location",get_Location);

                if(get_Contact.isEmpty() || get_Location.isEmpty() || get_Message.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Empty DATA", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    FirebaseDatabase.getInstance().getReference().child("Alert").push().child("Alert Record").setValue(map);

                }

            }
        });

    }
}