package com.shop.inventory;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Concrete impl of the Shopping item interface
 */
public class ShoppingItemImpl implements ShoppingItem {
    private String name;
    private BigDecimal price;

    public ShoppingItemImpl(String name,Double price){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Item name can not be null or empty");
        }
        if(price == null || price < 0.0){
            throw new IllegalArgumentException("Item price can not be null or less than 0.0");
        }

        this.name = name.toUpperCase();
        this.price = new BigDecimal(price,new MathContext(2, RoundingMode.HALF_EVEN));

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != o.getClass()) return false;
        ShoppingItemImpl impl = (ShoppingItemImpl) o;
        return name.equals(impl.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
