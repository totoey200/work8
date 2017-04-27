package com.example.lg.work8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    GridAdapter gridAdapter;
    ArrayList<Fruit> data;
    CheckBox cb;
    AddFruit addFruit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    void init(){
        data = new ArrayList<>();
        cb = (CheckBox)findViewById(R.id.checkbox);
        gridView = (GridView)findViewById(R.id.gridview);
        gridAdapter = new GridAdapter(data,this);
        gridView.setAdapter(gridAdapter);
        addFruit = (AddFruit)findViewById(R.id.addFruit);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    gridAdapter.change(isChecked);
                }
                else{
                    gridAdapter.change(isChecked);
                }
            }
        });
        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
            @Override
            public void onAdd(String name, int imageno, int price) {
                data.add(new Fruit(name,imageno,price));
                gridAdapter.notifyDataSetChanged();
            }

            @Override
            public void onAdd(String name, int imageno, int price, int position) {
                data.set(position,new Fruit(name, imageno, price));
                gridAdapter.notifyDataSetChanged();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Tag","hi");
                Fruit nowData = data.get(position);
                addFruit.setEdit(nowData.getName(),nowData.getImgno(),nowData.getPrice(),position);
            }
        });
    }
}
