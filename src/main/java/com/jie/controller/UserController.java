package com.jie.controller;

import com.jie.mapper.UserMapper;
import com.jie.pojo.User;
import com.jie.pojo.UserRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "User接口", tags = "用户管理相关的接口")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/users/lists")
    public List<UserRole> queryList(){
        return userMapper.queryList();
    }

    @Operation(summary = "删除用户", description = "删除用户")
    @DeleteMapping("/users/deleteUser/{id}")
    public String deleteUser(@PathVariable String id) {
        userMapper.deleteUser(Integer.parseInt(id));
        return "ok";
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @Operation(summary = "更新用户", description = "更新用户")
    @PostMapping("/users/updateUser")
    public String updateUser(@RequestBody User user) {
        userMapper.updateUser(user);
        return "ok";
    }

    /**
     *更新用户状态
     * @param id
     * @param roleState
     * @return
     */
    @Operation(summary = "更新用户状态", description = "更新用户状态")
    @PostMapping("/users/updateRoleState")
    public String updateRoleState(String id,int roleState){
        userMapper.updateRoleState(Integer.parseInt(id),roleState);
        return "更新成功";
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @Operation(summary = "新增用户", description = "新增用户")
    @PostMapping("/users/addUser")
    public UserRole addUser(@RequestBody User user) {
        userMapper.addUser(user);
        List<UserRole> lists = userMapper.queryList();
        User u = lists.get(lists.size()-1);
        return userMapper.queryUserById(u.getId());
    }

    /**
     * 登录
     *
     * @param username  用户名
     * @param password
     * @param roleState
     * @return
     */
    @Operation(summary = "登录", description = "登录")
    @PostMapping("/login")
    public UserRole login(String username, String password, Integer roleState) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRoleState(roleState);
        return userMapper.queryUserList(user);
    }
}
