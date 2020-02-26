package com.example.movie101.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.example.movie101.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button mButton, logBtn,profile;
    private FirebaseAuth fbAuth;
    private FirebaseUser fbUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.vMovieBtn);
        logBtn= findViewById(R.id.logoutBtn);

        profile= findViewById(R.id.profile);

        fbAuth = FirebaseAuth.getInstance();
        fbUser =fbAuth.getCurrentUser();




        //set click listner on btn movies
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton.animate().alpha(0.5f).rotation(90f).
                        scaleX(2).xBy(100).yBy(100).setDuration(2000).setStartDelay(10).
                        setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                Toast.makeText(MainActivity.this, "Started...", Toast.LENGTH_SHORT).show();
                            }

                            ;

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                            }
                        });

//
//

            }
        });


        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logBtn.animate().alpha(0.5f).rotation(90f).
                        scaleX(2).xBy(100).yBy(100).setDuration(2000).setStartDelay(10).
                        setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                Toast.makeText(MainActivity.this, "Logged Out...", Toast.LENGTH_SHORT).show();
                            }

                            ;

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                startActivity(new Intent(getApplicationContext(), Login.class));
                            }
                        });


            }
        });



    }


//    public void logout(View view) {
//        startActivity(new Intent(getApplicationContext(),Login.class));
//    }
}





