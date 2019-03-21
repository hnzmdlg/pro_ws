package com.ws.service.impl;

import com.ws.bean.Salary;
import com.ws.bean.Xinwen;
import com.ws.mapper.AuditingMapper;
import com.ws.service.AuditingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditingServiceImpl implements AuditingService {

    @Autowired
    private AuditingMapper auditingMapper;

    @Override
    public List<Xinwen> auditingId() {
        return auditingMapper.auditingId();
    }

    @Override
    public void updateauditingId(Integer id) {
        auditingMapper.updateauditingId(id);
    }

    @Override
    public List<Salary> salarytingId() {
        return auditingMapper.salarytingId();
    }

    @Override
    public void updatesalarytingId(Integer id) {
        auditingMapper.updatesalarytingId(id);
    }


}
