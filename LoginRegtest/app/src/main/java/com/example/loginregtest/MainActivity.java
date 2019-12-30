package com.example.loginregtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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
                String loginAddress = "http://192.168.0.107:8080/aaa/Servlettest/LoginServlet";
                String loginusername = etusername.getText().toString();
                String loginpassword = etpassword.getText().toString();
                loginWithOkHttp(loginAddress,loginusername,loginpassword);
                break;
            case R.id.bt_regist:
                String registerAddress = "http://192.168.0.107:8080/aaa/Servlettest/RegistServlet";
                String regusername = etusername.getText().toString();
                String regpassword = etpassword.getText().toString();
                registerWithOkHttp(registerAddress,regusername,regpassword);
                break;
        }
    }

    public void loginWithOkHttp(String address,String username,String password){
        HttpUtil.loginWithOkHttp(address,username,password, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //在这里对异常情况进行处理
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //得到服务器返回的具体内容
                final String responseData = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseData.equals("true")){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    //实现注册
    public void registerWithOkHttp(String address,String username,String password){
        HttpUtil.registerWithOkHttp(address, username, password, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //在这里对异常情况进行处理
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseData.equals("true")){
                            Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
