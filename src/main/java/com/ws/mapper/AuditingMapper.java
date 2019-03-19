package com.ws.mapper;

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
}
