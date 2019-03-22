package com.ws.mapper;

import com.ws.bean.Seek;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SeekMapper {

    @Select("select count(*) from t_seek where  ttid=1")
    long queryTotal(Seek seek);

    @Select("select * from t_seek where  ttid=1 LIMIT #{start},#{rows}")
    List<Seek> queryPageProblem(int start, int rows, Seek seek);

    //修改
    @Update("UPDATE t_seek set name=#{name},url=#{url} where id=#{id}")
    void updateAnswer(Seek seek);

    //新增
    @Insert("INSERT INTO t_seek(name,url,ttid) VALUES(#{name},#{url},0)")
    void addAnswer(Seek seek);

    //删除
    @Delete("delete from t_seek where id=#{s}")
    void seekAll(String id);

    //回显
    @Select("SELECT * FROM t_seek  where id=#{id}")
    Seek querySeekById(Integer id);

    @Select("select * from t_seek ")
    List<Seek> seektlot();
}
