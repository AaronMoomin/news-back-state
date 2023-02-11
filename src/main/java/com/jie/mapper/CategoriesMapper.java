package com.jie.mapper;

import com.jie.pojo.Categories;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoriesMapper {
    List<Categories> queryCategories();

    int updateCategories(Categories categories);

    int deleteCategories(int id);
}
