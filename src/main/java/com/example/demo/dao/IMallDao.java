package com.example.demo.dao;

import com.example.demo.entity.Mall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Repository//将接口的实体交给Spring来管理。
public interface IMallDao extends JpaRepository<Mall,String> {
    @Modifying//完成修改操作。
    @Transactional//事务注解配有事务属性。
    @Query("update Mall m set m.m_Name=:name where m.m_Id=:id")
    int updateMallNameById(@Param("id")String id, @Param("name") String name);

}
