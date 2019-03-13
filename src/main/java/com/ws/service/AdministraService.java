package com.ws.service;

import com.ws.bean.Administration;

import java.util.HashMap;
import java.util.List;

public interface AdministraService {
    HashMap<String, Object> queryAdministra(int page, int rows, Administration administration);

    List<Administration> queryAdmini();

    void addAdministration(Administration administration);
}
