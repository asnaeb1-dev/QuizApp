package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton loginButton;
    private TextView registerText, forgotPassword;
    private ImageView fbLogin, gmailLogin;

    private Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerText = findViewById(R.id.registerScreen);
        forgotPassword = findViewById(R.id.forgotPass);

        fbLogin = findViewById(R.id.faceBookIcon);
        gmailLogin = findViewById(R.id.gmailIcon);

        loginButton = findViewById(R.id.loginButton);

        registerText.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
        loginButton.setOnClickListener(v -> startActivity(new Intent(this, HomeScreen.class)));
    }

    @SuppressLint("ClickableViewAccessibility")
    private void handleAnimation(){
        scaleUp = AnimationUtils.loadAnimation(this, R.anim.anim_alpha_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.anim_alpha_down);

        forgotPassword.setOnTouchListener((v, e) -> {
            if(e.getAction() == MotionEvent.ACTION_DOWN){
                forgotPassword.startAnimation(scaleUp);
            }else if(e.getAction() == MotionEvent.ACTION_UP){
                forgotPassword.startAnimation(scaleDown);
            }
            return true;
        });
        fbLogin.setOnTouchListener((v, e) -> {
            if(e.getAction() == MotionEvent.ACTION_DOWN){
                fbLogin.startAnimation(scaleUp);
            }else if(e.getAction() == MotionEvent.ACTION_UP){
                fbLogin.startAnimation(scaleDown);
            }
            return true;
        });
        gmailLogin.setOnTouchListener((v, e) -> {
            if(e.getAction() == MotionEvent.ACTION_DOWN){
                gmailLogin.startAnimation(scaleUp);
            }else if(e.getAction() == MotionEvent.ACTION_UP){
                gmailLogin.startAnimation(scaleDown);
            }
            return true;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        handleAnimation();
    }
}