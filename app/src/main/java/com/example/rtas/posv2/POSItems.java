package com.example.rtas.posv2;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by tayjm_000 on 2015-10-27.
 */
public class POSItems {

    public static List<MyItem> ITEMS = new ArrayList<MyItem>();
    private static MyItem apple;

    public static void init()
    {
        /*
        apple = new MyItem(R.id.apple, "Apple", 2.00);
        ITEMS.add(apple);
        */
        ITEMS.add(new MyItem(R.id.apple, "Apple", 2.00));
        ITEMS.add(new MyItem(R.id.banana,"Banana", 666.00));
        ITEMS.add(new MyItem(R.id.battery,"Battery",1.51));
        ITEMS.add(new MyItem(R.id.cheese,"Cheese",1.51));
        ITEMS.add(new MyItem(R.id.strawberry,"Strawberry",1.51));
        ITEMS.add(new MyItem(R.id.chicken,"Chicken",1.51));
        ITEMS.add(new MyItem(R.id.milk,"Milk",1.51));
        ITEMS.add(new MyItem(R.id.beef,"Beef",1.51));
        ITEMS.add(new MyItem(R.id.dress,"Dress",1.51));
        ITEMS.add(new MyItem(R.id.lego,"Lego",1.51));
        ITEMS.add(new MyItem(R.id.book,"Book",1.51));
        ITEMS.add(new MyItem(R.id.lotion,"Lotion",1.51));
        ITEMS.add(new MyItem(R.id.tshirt,"T-Shirt",1.51));
        ITEMS.add(new MyItem(R.id.pants,"Pants",1.51));
        ITEMS.add(new MyItem(R.id.shoes,"Shoes",1.51));
        ITEMS.add(new MyItem(R.id.socks,"Socks",1.51));


    }

    public static double getPriceByName(String name)
    {
        for(MyItem item: ITEMS)
        {
            if(item.getName().equals(name))
            {
                return item.getPrice();
            }
        }
        return 0;
    }

    public static MyItem getItemById(int id)
    {
        for(MyItem item: ITEMS)
        {
            if(item.getId()==id)
            {
                return item;
            }
        }
        return new MyItem(0,"null",0);
    }

    public static MyItem getItemByName(String name)
    {
        for(MyItem item: ITEMS)
        {
            if(item.getName().equals(name))
            {

                return item;
            }
        }
        return new MyItem(0,"null",0);
    }

    public static MyItem getItemRand()
    {
        for(MyItem item: ITEMS)
        {
            if(item!=null) {
                return item;
            }
        }
        return new MyItem(0,"null",0);
    }




    public static class Item
    {
        private int id;
        private String name;
        private double price;
        private int quantity;

        public Item(int id,String name, double price)
        {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId()
        {
            return id;
        }

        public String getName() {
            if(name != null) {
                return name;
            }
            else
            {
                return "";
            }
        }

        public double getPrice() {
            if(name != null) {
                return price;
            }
            else
            {
                return 0;
            }
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void addQuantity(int add)
        {
            this.quantity += add;
        }
    }
}
