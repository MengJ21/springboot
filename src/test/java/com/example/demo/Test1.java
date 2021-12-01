package com.example.demo;
import com.example.demo.dao.IProductDao;
import com.example.demo.dao.IUserDao;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
public class Test1 {
    @Autowired
    IProductDao productDao;
    @Test
    public void CreateProduct(){
        Product p = new Product();
        p.setP_Id("123");
        p.setP_Name("笔记本电脑");
        p.setP_Category("电子产品");
        p.setPrice(10000);
        productDao.save(p);
    }
    @Test
    public void DeleteProduct(){
        productDao.deleteById("123");
    }

    @Test
    public void InsertUsers(){
        List<Product> productList=new ArrayList<Product>();
        Product p1 = new Product();
        p1.setP_Id("124");
        p1.setP_Name("键盘");
        p1.setP_Category("电子产品");
        p1.setPrice(100);

        Product p2 = new Product();
        p2.setP_Id("125");
        p2.setP_Name("笔记本电脑");
        p2.setP_Category("电子产品");
        p1.setPrice(10000);

        Product p3 = new Product();
        p3.setP_Id("126");
        p3.setP_Name("鼠标");
        p3.setP_Category("电子产品");
        p3.setPrice(50);

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productDao.saveAll(productList);
    }

    @Test
    public void FindUsers(){
        List<Product> uList=productDao.getProductsLargerThanPrice(80);
        System.out.println();
    }
    @Test
    public void updateUser(){
        int result=productDao.updateProductNameById("123","败家之眼");
        System.out.println(result);
    }
}
