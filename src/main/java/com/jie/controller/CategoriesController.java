package com.jie.controller;

import com.jie.mapper.CategoriesMapper;
import com.jie.mapper.ChildrenMapper;
import com.jie.pojo.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    CategoriesMapper categoriesMapper;

    @DeleteMapping("/delete/{id}")
    public String deleteCategories(@PathVariable int id){
        categoriesMapper.deleteCategories(id);
        return "删除成功";
    }

    @PostMapping("/update")
    public String updateCategories(@RequestBody Categories categories){
        categoriesMapper.updateCategories(categories);
        return "更新成功";
    }

    @GetMapping("/lists")
    public List<Categories> queryCategories(){
        return categoriesMapper.queryCategories();
    }
}
