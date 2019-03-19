package com.ws.mapper;

import com.ws.bean.Salary;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface SalaryMapper {

    @Select("select count(*) from t_salary ")
    long queryTotal(@Param("salary")Salary salary);

    @Select("select * from t_salary LIMIT #{start},#{rows}")
    List<Salary> queryPageProblem(@Param("start") int start, @Param("rows") int rows, @Param("salary") Salary salary);

    //新增
    @Insert("INSERT INTO t_salary(name,city,schooling,salary,ensalary) VALUES(#{name},#{city},#{schooling},#{salary},#{ensalary})")
    void addAnswer(Salary salary);

    //修改
    @Update("UPDATE t_salary set name=#{name},city=#{city},schooling=#{schooling},salary=#{salary},ensalary=#{ensalary} where id=#{id}")
    void updateAnswer(Salary salary);

    //删除
    @Delete("delete from t_salary where id=#{s}")
    void salaryAll(String id);

    //回显
    @Select("SELECT * FROM t_salary  where id=#{id}")
    Salary querySalaryById(Integer id);

    @Select("select * from t_salary ")
    List<Salary> resetlot();
}
