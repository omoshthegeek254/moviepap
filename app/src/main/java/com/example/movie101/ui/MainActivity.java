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

public class MainActivity extends AppCompatActivity {
    FirebaseAuth fbAuth;
    Button mButton,logBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.vMovieBtn);
        logBtn = findViewById(R.id.logoutBtn);
        fbAuth= FirebaseAuth.getInstance();

//        if(fbAuth.getCurrentUser() !=null){
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            finish();
//        }else {
//            startActivity(new Intent(getApplicationContext(),Login.class));
//            finish();
//
//        }

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

        //set click listner on logout

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator moveAnim = ObjectAnimator.ofFloat(v, "Y", 1000);

                moveAnim.setDuration(2000);
                moveAnim.setInterpolator(new BounceInterpolator());



                moveAnim.addListener(
                        new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                //        loging out the user
                                fbAuth.getInstance().signOut();

                                startActivity(new Intent(getApplicationContext(), Login.class));
                                finish();

                            }
                        }

                );
                moveAnim.start();


            }

        });


    }




//
//
//    public void goToMovies(View view) {
//
//      startActivity(new Intent(getApplicationContext(),Main2Activity.class));
//    }

//    public void logout(View view) {
//
//
//    }

    public void makeProf(View view){
        startActivity(new Intent(getApplicationContext(),CreateProfile.class));
    }
}
