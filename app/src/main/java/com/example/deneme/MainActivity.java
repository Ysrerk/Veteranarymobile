package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.onesignal.OneSignal;

import Model.Result;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String ONESIGNAL_APP_ID = "29919c24-6e34-44a1-a1ba-554edbb877b1";

    EditText usernameed,emailed,password;
    AppCompatButton registerbutton;
    String usernamev,emailv,passwordv,custid;
    TextView registeredtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
        setContentView(R.layout.activity_main);

        definition();
        registeristek();
        registeredtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginegecis();
            }
        });
    }


    public void definition(){
        usernameed=findViewById(R.id.usernameet);
        emailed=findViewById(R.id.emailet);
        password=findViewById(R.id.passwordet);
        registerbutton=findViewById(R.id.loginbutton);
        registeredtext=findViewById(R.id.registeredtext);
    }
    public void registeristek(){

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManagerAll managerAll=new ManagerAll();
                usernamev=usernameed.getText().toString();
                emailv=emailed.getText().toString();
                passwordv=password.getText().toString();

               Call<Result>resultCall=managerAll.alsonuc(usernamev,emailv,passwordv);
               resultCall.enqueue(new Callback<Result>() {
                   @Override
                   public void onResponse(Call<Result> call, Response<Result> response) {
                       custid=response.body().getCustid();


                       Toast.makeText(getApplicationContext(),"oldum",Toast.LENGTH_LONG).show();



                   }

                   @Override
                   public void onFailure(Call<Result> call, Throwable t) {

                       Toast.makeText(getApplicationContext(),"olmadi",Toast.LENGTH_LONG).show();

                   }
               });

                Intent intent=new Intent(getApplicationContext(), Main2Activity.class);

                intent.putExtra("email",emailv);

                startActivity(intent);
            }
        });



    }
    public void loginegecis(){

        Intent intent=new Intent(getApplicationContext(),Login.class);

        startActivity(intent);
    }
}