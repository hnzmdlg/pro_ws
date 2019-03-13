package com.ws.mapper;


import com.ws.bean.Xinwen;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface XinwenMapper {
    // 查询总条数
    //@Select("select count(*) from t_xinwen")
    @Select("<script>"
            + "select count(*) from t_xinwen "
            + " where 1=1 "
            + " <if test='xinwen.content!=null'> "
            + " and content like '%${xinwen.content}%' "
            + "</if>"
            + "</script>")
    long queryTotal(@Param("xinwen")Xinwen xinwen);


    //查询
    //@Select("SELECT * FROM t_xinwen  LIMIT #{start},#{rows}")
    @Select("<script>"
            + "SELECT * FROM t_xinwen "
            + " where 1=1 "
            + " <if test='xinwen.content!=null'> "
            + " and content like '%${xinwen.content}%' "
            + " LIMIT #{start},#{rows} "
            + "</if>"
            + "</script>")
    List<Xinwen> queryPageProblem(@Param("start")int start, @Param("rows")int rows, @Param("xinwen")Xinwen xinwen);

    // 修改
    @Update("UPDATE t_xinwen SET content=#{content} ,createTime=#{createTime},createUser=#{createUser},url=#{url} where id=#{id}")
    void updateXinwen(Xinwen xinwen);
    //新增
    @Insert("INSERT into t_xinwen(content,createTime,createUser,url) VALUES(#{content},#{createTime},#{createUser},#{url})")
    void addXinwen(Xinwen xinwen);
//回显
@Select("SELECT * FROM t_xinwen x where x.id=#{id}")
    Xinwen queryXinwenById(Integer id);
//删除
@Delete("delete from t_xinwen where id=#{s}")
    void deleteAll(String s);
}
