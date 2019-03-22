package com.ws.service.impl;

import com.ws.bean.Catalog;
import com.ws.bean.Section;
import com.ws.mapper.SectionMapper;
import com.ws.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionMapper sectionMapper;

    @Override
    public List<Catalog> querySection(Integer id) {
        if(id==-1){
            return sectionMapper.querySection();
        }else{
            return sectionMapper.querySection2(id);
        }
    }

    @Override
    public List<Section> querySectionNode(Integer kid) {
        List<Section> list = sectionMapper.querySectionNode(kid);
        sectionMapper.updateSectionNode(kid);
        return list;
    }
}
