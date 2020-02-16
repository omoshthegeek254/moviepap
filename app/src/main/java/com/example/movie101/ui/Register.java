package com.example.movie101.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.movie101.R;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText mUserName,mEmail,mConfirmEmail,mPassword,mConfirmPassword;
    Button  mRegisterBtn;
    ProgressBar progressBarReg;
    FirebaseAuth fbAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //seting link  for th xml resource file
        mUserName = findViewById(R.id.mUserName);
        mEmail= findViewById(R.id.mEmail);
        mConfirmEmail=findViewById(R.id.mConfirmEmail);
        mPassword=findViewById(R.id.mPassword);
        mConfirmPassword= findViewById(R.id.mConfirmPassword);
        mRegisterBtn =findViewById(R.id.mRegisterBtn);
        progressBarReg =findViewById(R.id.progressBarReg);
        fbAuth = FirebaseAuth.getInstance();


        //set click listner on the register button
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUserName.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String emailCon =mConfirmEmail.getText().toString().trim();
                String passWord = mPassword.getText().toString().trim();
                String passWordCon = mConfirmPassword.getText().toString().trim();

                //validating user inputs

                if(TextUtils.isEmpty(username) ){
                    mUserName.setError("Username Field id Required");
                    return;
                }

                if(TextUtils.isEmpty(email) ){
                    mEmail.setError("Email Field id Required");
                    return;
                }

                if(TextUtils.isEmpty(emailCon) ){
                    mUserName.setError("Email Confirmation Field id Required");
                    return;
                }

                if(TextUtils.isEmpty(passWord )){
                    mPassword.setError("Password Field id Required");
                    return;
                }

                if(TextUtils.isEmpty(passWordCon) ){
                    mConfirmPassword.setError("PassWor Field id Required");
                    return;
                }
                if(TextUtils.equals(email,emailCon) ){
                    mEmail.setError("Emails Don't match ,Try Again");
                    mConfirmEmail.setError("Emails Don't match ,Try Again");
                    return;
                }

                if(TextUtils.equals(passWord,passWordCon) ){
                    mConfirmPassword.setError("Passwords Don't match ,Try Again");
                    mPassword.setError("PassWords Don't match ,Try Again");
                    return;
                }

            }
        });



    }
}
