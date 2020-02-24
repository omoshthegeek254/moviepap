package com.example.movie101.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movie101.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText mPassword,mUserName;
    Button mLoginBtn;
    ProgressBar progressBarLogin;
     FirebaseAuth fbAuth;
     FirebaseUser fbUser;
    TextView forgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fbAuth= FirebaseAuth.getInstance();
        fbUser = fbAuth.getCurrentUser();

        if(fbUser!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
//
//        else {
//            startActivity(new Intent(getApplicationContext(),Login.class));
//            finish();
//
//        }




        mUserName = findViewById(R.id.mUserName);
        mPassword= findViewById(R.id.mPassword);
        mLoginBtn =findViewById(R.id.mLoginBtn);
        progressBarLogin=findViewById(R.id.progressBarLogin);
        fbAuth =FirebaseAuth.getInstance();
        forgotPass =findViewById(R.id.forgotPass);

//reset password
 forgotPass.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         EditText resetMail = new EditText(Login.this);
         AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(Login.this);
         passwordResetDialog.setMessage("Enter your Email below to receive password reset");
         passwordResetDialog.setView(resetMail);

         //handling dialogue buttons
         passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 //extract email and reset email
                 String mail = resetMail.getText().toString();
                 fbAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                     @Override
                     public void onSuccess(Void aVoid) {
                         Toast.makeText(Login.this,"Reset link sent to mail",Toast.LENGTH_SHORT).show();

                     }
                 }).addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {
                         Toast.makeText(Login.this,"Error !!!Reset link Not sent "+e.getMessage(),Toast.LENGTH_SHORT).show();
                     }
                 });

             }
         });

         passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 //Close dialog
             }
         });

         passwordResetDialog.create().show();


     }
 });

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

        }





        );

    }
    public void regUser(View view){
        startActivity(new Intent(getApplicationContext(),Register.class));
    }
}
