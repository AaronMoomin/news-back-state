package com.jie.controller;

import com.jie.mapper.RightsMapper;
import com.jie.pojo.RightsChildren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rights")
public class RightsController {

    @Autowired
    RightsMapper rightsMapper;

    @DeleteMapping("/delete/{id}")
    public String deleteRight(@PathVariable int id){
        rightsMapper.deleteRight(id);
        return "删除成功";
    }

    @PutMapping("/updatePermission")
    public String setPagePermission(int id,int pagepermission){
        rightsMapper.changePagePermission(id,pagepermission);
        return "更新成功";
    }

    @GetMapping("/lists")
    public List<RightsChildren> queryRights(){
        return rightsMapper.queryRights();
    }
}
