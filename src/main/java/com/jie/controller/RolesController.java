package com.jie.controller;

import com.alibaba.fastjson.JSON;
import com.jie.mapper.RolesMapper;
import com.jie.pojo.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    RolesMapper rolesMapper;

    @PostMapping("/updateRights")
    public String updateRights(int id,String rights){
        rolesMapper.updateRights(id,rights);
        return "更新成功";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable int id){
        rolesMapper.deleteRole(id);
        return "删除成功";
    }

    @GetMapping("/lists")
    public List<Roles> queryRoles(){
        return rolesMapper.queryRoles();
    }
}
