package com.jie.mapper;

import com.jie.pojo.User;
import com.jie.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    UserRole queryUserList(User user);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
