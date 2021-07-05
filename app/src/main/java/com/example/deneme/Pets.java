package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Model.Petresult;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pets extends AppCompatActivity {
    AppCompatButton mypetsbutton;
    ListView listView;
    List<Petresult> petresultList;
    String custid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);
        tanimla();
        Bundle bundle=getIntent().getExtras();
        custid=bundle.getString("custid");
        mypetsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                istekat(custid);
            }
        });
    }

    public void tanimla(){
        mypetsbutton=findViewById(R.id.mypetsebutton);
        listView=findViewById(R.id.petlistview);

    }
    public void istekat(String custid){
        petresultList=new ArrayList<>();
        ManagerAll managerAll=new ManagerAll();
        Call<List<Petresult>>listCall=managerAll.getpetresult(custid);
        listCall.enqueue(new Callback<List<Petresult>>() {
            @Override
            public void onResponse(Call<List<Petresult>> call, Response<List<Petresult>> response) {
                petresultList=response.body();
                Petadapter petadapter=new Petadapter(petresultList,getApplicationContext());
                listView.setAdapter(petadapter);

                //Toast.makeText(getApplicationContext(),petresultList.toString(),Toast.LENGTH_LONG).show();
                Log.i("ddd",petresultList.toString());
            }

            @Override
            public void onFailure(Call<List<Petresult>> call, Throwable t) {

            }
        });
    }
}