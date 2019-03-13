package com.ws.mapper;

import com.ws.bean.WebUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WebUserMapper {

    //查询总条数
    @Select("select count(*)  from s_webuser")
    long queryTota(@Param("webuser") WebUser webuser);


    //查询总条数    修改会员信息
    @Update("update s_webuser s set s.member=0 where  to_days(now()) - to_days(s.expiredate)>730")
    long queryTota2(@Param("webuser") WebUser webuser);



    //查询
    @Select("SELECT * FROM s_webuser where ttid=1 LIMIT #{start},#{rows}")
    List<WebUser> queryPageWebUser(@Param("start") int start, @Param("rows") int rows, @Param("webuser") WebUser webuser);
    //修改回显
    @Select("SELECT * FROM s_webuser c where c.id=#{id}")
    WebUser queryWebUserById(Integer id);
    //修改
    @Update("UPDATE s_webuser c SET c.name=#{name} ,c.pwd=#{pwd} ,c.email=#{email}, c.sex=#{sex},c.ttid=1,c.phone=#{phone} where c.id=#{id}")
    void updateWebUser(WebUser webuser);
    //新增
    @Insert("INSERT INTO s_webuser(name,pwd,email,sex,member,expiredate,ttid,phone)VALUES(#{name},#{pwd},#{email},#{sex},#{member},#{expiredate},0,#{phone})")
    void addWebUser(WebUser webuser);
    //删除
    @Delete("delete from s_webuser where id=#{s}")
    void deleteAll(String s);

    //未通过查询
    @Select("SELECT * FROM s_webuser where ttid=0 LIMIT #{start},#{rows}")
    List<WebUser> queryWebUserWei(int start, int rows, WebUser webuser);

    //通过审核
    @Update("UPDATE s_webuser w set w.ttid=1 WHERE w.id =#{id}")
    void updateWebUserId(Integer id);

    //查看审核状态
    @Select("SELECT * FROM s_webuser where id=#{id} ")
    WebUser queryWebUserTtid(Integer id);
}
