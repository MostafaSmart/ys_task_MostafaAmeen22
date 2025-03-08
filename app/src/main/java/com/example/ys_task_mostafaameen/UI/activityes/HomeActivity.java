package com.example.ys_task_mostafaameen.UI.activityes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.ys_task_mostafaameen.R;
import com.example.ys_task_mostafaameen.UI.fragments.HistoryFragment;
import com.example.ys_task_mostafaameen.UI.fragments.OrderFragment;
import com.example.ys_task_mostafaameen.UI.fragments.SummaryFragment;
import com.example.ys_task_mostafaameen.data.Repositorys.LoginRepository;
import com.example.ys_task_mostafaameen.helpers.LocaleHelper;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends BaseActivity {
    private TextView txtUserName;
    private ImageView imageView;
    private FrameLayout main_home;
    private LinearLayout linearLayout;
    private LinearLayout linearLayout3;
    private androidx.cardview.widget.CardView summary;
    private androidx.cardview.widget.CardView btnOrders;
    private androidx.cardview.widget.CardView btnLangog;
    private androidx.cardview.widget.CardView btnLogout;
    private androidx.cardview.widget.CardView btnHistory;
    private androidx.constraintlayout.widget.ConstraintLayout main;

    private List<CardView> cardViews;

    @Inject
     LoginRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home2);

        implmnt();

        setFragment(new OrderFragment());


        btnOrders.setOnClickListener(view -> updateSelection(btnOrders, new OrderFragment()));
        btnHistory.setOnClickListener(view -> updateSelection(btnHistory, new HistoryFragment()));
        summary.setOnClickListener(view -> updateSelection(summary, new SummaryFragment()));

        btnLogout.setOnClickListener(v -> logOut());


        btnLangog.setOnClickListener(v ->  setLang());

    }

    private void setLang() {
        String ss =   settingsViewModel.setLanguage();

        Toast.makeText(this,ss,Toast.LENGTH_SHORT).show();

        LocaleHelper.setLocale(this,ss);


        recreate();
    }


    private void logOut() {
        new Thread(() -> {

            if (repository.logout()) {
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                finish();
            } else {
                Log.d("DATABASE", "User not found");
            }
        }).start();
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_home,fragment)
                .commit();
    }

    private void updateSelection(CardView selectedCard, Fragment fragment) {
        for (CardView card : cardViews) {
            card.setCardBackgroundColor(getResources().getColor(R.color.white));
            card.setCardElevation(8f);
        }
        selectedCard.setCardBackgroundColor(getResources().getColor(R.color.lite_blue));
        selectedCard.setCardElevation(8f);

        setFragment(fragment);
    }


    private void implmnt() {
        main = findViewById(R.id.main);
        txtUserName = findViewById(R.id.txtUserName);
        summary = findViewById(R.id.summary);
        btnOrders = findViewById(R.id.btnOrders);
        btnLangog = findViewById(R.id.btnLangog);
        btnLogout = findViewById(R.id.btnLogout);
        imageView = findViewById(R.id.imageView);
        main_home = findViewById(R.id.main_home);
        btnHistory = findViewById(R.id.btnHistory);
        linearLayout = findViewById(R.id.linearLayout);
        linearLayout3 = findViewById(R.id.linearLayout3);


        cardViews = Arrays.asList(btnOrders, btnHistory, summary);
    }
}