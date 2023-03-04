package com.jie.mapper;

import com.jie.pojo.Children;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChildrenMapper {

    int changePagePermission(int id,int pagepermission);

    int deleteChildren(int id);

    List<Children> queryLists();
}
