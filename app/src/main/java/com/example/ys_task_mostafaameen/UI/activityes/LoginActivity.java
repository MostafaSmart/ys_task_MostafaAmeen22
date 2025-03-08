package com.example.ys_task_mostafaameen.UI.activityes;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.ys_task_mostafaameen.MVVM.ViewModels.AuthModelView;
import com.example.ys_task_mostafaameen.R;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Login.LoginRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Login.LoginValue;
import com.example.ys_task_mostafaameen.data.Repositorys.LoginRepository;
import com.google.android.material.card.MaterialCardView;
//import com.example.ys_task_mostafaameen.data.Room.Entity.UserDataRoom;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends BaseActivity {
    private List<MaterialCardView> pinIndicators = new ArrayList<>();
    private StringBuilder pinCode = new StringBuilder();
    private static final int PIN_LENGTH = 6;
    private ImageButton deleteButton;

    private  android.widget.Button btnDoLogin;
    private   ImageButton exitButton;
    private AuthModelView authViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        authViewModel = new ViewModelProvider(this).get(AuthModelView.class);

        imelmnt();

        setupNumberButtons();


        deleteButton.setOnClickListener(v -> removeLastDigit());

        exitButton.setOnClickListener(v -> finish());


        setResponseListionr();

        btnDoLogin.setOnClickListener(v ->
        {


            if (pinCode.length() == PIN_LENGTH) {
                String enteredPin = pinCode.toString();
                LoginValue valuem = new LoginValue("87","1",enteredPin);
                LoginRequest loginRequest = new LoginRequest(valuem);
                authViewModel.login(loginRequest);
            }
        });




    }
    private void setResponseListionr(){
        authViewModel.getLoginResponse().observe(this, sectionResponse -> {
            if (sectionResponse != null ) {

                Log.d("result" ,sectionResponse.toString());
                Intent intent = new Intent(this,HomeActivity.class);
                startActivity(intent);
                finish();

            } else {


                Toast.makeText(this, "فشل في", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void imelmnt() {
        pinIndicators.add(findViewById(R.id.card1));
        pinIndicators.add(findViewById(R.id.card2));
        pinIndicators.add(findViewById(R.id.card3));
        pinIndicators.add(findViewById(R.id.card4));
        pinIndicators.add(findViewById(R.id.card5));
        pinIndicators.add(findViewById(R.id.card6));

        deleteButton  = findViewById(R.id.deleteButton);
        exitButton = findViewById(R.id.exitButton);
        btnDoLogin = findViewById(R.id.btnDoLogin);

    }
    private void setupNumberButtons() {
        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };

        for (int id : buttonIds) {
            android.widget.Button button = findViewById(id);
            button.setOnClickListener(v -> appendDigit(button.getText().toString()));
        }
    }

    private void appendDigit(String digit) {
        Log.d("NUMBBER: ",digit);
        if (pinCode.length() < PIN_LENGTH) {
            pinCode.append(digit);
            updateIndicators();

            if (pinCode.length() == PIN_LENGTH) {
                String enteredPin = pinCode.toString();

                LoginValue valuem = new LoginValue("87","1",enteredPin);
                LoginRequest loginRequest = new LoginRequest(valuem);
                authViewModel.login(loginRequest);
            }
        }
    }

    private void updateIndicators() {
        int newColor = R.color.primmery;
        int oldColor =   R.color.lite_blue;


        for (int i = 0; i < PIN_LENGTH; i++) {
            if (i < pinCode.length()) {
                 pinIndicators.get(i).setCardBackgroundColor(getResources().getColor(newColor));
            } else {
                pinIndicators.get(i).setCardBackgroundColor(getResources().getColor(oldColor));
            }
        }
    }
    private void removeLastDigit() {
        if (pinCode.length() > 0) {
            pinCode.deleteCharAt(pinCode.length() - 1);
            updateIndicators();
        }
    }

}