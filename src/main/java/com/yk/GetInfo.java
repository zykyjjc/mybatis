package com.yk;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * created by 不器 on 2018/12/17.
 */
public interface GetInfo {
    @Select("select id,name,age from black where id=#{id}")
     User getUser(int id);
    @Select("select * from black")
     List<User> getUserList();
    @Insert("insert  into black(name, age) values(#{name},#{age})")
     void insertUser(User user);
    @Update("update black set name=#{name},age=#{age} where id=#{id}")
     void  updateUser(User user);
    @Delete("delete from black where id=#{id}")
     void  deleteUser(int id);
}
