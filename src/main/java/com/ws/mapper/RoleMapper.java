package com.ws.mapper;

import com.ws.bean.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    //查询
    @Select("select * from t_role")
    List<Role> queryRole();

    //删除
    @Delete("delete  FROM t_role  where id=#{s} ")
    void deleteAll(String s);


    //新增
    @Insert("INSERT INTO t_role(rname,info) VALUES(#{rname},#{info})")
    void addRole(Role role);
}
