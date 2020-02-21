package com.example.movie101.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movie101.R;
import com.example.movie101.data.users;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateProfile extends AppCompatActivity {

    Button saveBtn;
    TextView userName,genre,email;

    FirebaseDatabase fbDb = FirebaseDatabase.getInstance();
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
    }
}
