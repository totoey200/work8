package com.example.lg.work8;

/**
 * Created by LG on 2017-04-27.
 */

public class Fruit {
    static String[] names={"아보카도","바나나","체리","크랜베리","포도","키위","오렌지","수박"};
    static int[] imgnos={R.drawable.abocado,R.drawable.banana,R.drawable.cherry,
            R.drawable.cranberry,R.drawable.grape,R.drawable.kiwi,
            R.drawable.orange,R.drawable.watermelon};
    int imgno;
    String name;
    int price;
    public Fruit(String name, int imgno, int price){
        this.imgno = imgno;
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public int getImgno() {
        return imgno;
    }

    public int getPrice() {
        return price;
    }
}
