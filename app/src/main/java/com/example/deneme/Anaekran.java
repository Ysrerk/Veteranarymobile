
package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import Model.Petresult;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Anaekran extends AppCompatActivity {


    ImageView mypetimageview;

    String custid,username,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anaekran);




        tanimla();
        degerlerial();

        mypetimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Anaekran.this,Pets.class);
                intent.putExtra("custid",custid);
                startActivity(intent);
                finish();
            }
        });

    }

    public void degerlerial(){
        Bundle intent=getIntent().getExtras();
        custid=intent.getString("custid");

    }

    public void tanimla(){
        mypetimageview=findViewById(R.id.clickicon3);
    }


}