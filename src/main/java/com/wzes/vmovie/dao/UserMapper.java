package com.wzes.vmovie.dao;

import com.wzes.vmovie.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Create by xuantang
 * @date on 10/31/17
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user (username, password) VALUES (#{username},#{password});")
    int addUser(User user);

    @Select("SELECT username, password FROM user WHERE username = #{username} and password = #{password}")
    User findUser(String username, String password);

    @Delete("DELETE FROM user WHERE username = #{username}")
    int removeUser(User user);

}
