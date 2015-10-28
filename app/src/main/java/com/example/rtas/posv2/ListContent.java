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
    //public static Map<String,MyItem> ITEM_MAP = new HashMap<>();

    static
    {
        addItem(POSItems.getItemRand());
    }

    private static void addItem(MyItem item)
    {
        ITEMS.add(item);
        //ITEM_MAP.put(item.getName(),item);
    }


}
