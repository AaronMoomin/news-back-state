package com.jie.controller;

import com.jie.mapper.ChildrenMapper;
import com.jie.pojo.Children;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/children")
@Api(value = "二级菜单接口",tags = "二级菜单相关的接口")
public class ChildrenController {

    @Autowired
    ChildrenMapper childrenMapper;

    /**
     * 删除
     * @param id
     * @return
     */
    @Operation(summary = "删除",description = "删除")
    @DeleteMapping("/delete/{id}")
    public String deleteChildren(@PathVariable int id){
        childrenMapper.deleteChildren(id);
        return "删除成功";
    }

    /**
     * 更新权限
     * @param id
     * @param pagepermission
     * @return
     */
    @Operation(summary = "更新权限",description = "更新权限")
    @PostMapping("/updatePermission")
    public String setPagePermission(String id,int pagepermission){
        childrenMapper.changePagePermission(Integer.parseInt(id),pagepermission);
        return "更新成功";
    }

    @Operation(summary = "查询列表",description = "查询列表")
    @GetMapping("/lists")
    public List<Children> queryLists(){
        return childrenMapper.queryLists();
    }
}
