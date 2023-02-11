package com.jie.controller;

import com.jie.mapper.RegionsMapper;
import com.jie.pojo.Regions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionsController {

    @Autowired
    RegionsMapper regionsMapper;

    @GetMapping("/lists")
    public List<Regions> queryRegions(){
        return regionsMapper.queryRegions();
    }
}
