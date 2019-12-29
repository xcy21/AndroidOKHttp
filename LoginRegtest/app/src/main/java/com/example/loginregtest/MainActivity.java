package com.example.loginregtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etusername,etpassword;
    private Button btnLogin,btnRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        etusername = findViewById(R.id.et_username);
        etpassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.bt_login);
        btnRegist = findViewById(R.id.bt_regist);

        btnLogin.setOnClickListener(this);
        btnRegist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_login:
                break;
            case R.id.bt_regist:
                break;
        }
    }
}
