package com.example.ys_task_mostafaameen.helpers;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.ys_task_mostafaameen.R;
import com.google.android.material.snackbar.Snackbar;
public class Utils {
    public static void showCustomSnackbar(Context context, View rootView, String message ,int flag) {
        if (rootView == null) return;

        Snackbar snackbar = Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT);

        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white));

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbarView.getLayoutParams();
        params.gravity = Gravity.TOP;
        snackbarView.setLayoutParams(params);

        int color =R.color.green;
        int drId = R.drawable.ic_checked;

        if (flag ==0){
            color = R.color.red;
            drId = R.drawable.circal_back;
        }


        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(context,color));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(16);
        textView.setGravity(Gravity.CENTER_VERTICAL);


        Drawable checkIcon = ContextCompat.getDrawable(context,drId);
        checkIcon.setBounds(0, 0, checkIcon.getIntrinsicWidth(), checkIcon.getIntrinsicHeight());
        textView.setCompoundDrawables(checkIcon, null, null, null);
        textView.setCompoundDrawablePadding(16);


        snackbarView.setTranslationY(-200);
        snackbarView.animate()
                .translationY(100)
                .setDuration(500)
                .setInterpolator(new DecelerateInterpolator())
                .withEndAction(() -> {

                    snackbarView.animate()
                            .translationY(-200)
                            .setDuration(500)
                            .setInterpolator(new AccelerateInterpolator())
                            .start();
                })
                .start();

        snackbar.show();
    }
}
