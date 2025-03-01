package com.example.ys_task_mostafaameen.UI.activityes;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.ys_task_mostafaameen.R;
import com.example.ys_task_mostafaameen.UI.fragments.OrderFragment;

import dagger.hilt.android.AndroidEntryPoint;


public class HomeActivity extends AppCompatActivity {
    private TextView txtUserName;
    private ImageView imageView;
    private FrameLayout main_home;
    private LinearLayout linearLayout;
    private LinearLayout linearLayout3;
    private androidx.cardview.widget.CardView summary;
    private androidx.cardview.widget.CardView btnOrders;
    private androidx.cardview.widget.CardView btnLangog;
    private androidx.cardview.widget.CardView BtnLogout;
    private androidx.cardview.widget.CardView btnHistory;
    private androidx.constraintlayout.widget.ConstraintLayout main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home2);
        implmnt();

        setFragment(new OrderFragment());


    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_home,fragment)
                .commit();
    }

    private void implmnt() {
        main = findViewById(R.id.main);
        txtUserName = findViewById(R.id.txtUserName);
        summary = findViewById(R.id.summary);
        btnOrders = findViewById(R.id.btnOrders);
        btnLangog = findViewById(R.id.btnLangog);
        BtnLogout = findViewById(R.id.BtnLogout);
        imageView = findViewById(R.id.imageView);
        main_home = findViewById(R.id.main_home);
        btnHistory = findViewById(R.id.btnHistory);
        linearLayout = findViewById(R.id.linearLayout);
        linearLayout3 = findViewById(R.id.linearLayout3);
    }
}