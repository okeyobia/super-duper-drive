package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO USERS(username, salt, password, firstname, lastname) " +
            "values(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    Integer insertUser(User user);

    @Delete("DELETE FROM Users WHERE userid = #{userId}")
    void delete(Integer userId);
}
