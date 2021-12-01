package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_info")
public class Product {
    @Id
    private String p_Id;
    @Column(length = 20)
    private String p_Name;
    @Column(length = 10)
    private String p_Category;
    private int price;

    public String getP_Id() {
        return p_Id;
    }

    public void setP_Id(String p_Id) {
        this.p_Id = p_Id;
    }

    public String getP_Name() {
        return p_Name;
    }

    public void setP_Name(String p_Name) {
        this.p_Name = p_Name;
    }

    public String getP_Category() {
        return p_Category;
    }

    public void setP_Category(String p_Category) {
        this.p_Category = p_Category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
