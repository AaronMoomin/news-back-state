package com.jie.controller;

import com.jie.mapper.RolesMapper;
import com.jie.pojo.Roles;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@Api(value = "权限接口",tags = "权限管理相关的接口")
public class RolesController {

    @Autowired
    RolesMapper rolesMapper;

    /**
     * 更新菜单
     * @param id
     * @param rights
     * @return
     */
    @Operation(summary = "更新菜单",description = "更新菜单")
    @PostMapping("/updateRights")
    public String updateRights(String id,String rights){
        rolesMapper.updateRights(Integer.parseInt(id),rights);
        return "更新成功";
    }

    /**
     * 删除权限
     * @param id
     * @return
     */
    @Operation(summary = "删除权限",description = "删除权限")
    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable int id){
        rolesMapper.deleteRole(id);
        return "删除成功";
    }

    /**
     * 获取权限列表
     * @return
     */
    @Operation(summary = "获取权限列表",description = "获取权限列表")
    @GetMapping("/lists")
    public List<Roles> queryRoles(){
        return rolesMapper.queryRoles();
    }
}
