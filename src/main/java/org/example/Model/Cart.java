package org.example.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {

    @Id
    private int CART_ID;
    private String USER_ID;
    private int PRODUCT_ID;
    private int QUANTITY;

    public int getCART_ID() {
        return CART_ID;
    }

    public void setCART_ID(int CART_ID) {
        this.CART_ID = CART_ID;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "CART_ID=" + CART_ID +
                ", USER_ID='" + USER_ID + '\'' +
                ", PRODUCT_ID=" + PRODUCT_ID +
                ", QUANTITY=" + QUANTITY +
                '}';
    }
}
