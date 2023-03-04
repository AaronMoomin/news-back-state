package com.jie.controller;

import com.jie.mapper.RegionsMapper;
import com.jie.pojo.Regions;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regions")
@Api(value = "地址接口",tags = "地址相关接口")
public class RegionsController {

    @Autowired
    RegionsMapper regionsMapper;

    /**
     * 获取列表
     * @return
     */
    @Operation(summary = "获取列表",description = "获取别表")
    @GetMapping("/lists")
    public List<Regions> queryRegions(){
        return regionsMapper.queryRegions();
    }
}
