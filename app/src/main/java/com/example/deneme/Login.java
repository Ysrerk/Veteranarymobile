package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.LoginResult;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {



    EditText email,password;
    Button loginbut;
    String emailv,passwordv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        definition();


        loginbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degeral();

            }
        });



    }


    public void definition(){
        email=findViewById(R.id.emaillogin);
        password=findViewById(R.id.passwordlogin);
        loginbut=findViewById(R.id.loginbutton2);

    }
    public void degeral(){
        emailv=email.getText().toString();
        passwordv=password.getText().toString();
        loginistek(emailv,passwordv);
    }



    public void loginistek(String emailv,String passwordv){




        ManagerAll managerAll=new ManagerAll();
        Call<LoginResult>loginResultCall=managerAll.getlognresult(emailv,passwordv);
        loginResultCall.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                Toast.makeText(getApplicationContext(),response.body().getEmail(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"hata",Toast.LENGTH_LONG).show();

            }
        });

    }


}
