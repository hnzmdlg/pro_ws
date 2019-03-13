package com.ws.mapper;

import com.ws.bean.Answer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnswerMapper {

    //总条数
    //@Select("select count(*) from t_answer a LEFT JOIN  t_problem pm on a.wid=pm.id and a.contont like '%${answer.contont}%'")
   /* @Select({">script>",
            "select count(*) from t_answer a LEFT JOIN  t_problem pm on a.wid=pm.id",
            "<where>",
            "<if test='answer.contont!=null and answer.contont!='''>",
            "and a.contont like '%${answer.contont}%'",
            "</if>",
            "</where>",
            ">/script>"
    })*/
    /*@Select({">script>",
            "select count(*) from t_answer a LEFT JOIN  t_problem pm on a.wid=pm.id",
            "WHERE 1=1",
            "<when test='answer.contont!=null'>",
            "and a.contont like '%${answer.contont}%'",
            "</when>",
            ">/script>"})*/
    @Select("<script>"
            + "select count(*) from t_answer a LEFT JOIN  t_problem pm on a.wid=pm.id "
            + "WHERE 1=1"
            + "<if test='answer.contont!=null'>"
            + "and a.contont like '%${answer.contont}%'"
            + "</if>"
            + "</script>")
    long queryTotal(@Param("answer") Answer answer);

    //查询
    //@Select("SELECT * FROM t_answer a LEFT JOIN  t_problem pm on a.wid=pm.id  LIMIT #{start},#{rows}")
    @Select("<script>"
            + "SELECT * FROM t_answer a LEFT JOIN  t_problem pm on a.wid=pm.id  "
            + "WHERE 1=1"
            + "<if test='answer.contont!=null'>"
            + "and a.contont like '%${answer.contont}%'"
            + "LIMIT #{start},#{rows}"
            + "</if>"
            + "</script>")
    List<Answer> queryPageProblem(@Param("start") int start, @Param("rows") int rows, @Param("answer") Answer answer);

    //删除
    @Delete("delete  FROM t_answer  where id=#{s} ")
    void deleteAll(String s);
    //新增
    @Insert("INSERT INTO t_answer(contont,createtime,wid) VALUES({contont},{createtime},{wid})")
    void addAnswer(Answer answer);
    //查询回显
    @Select("SELECT * FROM t_answer where id=#{id}")
    Answer queryAnswerById(Integer id);
    //修改
    @Update("UPDATE t_answer  p SET p.contont=#{contont} ,p.createtime=#{createtime},p.wid=#{wid} WHERE id=#{id}")
    void updateAnswer(Answer answer);
}
