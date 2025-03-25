package com.example.ys_task_mostafaameen.UI.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.lifecycle.ViewModelProvider;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ys_task_mostafaameen.UI.app.BaseActivity;
import com.example.ys_task_mostafaameen.UI.home.HomeActivity;
import com.example.ys_task_mostafaameen.UI.auth.AuthModelView;
import com.example.ys_task_mostafaameen.R;
//import com.example.ys_task_mostafaameen.data.Room.Entity.UserDataRoom;
import com.example.ys_task_mostafaameen.UI.auth.LoginActivity;
import com.example.ys_task_mostafaameen.data.Room.User.Helpers.UserDatabaseHelper;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity {

    private AuthModelView authViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        authViewModel = new ViewModelProvider(this).get(AuthModelView.class);
        LottieAnimationView animationView = findViewById(R.id.lottieAnimationView);

        animationView.setAnimation("chef-illus3.json");

        animationView.setTranslationY(300f);
        animationView.animate().translationY(0f).setDuration(1500);
        animationView.playAnimation();


        chikcUser();



    }

    private void chikcUser(){
        authViewModel.getCurrentUserLiveData().observe(this, userData -> {

            boolean isUserLoggedIn = userData != null;
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                Intent intent;
                if (isUserLoggedIn) {
                    intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("user_id", userData.getUserId());
                } else {
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }, 3000);
        });
    }
    }
