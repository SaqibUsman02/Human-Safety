package com.example.humansafety.Simple_User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.humansafety.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;
   EditText txt_email,txt_pass;
   Button btn_login,btn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
       txt_email=findViewById(R.id.AL_edt_email);
       txt_pass=findViewById(R.id.AL_edt_pass);
       btn_login=findViewById(R.id.AL_btn_Login);
       btn_reg=findViewById(R.id.AL_btn_Reg);
        progressDialog=new ProgressDialog(this);

       btn_login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String get_email=txt_email.getText().toString();
               String get_pass=txt_pass.getText().toString();
               progressDialog.setTitle("Loggin in");
               progressDialog.setMessage("Wait,");
               progressDialog.show();
               progressDialog.setCanceledOnTouchOutside(false);
               mAuth.signInWithEmailAndPassword(get_email,get_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful())
                       {
                           Toast.makeText(getApplicationContext(),"login",Toast.LENGTH_SHORT).show();
                           progressDialog.dismiss();
                           startActivity(new Intent(getApplicationContext(), Default.class));
                           finish();

                       }
                       else {
                           Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                           progressDialog.dismiss();
                       }
                   }
               });
           }
       });

       btn_reg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), Registration.class));
           }
       });

//        progressDialog=new ProgressDialog(getApplicationContext());



////        progressDialog.setTitle("Wait");
////        progressDialog.setMessage("Processign your Record");
////        progressDialog.show();
//        mAuth.signInWithEmailAndPassword(emailText,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful())
//                {
//                    //  getFragmentManager().beginTransaction().replace(R.id.FL_FLog,new Default_Fragment()).commit();
//                    Toast.makeText(Login.this, "Signed in", Toast.LENGTH_SHORT).show();
////                    progressDialog.dismiss();
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
////                    progressDialog.dismiss();
//                }
//            }
//        });
    }



    }



