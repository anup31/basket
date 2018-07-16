package com.shop.checkout;

import com.shop.inventory.ShoppingItem;
import com.shop.inventory.ShoppingItemImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests the checkout manager functionality
 */
public class CheckoutManagerTest {

    private CheckoutManager checkoutManager;

    @Before
    public void setUp() throws Exception {
        checkoutManager = new CheckoutManager();

    }

    @Test
    public void getTotalPriceWithNoItems() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        BigDecimal actual = checkoutManager.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(0,new MathContext(2, RoundingMode.HALF_EVEN));
        assertTrue("Price should be 0",actual.compareTo(expected) == 0 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTotalPriceWithNullItems() throws Exception {
        BigDecimal price = checkoutManager.getTotalPrice(null);
    }

    @Test
    public void getTotalPriceWithOneItem() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        ShoppingItem item = new ShoppingItemImpl("Banana",0.60);
        basket.addItem(item);

        BigDecimal actual = checkoutManager.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(0.60,new MathContext(2, RoundingMode.HALF_EVEN));
        assertTrue("Price should be 0.60",actual.compareTo(expected) == 0 );
    }

    @Test
    public void getTotalPriceWith1Item4Quanity() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        String name = "Banana";
        double price = 0.60;
        ShoppingItem item1 = new ShoppingItemImpl(name,price);
        ShoppingItem item2 = new ShoppingItemImpl(name,price);
        ShoppingItem item3 = new ShoppingItemImpl(name,price);
        ShoppingItem item4 = new ShoppingItemImpl(name,price);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        basket.addItem(item4);

        BigDecimal expected = new BigDecimal(2.4,new MathContext(2, RoundingMode.HALF_EVEN));
        BigDecimal actual = checkoutManager.getTotalPrice(basket);

        assertTrue("Price should be 2.4", actual.compareTo(expected) == 0 );
    }

    @Test
    public void getTotalPriceWith4ItemQuanity1each() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        ShoppingItem item1 = new ShoppingItemImpl("Banana",0.60);
        ShoppingItem item2 = new ShoppingItemImpl("Apple",0.50);
        ShoppingItem item3 = new ShoppingItemImpl("Orange",0.40);
        ShoppingItem item4 = new ShoppingItemImpl("lemon",0.30);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        basket.addItem(item4);

        BigDecimal actual = checkoutManager.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(1.80,new MathContext(2, RoundingMode.HALF_EVEN));
        //banana -0.60, apple -0.50, orange - 0.40, lemon -0.3
        assertTrue("Price should be 1.80", actual.compareTo(expected) == 0 );

    }

    @Test
    public void getTotalPriceWithMultiItemMultiQuanity() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        ShoppingItem item1 = new ShoppingItemImpl("Banana",0.60);
        ShoppingItem item2 = new ShoppingItemImpl("Apple",0.50);
        ShoppingItem item3 = new ShoppingItemImpl("Orange",0.40);
        ShoppingItem item4 = new ShoppingItemImpl("Banana",0.60);
        ShoppingItem item5 = new ShoppingItemImpl("Orange",0.40);
        ShoppingItem item6 = new ShoppingItemImpl("Orange",0.40);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        basket.addItem(item4);
        basket.addItem(item5);
        basket.addItem(item6);

        BigDecimal actual = checkoutManager.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(2.90,new MathContext(2, RoundingMode.HALF_EVEN));
        //banana -0.60, apple -0.50, orange - 0.40

        assertTrue("Price should be 2.90", actual.compareTo(expected) == 0 );

    }
}