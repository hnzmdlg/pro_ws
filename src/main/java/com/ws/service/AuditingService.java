package com.ws.service;


import com.ws.bean.Xinwen;

import java.util.List;

public interface AuditingService {
    List<Xinwen> auditingId();

    void updateauditingId(Integer id);
}
