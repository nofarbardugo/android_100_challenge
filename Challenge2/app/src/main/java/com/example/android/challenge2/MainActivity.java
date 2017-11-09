package com.example.android.challenge2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    final static Pattern PATTERN = Pattern.compile(EMAIL_PATTERN);

    EditText mEmail;
    EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.et_email);
        mPassword = findViewById(R.id.et_password);
    }

    public void onLoginClick(View view) {

        boolean canClick = true;
        final String email = mEmail.getText().toString();
        if (!isValidEmail(email)) {
            mEmail.setError("Invalid Email");
            canClick = false;
        }

        final String pass = mPassword.getText().toString();
        if (!isValidPassword(pass)) {
            mPassword.setError("Invalid Password");
            canClick = false;
        }

        if (canClick) {
            ActivityB.startActivityB(this, mEmail.getText().toString(), mPassword.getText().toString());
        }
    }

    // validating email id
	private boolean isValidEmail(String email) {
		Matcher matcher = PATTERN.matcher(email);
		return matcher.matches();
	}

    // validating password with retype password
	private boolean isValidPassword(String pass) {
		if (pass != null && pass.length() > 6) {
			return true;
		}
		return false;
	}
}
