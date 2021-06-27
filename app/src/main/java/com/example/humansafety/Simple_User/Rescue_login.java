package com.example.humansafety.Simple_User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.humansafety.R;
import com.example.humansafety.RescuePanel.Rescue_Default;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Rescue_login extends AppCompatActivity {

    FirebaseAuth auth;
    ProgressDialog progressDialog;
    Button Reg_Login,Reg_REG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescue_login);
        Reg_Login=findViewById(R.id.AResReg_btn_Login);
        Reg_REG=findViewById(R.id.AResReg_btn_reg);

        auth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(getApplicationContext());

        Reg_REG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegClick(v);
            }
        });
        Reg_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginClick(v);
            }
        });


    }
    void LoginClick(View v)
    {
        String Adm_email="saqibusman331@gmail.com";
        String Adm_pass="123456";
//        progressDialog.setTitle("Logging In");
//        progressDialog.setMessage("Wait");
//        progressDialog.show();
//        progressDialog.setCanceledOnTouchOutside(false);

        auth.signInWithEmailAndPassword(Adm_email,Adm_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Rescue_login.this, "okkkkkk", Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
                    startActivity(new Intent(getApplicationContext(), Rescue_Default.class));
                    finish();

                }
                else
                {
                    Toast.makeText(Rescue_login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
                }
            }
        });


    }

    void RegClick(View v)
    {
        startActivity(new Intent(getApplicationContext(),Login.class));
    }
}