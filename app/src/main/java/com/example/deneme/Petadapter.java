package com.example.deneme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import Model.Petresult;

public class Petadapter  extends BaseAdapter {
    List<Petresult>petadapterList;
    Context context;

    public Petadapter(List<Petresult> petadapterList, Context context) {
        this.petadapterList = petadapterList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return petadapterList.size();
    }

    @Override
    public Object getItem(int position) {
        return petadapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        TextView custid=convertView.findViewById(R.id.custid);
        TextView petname=convertView.findViewById(R.id.petname);
        TextView petkind=convertView.findViewById(R.id.petkind);
        TextView pettur=convertView.findViewById(R.id.pettur);
        ImageView imageView=convertView.findViewById(R.id.petimage);
        Picasso.with(context).load(petadapterList.get(position).getPetimage()).into(imageView);
        custid.setText(petadapterList.get(position).getCustid());
        petname.setText(petadapterList.get(position).getPetname());
        petkind.setText(petadapterList.get(position).getPetkind());
        pettur.setText(petadapterList.get(position).getPettur());





        return convertView;
    }
}

