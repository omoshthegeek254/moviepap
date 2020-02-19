package com.example.movie101.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.movie101.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText mUserName,mEmail,mConfirmEmail,mPassword,mConfirmPassword;
    Button  mRegisterBtn;
    ProgressBar progressBarReg;
    FirebaseAuth fbAuth;
    FirebaseDatabase fbDb= FirebaseDatabase.getInstance();

    DatabaseReference fbDbRef = fbDb.getReference("users") ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //seting link  for th xml resource file
        mUserName = findViewById(R.id.mUserName);
        mEmail= findViewById(R.id.mEmail);
//        mConfirmEmail=findViewById(R.id.mConfirmEmail);
        mPassword=findViewById(R.id.mPassword);
//        mConfirmPassword= findViewById(R.id.mConfirmPassword);
        mRegisterBtn =findViewById(R.id.mRegisterBtn);
        progressBarReg =findViewById(R.id.progressBarReg);
        fbAuth = FirebaseAuth.getInstance();

        if(fbAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        //set click listner on the register button
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUserName.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
//                String emailCon =mConfirmEmail.getText().toString().trim();
                String passWord = mPassword.getText().toString().trim();
//                String passWordCon = mConfirmPassword.getText().toString().trim();

                //validating user inputs

                if(TextUtils.isEmpty(username) ){
                    mUserName.setError("Username Field id Required");
                    return;
                }

                if(TextUtils.isEmpty(email) ){
                    mEmail.setError("Email Field id Required");
                    return;
                }

//                if(TextUtils.isEmpty(emailCon) ){
//                    mUserName.setError("Email Confirmation Field id Required");
//                    return;
//                }

                if(TextUtils.isEmpty(passWord )){
                    mPassword.setError("Password Field id Required");
                    return;
                }

//                if(TextUtils.isEmpty(passWordCon) ){
//                    mConfirmPassword.setError("PassWor Field id Required");
//                    return;
//                }
//                if(TextUtils.equals(email,emailCon) ){
//                    mEmail.setError("Emails Don't match ,Try Again");
//                    mConfirmEmail.setError("Emails Don't match ,Try Again");
//                    return;
//                }

//                if(TextUtils.equals(passWord,passWordCon) ){
//                    mConfirmPassword.setError("Passwords Don't match ,Try Again");
//                    mPassword.setError("PassWords Don't match ,Try Again");
//                    return;
//                }

                //setting progressbar visibility
                progressBarReg.setVisibility(View.VISIBLE);

                //registering user
                fbAuth.createUserWithEmailAndPassword(email,passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this,"User Created Successfully",Toast.LENGTH_SHORT).show();
                            //add data to db
                            fbDbRef.setValue("hellow there");






                            startActivity(new Intent((getApplicationContext()),MainActivity.class));
                        }else {
                            Toast.makeText(Register.this,"Error !!!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });



    }

    public void regLogin(View view) {
        startActivity(new Intent(getApplicationContext(),Login.class));
    }
}
