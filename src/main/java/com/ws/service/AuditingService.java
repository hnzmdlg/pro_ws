package com.ws.service;


import com.ws.bean.Salary;
import com.ws.bean.Seek;
import com.ws.bean.Xinwen;

import java.util.List;

public interface AuditingService {
    List<Xinwen> auditingId();

    void updateauditingId(Integer id);

    List<Salary> salarytingId();

    void updatesalarytingId(Integer id);

    List<Seek> tosqeekid();

    void updateseek(Integer id);
}
