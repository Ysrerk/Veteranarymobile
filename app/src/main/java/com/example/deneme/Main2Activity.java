package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.Result;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    EditText email2,code2;
    Button activatebutton;
    String emailv;
    String codev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeactive);
        definition();
        emailal();
        aktifet();
    }


    public void emailal(){
        Bundle bundle=getIntent().getExtras();
        emailv=bundle.getString("email");
        email2.setText(emailv);
    }

    public void definition(){
        email2=findViewById(R.id.emailet2);
        code2=findViewById(R.id.codeet2);
        activatebutton=findViewById(R.id.activatebutton);
    }

    public void aktifet(){

        activatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                codev=code2.getText().toString();
                ManagerAll managerAll=new ManagerAll();
                Call<Result>resultCall =managerAll.makeactivev(codev,emailv);
                resultCall.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        Toast.makeText(getApplicationContext(),"Guncelleme basarili sekilde yapildi",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"Guncelleme basarili sekilde yapilmadi",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

    }
}