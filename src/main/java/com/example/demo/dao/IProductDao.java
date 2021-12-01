package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IProductDao extends JpaRepository<Product,String> {
    List<Product> findUserByPriceGreaterThan(int price);
    @Modifying
    @Transactional
    @Query("select p from Product p where p.price >=:price")
    List<Product> getProductsLargerThanPrice(@Param("price")int price);
    @Modifying
    @Transactional
    @Query("update Product p set p.p_Name=:name where p.p_Id=:id")
    int updateProductNameById(@Param("id")String id, @Param("name") String name);
}
