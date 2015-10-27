package com.example.rtas.posv2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tayjm_000 on 2015-10-27.
 */
public class POSItems {

    public static List<Item> ITEMS = new ArrayList<Item>();

    public static void init()
    {
        System.out.println("Initializing ITEMS");
        ITEMS.add(new Item(R.id.apple,"Apple", 2.00));
        ITEMS.add(new Item(R.id.banana,"Banana", 666.00));
    }

    public static double getPriceByName(String name)
    {
        for(Item item: ITEMS)
        {
            if(item.getName().equals(name))
            {
                return item.getPrice();
            }
        }
        return 0;
    }

    public static Item getItemById(int id)
    {
        for(Item item: ITEMS)
        {
            if(item.getId()==id)
            {
                return item;
            }
        }
        return null;
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
            return name;
        }

        public double getPrice() {
            return price;
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
