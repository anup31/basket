package com.shop.checkout;

import com.shop.inventory.ShoppingItem;
import java.util.HashMap;

/**
 * Class to manage the shopping items
 */
public class ShoppingBasket {

    // map of items to their quantity
    private HashMap<ShoppingItem, Integer> items;

    public HashMap<ShoppingItem, Integer> getItems() {
        return items;
    }

      public ShoppingBasket(){
        items = new HashMap<>();
    }


    /*
     * Adds an item with a inital quantity of 1. if the item already exists, its quantity will be increase by 1
     */
    
    public void addItem(ShoppingItem item){
        if(item == null){
            throw new IllegalArgumentException("Shopping basket can't be null");
        }

        if (items.containsKey(item)) {
            items.replace(item, items.get(item) + 1);
        } else {
            items.put(item,1);
        }
    }

    /**
     * Clears all items in the shopping basket
     */
    public void clear(){
        items.clear();
    }

}
