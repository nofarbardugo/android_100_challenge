package com.example.android.challenge1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    static final String EXTRA_KEY = "extra-key";
    TextView mDisplayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        mDisplayText = findViewById(R.id.tv_displayNumber);
        mDisplayText.setText(getIntent().getStringExtra(EXTRA_KEY));
    }

    static void startActivityB(Context context, @NonNull String textToShow) {
        Intent intent = new Intent(context, ActivityB.class);
        intent.putExtra(EXTRA_KEY, textToShow);
        context.startActivity(intent);
    }

    public void goToActivityA(View view) {
        MainActivity.startActivityA(this);
    }
}
