package com.example.lg.work8;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by LG on 2017-04-27.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener{
    int fruitno=0;
    int editno=0;
    ImageView img;
    EditText priceinput;
    AutoCompleteTextView at;
    Button b_next,b_add;
    Context context;
    public AddFruit(Context context, AttributeSet attrs){
        super(context,attrs);
        this.context = context;
        init(context);
    }
    void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.fruit_add, this);
        at = (AutoCompleteTextView)findViewById(R.id.f_name);
        img = (ImageView)findViewById(R.id.image1);
        b_next = (Button)findViewById(R.id.b_next);
        b_add = (Button)findViewById(R.id.b_add);
        b_next.setOnClickListener(this);
        b_add.setOnClickListener(this);
        at.setAdapter(new ArrayAdapter<String>(context,android.R.layout.simple_dropdown_item_1line,
                Fruit.names));
    }

    interface OnAddListener {
        void onAdd(String name, int imageno,int price);
        void onAdd(String name, int imageno,int price,int position);
    }

    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }

    public void onClick(View v) {
        if(v==b_add){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View view = View.inflate(context,R.layout.dialog_item,null);
            priceinput = (EditText)view.findViewById(R.id.priceinput);
            builder.setTitle("가격 결정")
                    .setView(view)
                    .setNegativeButton("취소",null)
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int price;
                            if(priceinput.getText().toString().equals("")){
                                price=0;
                            }
                            else
                                price = Integer.parseInt(priceinput.getText().toString());
                            if(b_add.getText().toString().equals("M")){
                                if(at.getText().toString().equals("")){
                                    onAddListener.onAdd("이름 없음",fruitno,price,editno);
                                }
                                else
                                    onAddListener.onAdd(at.getText().toString(),fruitno,price,editno);
                            }
                            else {
                                if (at.getText().toString().equals("")) {
                                    onAddListener.onAdd("이름 없음", fruitno, price);
                                } else
                                    onAddListener.onAdd(at.getText().toString(), fruitno, price);
                            }
                            at.setText("");
                            b_add.setText("ADD");
                        }
                    }).show();
        }
        if(v==b_next){
            if(fruitno==7){
                fruitno=0;
            }
            else
                fruitno++;
            img.setImageResource(Fruit.imgnos[fruitno]);
        }
    }
    public void setEdit(String string,int imgno,int price,int position){
        editno = position;
        at.setText(string);
        fruitno = imgno;
        img.setImageResource(Fruit.imgnos[fruitno]);
        priceinput.setText(Integer.toString(price));
        b_add.setText("M");
    }
}