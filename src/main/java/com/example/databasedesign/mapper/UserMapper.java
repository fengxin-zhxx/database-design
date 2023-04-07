package com.example.databasedesign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.databasedesign.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select ID, s_password from student where ID = #{username} and s_password = #{password} ")
    List<Map<String, Object>> selectStudentUser(String username,String password);


    @Select("select ID, password from manager where ID = #{username} and password = #{password} ")
    List<Map<String, Object>> selectManagerUser(String username,String password);


    @Select("select ID, i_password from instructor where ID = #{username} and i_password = #{password} ")
    List<Map<String, Object>> selectInstructorUser(String username,String password);

}
