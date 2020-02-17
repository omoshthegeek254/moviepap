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

public class Login extends AppCompatActivity {
    EditText mPassword,mUserName;
    Button mLoginBtn;
    ProgressBar progressBarLogin;
    FirebaseAuth fbAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserName = findViewById(R.id.mUserName);
        mPassword= findViewById(R.id.mPassword);
        mLoginBtn =findViewById(R.id.mLoginBtn);
        progressBarLogin=findViewById(R.id.progressBarLogin);
        fbAuth =FirebaseAuth.getInstance();

//        if(fbAuth.getCurrentUser() !=null){
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            finish();
//        }else {
//            Toast.makeText(Login.this,"Kindly login First",Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(getApplicationContext(),Login.class));
//
//
//        }


        //login logic
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mUserName.getText().toString().trim();
                String password=mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mUserName.setError("User Email is Required !");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required ");
                    return;
                }

                progressBarLogin.setVisibility(View.VISIBLE);

                //authenticate user

                Task<AuthResult> login_successful = fbAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        } else {
                            Toast.makeText(Login.this, "Error !!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });

    }
    public void regUser(View view){
        startActivity(new Intent(getApplicationContext(),Register.class));
    }
}
