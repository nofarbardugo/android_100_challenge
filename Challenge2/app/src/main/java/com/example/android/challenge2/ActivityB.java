package com.example.android.challenge2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    static final String EXTRA_KEY_EMAIL = "email-key";
    static final String EXTRA_KEY_PASSWORD = "password-key";
    TextView mEmail;
    TextView mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        mEmail = findViewById(R.id.tv_email);
        mEmail.setText(getIntent().getStringExtra(EXTRA_KEY_EMAIL));

        mPassword = findViewById(R.id.tv_password);
        mPassword.setText(getIntent().getStringExtra(EXTRA_KEY_PASSWORD));
    }

    static void startActivityB(Context context, @NonNull String email, @NonNull String password) {
        Intent intent = new Intent(context, ActivityB.class);
        intent.putExtra(EXTRA_KEY_EMAIL, email);
        intent.putExtra(EXTRA_KEY_PASSWORD, password);
        context.startActivity(intent);
    }
}
