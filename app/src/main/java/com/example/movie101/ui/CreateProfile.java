package com.example.movie101.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movie101.R;
import com.example.movie101.data.users;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateProfile extends AppCompatActivity {

    Button saveBtn;
    TextView userName,genre,email;
    FirebaseAuth.AuthStateListener fbAuthList;
    FirebaseDatabase fbDb = FirebaseDatabase.getInstance();
    FirebaseAuth fbAuth = FirebaseAuth.getInstance();
    DatabaseReference dbRef = fbDb.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        saveBtn = findViewById(R.id.saveProfile);
        userName = findViewById(R.id.userName);
        genre =findViewById(R.id.genre);
        email=findViewById(R.id.email);

        //onclick listner

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString();
                String mGenre= genre.getText().toString();
                String mEmail= email.getText().toString();

                users user= new users(username,mEmail,mGenre);
                 String uid =dbRef.push().getKey();
                dbRef.child(uid).push().setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(CreateProfile.this,"Data posted successfully",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CreateProfile.this, "Error,Could not post data"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        //auth listner
        makeAuthListner();
    }

    private void  makeAuthListner(){
        fbAuthList = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(CreateProfile.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }

            }
        };

    }

    @Override
    public void onStart() {
        super.onStart();
        fbAuth.addAuthStateListener(fbAuthList);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (fbAuthList != null) {
            fbAuth.removeAuthStateListener(fbAuthList);
        }
    }


    //creating user profile

}
