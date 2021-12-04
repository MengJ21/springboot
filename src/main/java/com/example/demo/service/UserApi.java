package com.example.demo.service;
import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apiguardian.api.API;
import org.aspectj.apache.bcel.classfile.annotation.TypeAnnotationGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//本地提交2
@RestController
@Api(tags = "用户管理接口")
@RequestMapping(value = "api/user",produces = "application/json")
@CrossOrigin(origins = "http://localhost:8081",maxAge = 3600)
//本地提交3
public class UserApi {
    @Autowired
    private IUserDao uerdao;
    @GetMapping("/login/{id}/{password}")
    @ApiOperation("用户登录的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户号", defaultValue = "admin", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "123456", required = true)
    })
    public String login(@PathVariable String id, @PathVariable String password){
        User u =uerdao.findUserByIdAndPassword(id, password);
        if(u == null)
        {
            return "plesase log in first";
        }
        return "welcome" + u.getName() + "!";
    }
    @PostMapping("/login")
    public String loginByIdAndPassword(@RequestParam String id, @RequestParam String password){
        User u =uerdao.findUserByIdAndPassword(id, password);
        if(u == null)
        {
            return "plesase log in first";
        }
        return "welcome" + u.getName() + "!";
    }
    @PostMapping("/login2")
    public User login2(@org.jetbrains.annotations.NotNull @RequestBody User u){
        User u1 =uerdao.findUserByIdAndPassword(u.getId(), u.getPassword());
        if(u1 == null)
        {
            return null;
        }
        else{
            return u1;
        }
    }
    @PostMapping("/identify")
    public User identify(@RequestParam String id, @RequestParam String password){
        User u1 =uerdao.findUserByIdAndPassword(id,password);
        if(u1 == null)
        {
            return null;
        }
        else{
            return u1;
        }
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam String id, @RequestParam String name, @RequestParam String password, @RequestParam int age, @RequestParam boolean sex){
        if (id == null)
        {
            return "Please compelete the Id of the user!";
        }
        User u = new User();
        u.setId(id);
        u.setName(name);
        u.setAge(age);
        u.setPassword(password);
        try {
            uerdao.save(u);
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        uerdao.save(u);
        return "创建成功！";
    }
    @PostMapping("/register2")
    //RequestBody将用户数据转成对象。
    @ApiOperation("用户注册的接口")
            @ApiImplicitParam(name = "user", value = "用户JSON数据", defaultValue = "admin", required = true)


    public String registerUser2(@RequestBody User u){
        try {
            uerdao.save(u);
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        uerdao.save(u);
        return "创建成功！";
    }
    @PutMapping("/update")
    public int update(@RequestBody User u){
        try {
            uerdao.save(u);
        }
        catch(Exception e)
        {
            return 0;
        }
        return 1;
    }
    @PostMapping("/delete")
    public int DeleteUser(@RequestParam("id") String id){
        uerdao.deleteById(id);
        return 1;
    }
    @GetMapping("/getAll")
    public List<User> getAllUsers()
    {
        List<User> list = uerdao.findAll();
        return list;
    }
    @PostMapping("/getOne")
    public User getOneUser(@RequestBody User u){
        User u1 = uerdao.getById(u.getId());
        if(u1 == null)
        {
            return null;
        }
        else
        {
            return u1;
        }
    }
}
