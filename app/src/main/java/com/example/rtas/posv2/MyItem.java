package com.example.rtas.posv2;

/**
 * Created by tayjm_000 on 2015-10-28.
 */
public class MyItem {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public MyItem(int id,String name, double price)
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
            return "null";
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

    @Override
    public String toString() {
        return this.name + " $"+this.price;
    }
}
