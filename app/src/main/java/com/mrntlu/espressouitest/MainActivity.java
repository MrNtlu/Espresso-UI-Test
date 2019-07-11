package com.mrntlu.espressouitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_email) EditText edtEmail;
    @BindView(R.id.edt_pass) EditText edtPassword;
    @BindView(R.id.tv_result) TextView tvResult;
    @BindView(R.id.btn_login) Button btnLogin;

    public static String email="test@gmail.com",password="123",loginSuccess="Login Success!",loginFailed="Login Failed!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(view->{
            if (edtEmail.getText().toString().equalsIgnoreCase(email) && edtPassword.getText().toString().equalsIgnoreCase(password)) tvResult.setText(loginSuccess);
            else tvResult.setText(loginFailed);
        });
    }
}
