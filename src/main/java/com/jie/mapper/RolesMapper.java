package com.jie.mapper;

import com.jie.pojo.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RolesMapper {

    List<Roles> queryRoles();

    int deleteRole(int id);

    int updateRights(int id,String rights);
}
