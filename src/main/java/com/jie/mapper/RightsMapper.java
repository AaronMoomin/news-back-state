package com.jie.mapper;

import com.jie.pojo.RightsChildren;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RightsMapper {

    List<RightsChildren> queryRights();

    int changePagePermission(int id,int pagepermission);

    int deleteRight(int id);
}
