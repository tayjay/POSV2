package com.example.rtas.posv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tayjm_000 on 2015-10-28.
 */
public class ListContent {

    /**
     * An array of items
     */
    public static List<MyItem> ITEMS = new ArrayList<>();

    /**
     * A map of items, by Name
     */
    public static Map<String,MyItem> ITEM_MAP = new HashMap<>();

    static
    {
        //addItem(new MyItem(0,"THIS IS AN ITEM.",0));
        /*
        addItem(POSItems.getItemById(R.id.apple));
        addItem(POSItems.getItemById(R.id.banana));
        */
    }

    public static void addItem(MyItem item)
    {
        //item.setQuantity(1);
        if(ITEM_MAP.get(item.getName())!=null)
        {
            //ITEMS.remove(item);
            item.setQuantity(item.getQuantity()+1);
            //ITEMS.add(item);

        }
        else {
            if(item.getQuantity()==0)
            {
                item.setQuantity(1);
            }
            ITEMS.add(item);
            ITEM_MAP.put(item.getName(), item);
        }
    }

    public static void removeItem(int position)
    {
        MyItem item = ITEMS.get(position);
        if(item.getQuantity()!=0) {
            item.setQuantity(0);
        }
        ITEMS.remove(position);
        ITEM_MAP.remove(item.getName());


    }


}
