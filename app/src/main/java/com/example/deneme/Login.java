package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
    TextView signup;

    //1 shared preferences tanimi icin ilk adim
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        definition();

        //5 login olunca yapilan tanimin aynisi burayada  on create icinede yapiliyor
        //sharedPreferences=getApplicationContext().getSharedPreferences("giris",0);
        sharedPreferences=getApplicationContext().getSharedPreferences("giris",0);
        //shared prefeerences de editor deki degerler null mu diye kontrol edilip degilse  ana ekrana gonderiliyor
        if(sharedPreferences.getString("id",null)!=null && sharedPreferences.getString("username",null)!=null&&sharedPreferences.getString("email",null)!=null){
            Intent intent=new Intent(Login.this,Anaekran.class);
            startActivity(intent);
            finish();
        }

        //sign up butonuna click ediliyor
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



        //login butonuna click ediliyor
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
        signup=findViewById(R.id.signuptext);

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

                String id=response.body().getId();
                String username=response.body().getUsername();
                String email=response.body().getEmail();
                Toast.makeText(getApplicationContext(),response.body().getEmail(),Toast.LENGTH_LONG).show();
                //2 shared preferences tanimi icin ikinci adim
                //burada sisteme basarili sekilde giris yapildiysa hemen alttaki tanim yapiliyor.
                //sharedPreferences=getApplicationContext().getSharedPreferences("giris",0);
                sharedPreferences=getApplicationContext().getSharedPreferences("giris",0);
                //3 sharedpereferences editor tanimi yapiliyor
                //SharedPreferences.Editor editor=sharedPreferences.edit();  ile

                SharedPreferences.Editor editor=sharedPreferences.edit();
                //4 simdi editor e veriler isleniyor
                editor.putString("id",id);
                editor.putString("username",username);
                editor.putString("email",email);
                editor.commit();


                Intent intent=new Intent(Login.this,Anaekran.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"hata",Toast.LENGTH_LONG).show();

            }
        });

    }


}
