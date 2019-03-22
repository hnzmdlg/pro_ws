package com.ws.mapper;

import com.ws.bean.Catalog;
import com.ws.bean.Section;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SectionMapper {

    @Select("select * from t_catalog")
    List<Catalog> querySection();

    @Select("select tc.* from t_catalog tc,t_kecheng tk where tc.kid = tk.id and tk.id = #{id}")
    List<Catalog> querySection2(Integer id);

    @Select("select ts.zid,ts.zname,GROUP_CONCAT(tn.sname) sname,GROUP_CONCAT(tn.type) type \n" +
            "from t_section ts,t_node tn \n" +
            "where ts.zid = tn.zid\n" +
            "and ts.mid = #{kid}\n" +
            "group by ts.zid")
    List<Section> querySectionNode(Integer kid);

    @Update("update t_catalog set lls = lls+1 where id = #{kid}")
    void updateSectionNode(Integer kid);
}
