package org.example.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int PRODUCT_ID;
    private String PRODUCT_NAME;
    private int PRICE;
    private  String BRAND;
    private  String IMAGE_SOURCE;

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public String getIMAGE_SOURCE() {
        return IMAGE_SOURCE;
    }

    public void setIMAGE_SOURCE(String IMAGE_SOURCE) {
        this.IMAGE_SOURCE = IMAGE_SOURCE;
    }

    @Override
    public String toString() {
        return "Product{" +
                "PRODUCT_ID=" + PRODUCT_ID +
                ", PRODUCT_NAME='" + PRODUCT_NAME + '\'' +
                ", PRICE=" + PRICE +
                ", BRAND='" + BRAND + '\'' +
                ", IMAGE_SOURCE='" + IMAGE_SOURCE + '\'' +
                '}';
    }
}
