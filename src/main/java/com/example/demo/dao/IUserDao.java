package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IUserDao extends JpaRepository<User,String> {
    User findUserByIdAndPassword(String id,String name);
    List<User> findUserByAgeGreaterThan(int age);
    User getById(String id);
    @Modifying//完成修改操作。
    @Transactional//事务注解配有事务属性。
    @Query("update User u set u.name=:name where u.id=:id")
    int updateUserNameById(@Param("id")String id, @Param("name") String name);

    @Query("select u from User u where u.age>=:age")
    List<User> getUsersLagerThanAge(@Param("age")int age);

}