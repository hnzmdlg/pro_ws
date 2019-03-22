package com.ws.service;

import com.ws.bean.Catalog;
import com.ws.bean.Section;

import java.util.List;

public interface SectionService {
    List<Catalog> querySection(Integer id);

    List<Section> querySectionNode(Integer kid);
}
