package com.example.movie101.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.movie101.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth fbAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(fbAuth.getCurrentUser() !=null){
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            finish();
//        }else {
//            startActivity(new Intent(getApplicationContext(),Login.class));
//            finish();
//
//        }
    }

    public void goToMovies(View view) {

        Intent i = new Intent(getApplicationContext(), MoviesActivity.class);
        startActivity(i);
    }

    public void logout(View view) {

//        loging out the user
        fbAuth.getInstance().signOut();

startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

//    public void createProfile(View view){
//        startActivity(new Intent(getApplicationContext(),));
//    }
}
