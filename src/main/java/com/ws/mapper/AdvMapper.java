package com.ws.mapper;


import com.ws.bean.Advertisement;
import com.ws.bean.WebUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdvMapper {


    //查询总条数
    //@Select("select count(*)  from t_advertisement")
    @Select("<script>"
            + "select count(*) from t_advertisement "
            + " where 1=1 "
            + " <if test='adv.content!=null'> "
            + " and content like '%${adv.content}%' "
            + "</if>"
            + "</script>")
    long queryTota(@Param("adv") Advertisement adv);

    //查询

    //@Select("SELECT * FROM t_advertisement LIMIT #{start},#{rows}")
    @Select("<script>"
            + "SELECT * FROM t_advertisement "
            + " where 1=1 "
            + " <if test='adv.content!=null'> "
            + " and content like '%${adv.content}%' "
            + " LIMIT #{start},#{rows} "
            + "</if>"
            + "</script>")
    List<Advertisement> queryPageAdv(@Param("start")int start, @Param("rows")int rows, @Param("adv") Advertisement adv);



    //删除
    @Delete("delete from t_advertisement where id=#{s}")
    void deleteAll(String s);

    //修改回显
    @Select("SELECT * FROM t_advertisement c where c.id=#{id}")
    Advertisement queryById(Integer id);


    //修改
    @Update("UPDATE t_advertisement c SET c.url=#{url} ,c.href=#{href} ,c.content=#{content} where c.id=#{id}")
    void updateAdv(Advertisement adv);
    //新增
    @Insert("INSERT INTO t_advertisement(url,href,content)VALUES(#{url},#{href},#{content})")
    void addAdv(Advertisement adv);


}
