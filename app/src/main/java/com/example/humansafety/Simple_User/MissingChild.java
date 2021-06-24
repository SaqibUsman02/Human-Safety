package com.example.humansafety.Simple_User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.humansafety.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MissingChild extends AppCompatActivity {

    EditText txt_name,txt_age,txt_Father,txt_address,txt_contact,txt_identification,txt_gender,txt_missing;
    Button btn_submit;



    Spinner spinner;
    List<String> GenderList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_child);

        spinner=findViewById(R.id.AMC_Spinner_Gender);
        txt_name=findViewById(R.id.AMC_ET_Name);
        txt_age=findViewById(R.id.AMC_ET_Age);
        txt_Father=findViewById(R.id.AMC_ET_FatherName);
        txt_address=findViewById(R.id.AMC_ET_Address);
        txt_contact=findViewById(R.id.AMC_ET_Contact);
        txt_identification=findViewById(R.id.AMC_ET_IdentificationMark);
        txt_missing=findViewById(R.id.AMC_ET_MissingSince);
        btn_submit=findViewById(R.id.AMC_BTN_Submit);



        GenderList.add("Male");
        GenderList.add("Female");
        GenderList.add("Other");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,GenderList);
        spinner.setAdapter(arrayAdapter);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_name=txt_name.getText().toString();
                String get_age=txt_age.getText().toString();
                String get_father=txt_Father.getText().toString();                String get_address=txt_address.getText().toString();
                String get_contact=txt_contact.getText().toString();
                String get_identification=txt_identification.getText().toString();
                String get_missing=txt_missing.getText().toString();

                HashMap<String,Object> map = new HashMap<>();
                map.put("Name: " ,get_name);
                map.put("Age: " ,get_age);
                map.put("Address: " ,get_address);
                map.put("Father: " ,get_father);
                map.put("Contact: " ,get_contact);
                map.put("Identification Mark: " ,get_identification);
                map.put("Missing Since: " ,get_missing);

                FirebaseDatabase.getInstance().getReference().child("Missing Child").setValue(map);
            }
        });
    }
}