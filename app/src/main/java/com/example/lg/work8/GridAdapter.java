package com.example.lg.work8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by LG on 2017-04-27.
 */

public class GridAdapter extends BaseAdapter {
    ArrayList<Fruit> fruits = new ArrayList<>();
    Context context;
    boolean check=false;
    public GridAdapter(ArrayList<Fruit> fruits, Context context){
        this.fruits = fruits;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fruits.size();
    }

    @Override
    public Object getItem(int position) {
        return fruits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = new GridItem(context);
        }
        ((GridItem)convertView).setData(fruits.get(position));
        if(check){
            ((GridItem)convertView).setChecked(check);
        }
        else{
            ((GridItem)convertView).setChecked(check);
        }
        return convertView;
    }
    public void change(boolean check){
        this.check = check;
        notifyDataSetChanged();
    }

}
