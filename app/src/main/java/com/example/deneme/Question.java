package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Model.Questionresult;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Question extends AppCompatActivity {

    TextView questiontextview;
    EditText questionedit;
    String custid,questionv;
    AppCompatButton questionbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        tanimlama();
        degerleralveisle();
        questionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionv=questionedit.getText().toString();

                questionkayitistek(custid,questionv);
            }
        });
    }
    public void tanimlama(){
        questionedit=findViewById(R.id.questionedit);
        questiontextview=findViewById(R.id.custnumbertext);
        questionbutton=findViewById(R.id.askbutton);
    }

    public void degerleralveisle(){
        Bundle bundle=getIntent().getExtras();
        custid=bundle.getString("custid");

        questiontextview.setText("Customer ID :"+custid);
    }

    public void  questionkayitistek(String custid,String question){

        ManagerAll managerAll=new ManagerAll();
        Call<Questionresult> questionresultCall=managerAll.getquestionr(custid,question);
        questionresultCall.enqueue(new Callback<Questionresult>() {
            @Override
            public void onResponse(Call<Questionresult> call, Response<Questionresult> response) {

            }

            @Override
            public void onFailure(Call<Questionresult> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Hata alindi",Toast.LENGTH_LONG).show();
                questionedit.setText("");

            }
        });
    }
}