package com.shop.inventory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Luther on 16/05/2016.
 */
public class ShoppingItemImplTest {

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithNullNameAndPrice() {
        ShoppingItem item = new ShoppingItemImpl(null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithNullNameAndValidPrice() {
        ShoppingItem item = new ShoppingItemImpl(null,0.10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithValidNameAndNullPrice() {
        ShoppingItem item = new ShoppingItemImpl("Test",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithEmptyNameAndValidPrice() {
        ShoppingItem item = new ShoppingItemImpl("",0.10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithBlankSpaceNameAndPrice() {
        ShoppingItem item = new ShoppingItemImpl(" ",0.10);
    }


    @Test
    public void testEquals() throws Exception {
        ShoppingItem item1 = new ShoppingItemImpl("Apple",0.10);
        ShoppingItem item2 = new ShoppingItemImpl("aPPle",0.10);
        ShoppingItem item3 = new ShoppingItemImpl("apple",0.10);

        assertEquals("Items should be equal",item1,item2);
        assertEquals("Items should be equal",item3,item2);
    }

    @Test
    public void testHashCode() throws Exception {
        ShoppingItem item1 = new ShoppingItemImpl("Apple",0.10);
        ShoppingItem item2 = new ShoppingItemImpl("Apple",0.10);
        ShoppingItem item3 = new ShoppingItemImpl("apple",0.10);

        assertEquals("Items should be equal",item1.hashCode(),item2.hashCode());
        assertEquals("Items should be equal",item3.hashCode(),item2.hashCode());
    }

}