package com.jie.controller;

import com.jie.mapper.ChildrenMapper;
import com.jie.mapper.RightsMapper;
import com.jie.pojo.RightsChildren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("children")
public class ChildrenController {

    @Autowired
    ChildrenMapper childrenMapper;

    @DeleteMapping("/delete/{id}")
    public String deleteChildren(@PathVariable int id){
        childrenMapper.deleteChildren(id);
        return "删除成功";
    }

    @PostMapping("/updatePermission")
    public String setPagePermission(int id,int pagepermission){
        childrenMapper.changePagePermission(id,pagepermission);
        return "更新成功";
    }
}
