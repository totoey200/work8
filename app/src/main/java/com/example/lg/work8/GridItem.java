package com.example.lg.work8;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GridItem extends LinearLayout {
    TextView fname;
    ImageView fpic;
    TextView fprice;
    public  GridItem(Context context){
        super(context);
        init(context);
    }

    public void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.activity_grid_item,this);
        fname = (TextView)findViewById(R.id.fname);
        fprice = (TextView)findViewById(R.id.fprice);
        fpic= (ImageView)findViewById(R.id.fpic);
    }

    public void setData(Fruit one){
        fname.setText(one.getName());
        fprice.setText(Integer.toString(one.getPrice())+"원");
        fpic.setImageResource(one.getImgno());
    }

    public void setChecked(boolean check){
        if(check){
            fprice.setVisibility(VISIBLE);
        }
        else{
            fprice.setVisibility(INVISIBLE);
        }
    }

}
