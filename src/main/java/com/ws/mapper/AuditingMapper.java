package com.ws.mapper;

import com.ws.bean.Salary;
import com.ws.bean.Xinwen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AuditingMapper {

    //查询新闻审核
    @Select("SELECT * FROM t_xinwen  where ttid=0")
    List<Xinwen> auditingId();

    //通过审核
    @Update("UPDATE t_xinwen  set ttid=1 WHERE id =#{id}")
    void updateauditingId(Integer id);

    //查询薪资审核
    @Select("select * from t_salary where ttid=0")
    List<Salary> salarytingId();

    //通过薪资审核
    @Update("UPDATE t_salary  set ttid=1 WHERE id =#{id}")
    void updatesalarytingId(Integer id);
}
