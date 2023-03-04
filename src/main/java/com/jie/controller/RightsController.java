package com.jie.controller;

import com.jie.mapper.RightsMapper;
import com.jie.pojo.RightsChildren;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rights")
@Api(value = "级菜单接口",tags = "一级菜单相关的接口")
public class RightsController {

    @Autowired
    RightsMapper rightsMapper;

    /**
     * 删除
     * @param id
     * @return
     */
    @Operation(summary = "删除",description = "删除")
    @DeleteMapping("/delete/{id}")
    public String deleteRight(@PathVariable int id){
        rightsMapper.deleteRight(id);
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
        rightsMapper.changePagePermission(Integer.parseInt(id),pagepermission);
        return "更新成功";
    }

    /**
     * 获取列表
     * @return
     */
    @Operation(summary = "获取列表",description = "获取列表")
    @GetMapping("/lists")
    public List<RightsChildren> queryRights(){
        return rightsMapper.queryRights();
    }
}
