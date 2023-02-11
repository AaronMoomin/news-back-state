package com.jie.mapper;

import com.jie.pojo.Regions;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RegionsMapper {

    List<Regions> queryRegions();
}
