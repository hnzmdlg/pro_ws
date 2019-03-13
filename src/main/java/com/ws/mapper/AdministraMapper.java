package com.ws.mapper;

import com.ws.bean.Administration;
import com.ws.bean.Answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdministraMapper {
    @Select("SELECT COUNT(*) from  t_administration a  LEFT JOIN t_kecheng k on a.kid = k.id")
    long queryTotal(Administration administration);

    @Select("SELECT *  from  t_administration a  LEFT JOIN t_kecheng k on a.kid = k.id  LIMIT #{start},#{rows}")
    List<Answer> queryAdministra(int start, int rows, Administration administration);
    @Select("SELECT *  from  t_administration a  LEFT JOIN t_kecheng k on a.kid = k.id  ORDER BY a.sdianji DESC")
    List<Administration> queryAdmini();

    @Insert("INSERT INTO t_administration(sdianji,kid) VALUES(#{sdianji},#{kid})")
    void addAdministration(Administration administration);
}
