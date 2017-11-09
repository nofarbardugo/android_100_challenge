package com.example.android.challenge1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final Random RANDOM = new Random();
    TextView mRandomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRandomNumber = findViewById(R.id.tv_random_number);
        mRandomNumber.setText(String.valueOf(this.generateRandom()));
    }

    private int generateRandom() {
        return RANDOM.nextInt();
    }

    public void goToActivityB(View view) {
        ActivityB.startActivityB(this, this.mRandomNumber.getText().toString());
    }

    static void startActivityA(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
