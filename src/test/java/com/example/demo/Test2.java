package com.example.demo;
import com.example.demo.dao.IMallDao;
import com.example.demo.dao.IProductDao;
import com.example.demo.dao.IUserDao;
import com.example.demo.entity.Mall;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
public class Test2 {
    @Autowired
    IMallDao iMallDao;
    @Test
    public void CreateMall(){
        Mall mall = new Mall();
        mall.setM_Category("数码店");
        mall.setM_Id("1");
        mall.setM_Name("玩家国度");
        iMallDao.save(mall);
    }
    @Test
    public void InsertMalls(){
        List<Mall> mallList=new ArrayList<Mall>();
        Mall mall1 = new Mall();
        mall1.setM_Category("五金店");
        mall1.setM_Id("2");
        mall1.setM_Name("小强五金");

        Mall mall2 = new Mall();
        mall2.setM_Category("日常店");
        mall2.setM_Id("3");
        mall2.setM_Name("2元店");

        Mall mall3 = new Mall();
        mall3.setM_Category("文具店");
        mall3.setM_Id("4");
        mall3.setM_Name("文体文具");

        mallList.add(mall1);
        mallList.add(mall2);
        mallList.add(mall3);
        iMallDao.saveAll(mallList);
    }
    @Test
    public void DeleteMall(){
        iMallDao.deleteById("1");
    }
    @Test
    public void findAll1(){
        List<Mall> mList=iMallDao.findAll();
        System.out.println();

    }
    @Test
    public void updateMalls(){
        int res = iMallDao.updateMallNameById("3", "饭店");
    }
}
