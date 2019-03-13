package com.ws.mapper;

import com.ws.bean.Dept;
import com.ws.bean.Role;
import com.ws.bean.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserBeanMappper {
    //查看员工
    @Select("select count(*)  from user a ")
    long queryTotal(@Param("userBean") UserBean userBean);
    @Select("SELECT u.* , d.dname,r.rname from user u LEFT JOIN t_dept d on u.deptid=d.id LEFT JOIN  t_role  r on  u.roleid GROUP BY u.id" +
            "  LIMIT #{start},#{rows}")
    List<UserBean> queryPage(@Param("start") int start, @Param("rows") int rows, @Param("userBean") UserBean userBean);
    //查看登录用户拥有的权限
    @Select("SELECT  DISTINCT(pm.url) from t_prower_menu pm LEFT JOIN t_role_power rp on pm.power_id =rp.power_id\n" +
            "LEFT JOIN t_role r ON rp.role_id = r.id LEFT JOIN  user u on r.id=u.roleid WHERE u.id=#{id} and pm.url is not null\n" +
            "UNION\n" +
            "SELECT DISTINCT(t.url) FROM t_tree t LEFT JOIN t_prower_menu pm on t.id=pm.power_id \n" +
            "LEFT JOIN t_role_power rp on pm.power_id = rp.power_id \n" +
            "LEFT JOIN user  u on rp.id = u.roleid WHERE u.id=#{id} and t.url is not null")
    List<String> queryPowerMenuByUserid(Integer id);

    //进去登录后 修改密码
    @Update("UPDATE   user u set u.userpwd=#{userpwd} where u.id=#{uid}")
    void updatPwd(UserBean userBean);

    //查询角色
    @Select("SELECT * from t_role")
    List<Role> queryUserRole();
//查询部门
@Select("SELECT * from t_dept")
    List<Dept> queryUserDeptid();
//修改
@Update("UPDATE user  SET name=#{name} ,userimg=#{userimg},age=#{age},sex=#{sex},roleid=#{roleid},deptid=#{deptid},phone=#{phone},username=#{username},userpwd=#{userpwd},registration_date=#{registration_date}where id=#{id}")
    void updateUserBean(UserBean userbean);
//新增

@Insert("INSERT into user(name,userimg,age,sex,roleid,deptid,phone,username,userpwd,registration_date) VALUES(#{name},#{userimg},#{age},#{sex},#{roleid},#{deptid},#{phone},#{username},#{userpwd},#{registration_date})")
    void addUserBean(UserBean userbean);
//回显
@Select("SELECT * FROM user c where c.id=#{id}")
    UserBean queryUserById(Integer id);
//删除
@Delete("delete from user where id=#{s}")
void deleteAll(String s);
}
