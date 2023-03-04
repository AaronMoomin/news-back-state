package com.jie.controller;

import com.jie.mapper.CategoriesMapper;
import com.jie.pojo.Categories;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Api(value = "新闻类型接口",tags = "新闻类型相关的接口")
public class CategoriesController {

    @Autowired
    CategoriesMapper categoriesMapper;

    /**
     * 删除
     * @param id
     * @return
     */
    @Operation(summary = "删除",description = "删除")
    @DeleteMapping("/delete/{id}")
    public String deleteCategories(@PathVariable int id){
        categoriesMapper.deleteCategories(id);
        return "删除成功";
    }

    /**
     * 更新
     * @param categories
     * @return
     */
    @Operation(summary = "更新",description = "更新")
    @PostMapping("/update")
    public String updateCategories(@RequestBody Categories categories){
        categoriesMapper.updateCategories(categories);
        return "更新成功";
    }

    /**
     * 获取列表
     * @return
     */
    @Operation(summary = "获取列表",description = "获取列表")
    @GetMapping("/lists")
    public List<Categories> queryCategories(){
        return categoriesMapper.queryCategories();
    }
}
