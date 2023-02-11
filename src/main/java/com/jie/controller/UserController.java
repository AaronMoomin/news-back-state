package com.jie.controller;

import com.jie.mapper.UserMapper;
import com.jie.pojo.User;
import com.jie.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        userMapper.deleteUser(id);
        return "ok";
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        userMapper.updateUser(user);
        return "ok";
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        userMapper.addUser(user);
        return "ok";
    }

    /**
     * 登录
     * @param username 用户名
     * @param password
     * @param roleState
     * @return
     */
    @PostMapping("/login")
    public UserRole login(String username,int password,int roleState){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRoleState(roleState);
        UserRole userRole = userMapper.queryUserList(user);
        System.out.println(userRole);
        return userRole;
    }
}
