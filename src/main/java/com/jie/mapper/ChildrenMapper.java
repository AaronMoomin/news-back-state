package com.jie.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ChildrenMapper {

    int changePagePermission(int id,int pagepermission);

    int deleteChildren(int id);
}
