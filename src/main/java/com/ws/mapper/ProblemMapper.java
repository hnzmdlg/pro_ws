package com.ws.mapper;



import com.ws.bean.ProblemBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface ProblemMapper {

    //查询总条数
    @Select("select count(*)  from t_problem")
    long queryTotal(@Param("problemBean") ProblemBean problemBean);

    //查询
    @Select("SELECT * FROM t_problem LIMIT #{start},#{rows}")
    List<ProblemBean> queryPageProblem(@Param("start") int start, @Param("rows") int rows, @Param("problemBean") ProblemBean problemBean);
    //删除
    @Delete("delete from t_problem where id=#{s}")
    void deleteAll(String s);

//新增
    @Insert("INSERT INTO t_problem(pname,pcreatetime,psfzr)VALUES(#{pname},#{pcreatetime},#{psfzr})")
    void addProblemBean(ProblemBean problemBean);


    //查询
    @Select("SELECT * FROM t_problem")
    List<ProblemBean> queryProblem3();
}
