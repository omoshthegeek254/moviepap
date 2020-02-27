package com.example.movie101.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
                                fbAuth.getInstance().signOut();
                                startActivity(new Intent(getApplicationContext(), Login.class));
                            }
                        });


            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CreateProfile.class));
            }
        });



    }

    //inflate menu item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //logout user on click of logout on menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//log
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}





