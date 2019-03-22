package com.ws.mapper;


import com.ws.bean.Catalog;
import com.ws.bean.Kecheng;
import com.ws.bean.Node;
import com.ws.bean.Section;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CatalogMaper {
    //查询总条数
    //@Select("select count(*)  FROM t_catalog c LEFT JOIN t_kecheng k on  c.kid=k.id")
    @Select("<script>"
            + "select count(*) FROM t_catalog c LEFT JOIN t_kecheng k on  c.kid=k.id "
            + "WHERE 1=1"
            + "<if test='catalog.mlname!=null'>"
            + "and c.mlname like '%${catalog.mlname}%'"
            + "</if>"
            + "</script>")
    long queryTota(@Param("catalog") Catalog catalog);

    //查询
    //@Select("SELECT * FROM t_catalog c LEFT JOIN t_kecheng k on  c.kid=k.id  LIMIT #{start},#{rows}")
    @Select("<script>"
            + "SELECT * FROM t_catalog c LEFT JOIN t_kecheng k on  c.kid=k.id "
            + "WHERE 1=1"
            + "<if test='catalog.mlname!=null'>"
            + "and c.mlname like '%${catalog.mlname}%'"
            + "</if>"
            + "LIMIT #{start},#{rows}"
            + "</script>")
    List<Catalog> queryPageCatalog(@Param("start") int start, @Param("rows") int rows, @Param("catalog") Catalog catalog);


    //查询角色
    @Select("SELECT k.id ,k.kname from t_kecheng k")
    List<Kecheng> queryRole();


    //新增
    @Insert("INSERT into t_catalog(mlname,kid) VALUES(#{mlname},#{kid})")
    void addCatalog(Catalog catalog);


    //修改回显
    @Select("select c.*,k.kname from t_catalog c LEFT JOIN t_kecheng k on k.id=c.kid where c.id=#{id}")
    Catalog queryEvaluateById(Integer id);

    //修改
    @Update("UPDATE t_catalog c SET c.mlname=#{mlname} ,c.kid=#{kid} where c.id=#{id}")
    void updateCatalog(Catalog catalog);

    @Delete("delete from t_catalog where id=#{s}")
    void deleteAll(String s);


    //查询总条数
    //@Select("select count(*)  FROM t_catalog c LEFT JOIN t_kecheng k on  c.kid=k.id")
    @Select("<script>"
            + "select count(*) FROM t_section s LEFT JOIN t_catalog t on t.id = s.mid "
            + "WHERE 1=1"
            + "<if test='section.zname!=null'>"
            + "</if>"
            + "</script>")
    long queryTota2(@Param("section") Section section);

    //查询
    //@Select("SELECT * FROM t_catalog c LEFT JOIN t_kecheng k on  c.kid=k.id  LIMIT #{start},#{rows}")
    @Select("<script>"
            + "select * from t_section s LEFT JOIN t_catalog t on t.id = s.mid "
            + "where 1=1"
            + "<if test='section.zname!=null'>"
            + "and s.zname like '%${section.zname}%'"
            + "</if>"
            + "LIMIT #{start},#{rows}"
            + "</script>")
    List<Section> queryPageCatalog2(@Param("start") int start, @Param("rows") int rows, @Param("section") Section section);

    @Select("SELECT k.id ,k.mlname from t_catalog k")
    List<Catalog> queryMulu();

    @Select("select s.*,t.mlname from t_section s LEFT JOIN t_catalog t on t.id = s.mid where s.zid=#{id}")
    Section querySectionById(Integer id);

    @Update("UPDATE t_section s SET s.zname=#{zname} ,s.mid=#{mid} where s.zid=#{zid}")
    void updateSection(Section section);

    @Insert("INSERT into t_section(zname,mid) VALUES(#{zname},#{mid})")
    void addSection(Section section);

    @Delete("delete from t_section where zid=#{s}")
    void deleteSectionAll(String s);


    //查询总条数
    //@Select("select count(*)  FROM t_catalog c LEFT JOIN t_kecheng k on  c.kid=k.id")
    @Select("<script>"
            + "select count(*) from t_node n LEFT JOIN t_section s on n.zid=s.zid "
            + "WHERE 1=1"
            + "<if test='node.sname!=null'>"
            + "</if>"
            + "</script>")
    long queryTota3(@Param("node")Node node);

    //查询
    //@Select("SELECT * FROM t_catalog c LEFT JOIN t_kecheng k on  c.kid=k.id  LIMIT #{start},#{rows}")
    @Select("<script>"
            + "select n.*,s.zname from t_node n LEFT JOIN t_section s on n.zid=s.zid "
            + "where 1=1"
            + "<if test='node.sname!=null'>"
            + "and n.sname like '%${node.sname}%'"
            + "</if>"
            + "LIMIT #{start},#{rows}"
            + "</script>")
    List<Node> queryPageCatalog3(@Param("start") int start, @Param("rows") int rows, @Param("node") Node node);
    @Select("SELECT * from t_section s")
    List<Section> querySections();



    @Update("UPDATE t_node n SET n.sname=#{sname},n.zid=#{zid},n.type=#{type} where n.sid=#{sid}")
    void updateNode(Node node);

    @Insert("INSERT into t_node(sname,sid) VALUES(#{sname},#{sid})")
    void addNode(Node node);
    @Delete("delete from t_node where sid=#{s}")
    void deleteNodeAll(String s);

    @Select("select n.*,s.zname from t_node n LEFT JOIN t_section s on n.zid=s.zid where n.sid=#{id}")
    Node queryNodeById(Integer id);
}
