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
import com.example.humansafety.Simple_User.Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;

    EditText text_email,text_pass;
    Button btn_login,btn_Reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();
        text_email=findViewById(R.id.AR_edt_email);
        text_pass=findViewById(R.id.AR_edt_Pass);
        btn_login=findViewById(R.id.AR_btn_Login);
        btn_Reg=findViewById(R.id.AR_btn_Reg);
        progressDialog=new ProgressDialog(this);



//        btn_register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                User_Registration();
//
//            }
//        });
//
//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//               startActivity(new Intent(getApplicationContext(),Login.class));
//            }
//        });

        btn_Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_Email=text_email.getText().toString();
                String get_pass=text_pass.getText().toString();
                progressDialog.setTitle("Creating Account");
                progressDialog.setMessage("Wait,");
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(false);

                mAuth.createUserWithEmailAndPassword(get_Email,get_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Sign in", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                           progressDialog.dismiss();
                        }
                    }
                });
            }

        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });





//    public void User_Registration()
//    {


//       pd.setTitle("Creating account");
//       pd.setMessage("Please Wait, we are checking ");
//       pd.show();
//   pd.setCanceledOnTouchOutside(false);

//        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful())
//                {
//                    Toast.makeText(getApplicationContext(),"User Added",Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
//                }
//            }
//        });



}
}