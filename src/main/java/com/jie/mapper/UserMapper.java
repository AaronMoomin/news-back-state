package com.jie.mapper;

import com.jie.pojo.User;
import com.jie.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<UserRole> queryList();
    UserRole queryUserById(int id);
    UserRole queryUserList(User user);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    int updateRoleState(int id,int roleState);
}
