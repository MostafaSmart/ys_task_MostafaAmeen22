package com.example.ys_task_mostafaameen.UI.home;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ys_task_mostafaameen.R;
import com.example.ys_task_mostafaameen.UI.app.BaseActivity;
import com.example.ys_task_mostafaameen.UI.auth.AuthModelView;
import com.example.ys_task_mostafaameen.UI.auth.LoginActivity;
import com.example.ys_task_mostafaameen.UI.home.history.HistoryFragment;
import com.example.ys_task_mostafaameen.UI.home.order.OrderFragment;
import com.example.ys_task_mostafaameen.UI.home.summary.SummaryFragment;
import com.example.ys_task_mostafaameen.data.Repositorys.LoginRepository;
import com.example.ys_task_mostafaameen.databinding.ActivityHome2Binding;
import com.example.ys_task_mostafaameen.databinding.ActivityLoginBinding;
import com.example.ys_task_mostafaameen.databinding.DialogLangBinding;
import com.example.ys_task_mostafaameen.databinding.DialogLogoutBinding;
import com.example.ys_task_mostafaameen.helpers.LocaleHelper;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends BaseActivity {

    private ActivityHome2Binding binding;
    private List<CardView> cardViews;
    private   Dialog dialog;
    private DialogLogoutBinding dialogBinding;

    private   Dialog dialog2;
    private DialogLangBinding dialogLangBinding;
    private AuthModelView authViewModel ;

    private String newLang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        EdgeToEdge.enable(this);
        binding = ActivityHome2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        authViewModel = new ViewModelProvider(this).get(AuthModelView.class);

        implmnt();

        setFragment(new OrderFragment());


        binding.btnOrders.setOnClickListener(view -> updateSelection(binding.btnOrders, new OrderFragment()));
        binding.btnHistory.setOnClickListener(view -> updateSelection(binding.btnHistory, new HistoryFragment()));
        binding.summary.setOnClickListener(view -> updateSelection(binding.summary, new SummaryFragment()));

        binding.btnLogout.setOnClickListener(v -> logOut());


        binding.btnLangog.setOnClickListener(v ->  setLang());

        dialogBinding.btnCansel.setOnClickListener(v -> {
            dialog.cancel();
        });
        dialogBinding.btnLogout.setOnClickListener(v -> {
            authViewModel.logout();
        });

        authViewModel.getLogoutStatus().observe(this, success -> {
            if (success) {
                dialog.cancel();

                Toast.makeText(this, "تم تسجيل الخروج بنجاح!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }
        });


        dialogLangBinding.btnEnglsh.setOnClickListener(v->{
            langBtns(1);

        });

        dialogLangBinding.btnArabic.setOnClickListener(v->{
            langBtns(0);

        });

        dialogLangBinding.btnSaveLang.setOnClickListener(s->{

           settingsViewModel.setLanguage(newLang);
            LocaleHelper.setLocale(this,newLang);
            recreate();
        });

    }

    private void setLang() {

        if ("ar".equals(settingsViewModel.getLanguage().getValue())){
            langBtns(0);
        }

        else {
            langBtns(1);


        }

        dialog2.show();
    }



    private void logOut() {
        dialog.show();
    }

    private void langBtns(int flag){
        if (flag == 1){
            dialogLangBinding.btnEnglsh.setCardBackgroundColor(getResources().getColor(R.color.lite_blue));
            dialogLangBinding.btnEnglsh.setCardElevation(8f);

            dialogLangBinding.btnArabic.setCardBackgroundColor(getResources().getColor(R.color.white));
            dialogLangBinding.btnArabic.setCardElevation(8f);
            newLang = "en";
        }
        else{
            dialogLangBinding.btnArabic.setCardBackgroundColor(getResources().getColor(R.color.lite_blue));
            dialogLangBinding.btnArabic.setCardElevation(8f);

            dialogLangBinding.btnEnglsh.setCardBackgroundColor(getResources().getColor(R.color.white));
            dialogLangBinding.btnEnglsh.setCardElevation(8f);
            newLang = "ar";

        }
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
        cardViews = Arrays.asList(binding.btnOrders, binding.btnHistory, binding.summary);

        dialog = new Dialog(this);

        dialogBinding = DialogLogoutBinding.inflate(getLayoutInflater());
        dialog.setContentView(dialogBinding.getRoot());

        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setWindowAnimations(R.style.DialogAnimation);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().setGravity(Gravity.CENTER);
        }


        dialog2 = new Dialog(this);

        dialogLangBinding = DialogLangBinding.inflate(getLayoutInflater());
        dialog2.setContentView(dialogLangBinding.getRoot());

        if (dialog2.getWindow() != null) {
            dialog2.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog2.getWindow().setWindowAnimations(R.style.DialogAnimation);
            dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog2.getWindow().setGravity(Gravity.CENTER);
        }

    }
}