package com.arduino.seladanghijau.floatinglayoutinputtexttutorial;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // views
    EditText etUsername, etPassword, etEmail;
    Button btnLogin;
    TextInputLayout txtinlayUsername, txtinlayPassword, txtinlayEmail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    public void initViews() {
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtinlayEmail = (TextInputLayout) findViewById(R.id.txtinlayEmail);
        txtinlayPassword = (TextInputLayout) findViewById(R.id.txtinlayPassword);
        txtinlayUsername = (TextInputLayout) findViewById(R.id.txtinlayUsername);

        btnLogin.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnLogin:
                validateForm();
                break;
        }
    }

    public void validateForm() {
        if (!validateName())
            return;

        if (!validateEmail())
            return;

        if (!validatePassword())
            return;

        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
    }

    public boolean validateName() {
        if(etUsername.getText().toString().trim().isEmpty()) {
            txtinlayUsername.setError("Username should not be empty");
            requestFocus(etUsername);

            return false;
        } else
            txtinlayUsername.setErrorEnabled(false);

        return true;
    }

    public boolean validateEmail() {
        if(etEmail.getText().toString().trim().isEmpty()) {
            txtinlayEmail.setError("Email should not be empty");
            requestFocus(etEmail);

            return false;
        } else
            txtinlayEmail.setErrorEnabled(false);

        return true;
    }

    public boolean validatePassword() {
        if(etPassword.getText().toString().trim().isEmpty()) {
            txtinlayPassword.setError("Password should not be empty");
            requestFocus(etPassword);

            return false;
        } else
            txtinlayPassword.setErrorEnabled(false);

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
