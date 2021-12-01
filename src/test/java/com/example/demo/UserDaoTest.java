package com.example.demo;
import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Course5ApplicationTests {
    @Autowired
    private IUserDao uerdao;

    @Test
    public void CreateUser(){
        User u=new User();
        u.setId("20201120266");
        u.setAge(20);
        u.setName("帅帅");
        u.setPassword("123456789");
        u.setSex(true);
        uerdao.save(u);
    }
    @Test
    public void DeleteUsers(){
        uerdao.deleteById("20201120266");
    }

    @Test
    public void InsertUsers(){
        List<User> uList=new ArrayList<User>();
        User u1=new User();
        u1.setId("20201120000");
        u1.setAge(20);
        u1.setName("小红");
        u1.setPassword("123456789");
        u1.setSex(true);

        User u2=new User();
        u2.setId("20201120001");
        u2.setAge(20);
        u2.setName("小丽");
        u2.setPassword("123456789");
        u2.setSex(false);

        User u3=new User();
        u3.setId("20201120002");
        u3.setAge(20);
        u3.setName("小明");
        u3.setPassword("123456789");
        u3.setSex(false);

        uList.add(u1);
        uList.add(u2);
        uList.add(u3);

        uerdao.saveAll(uList);
    }

    @Test
    public void FindAllUsers(){
        List<User> uList=uerdao.findAll();
        System.out.println();
    }

    @Test
    public void Login(){
        User u=uerdao.findUserByIdAndPassword("20201120000","小红");
        System.out.println("");
    }

    @Test
    public void FindUsersWithAge(){
        List<User> uList=uerdao.findUserByAgeGreaterThan(15);
    }

    @Test
    public void FindUsersWithAge2(){
        List<User> uList=uerdao.getUsersLagerThanAge(18);
        System.out.println(uList);
    }

    @Test
    public void UpdateUserName(){
        int result=uerdao.updateUserNameById("20201120293","久呀");
        System.out.println(result);
    }
}
