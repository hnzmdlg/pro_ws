package com.ws.service;

import com.ws.bean.WebUser;

import java.util.HashMap;

public interface WebUserService {
    HashMap<String, Object> queryWebUser(int page, int rows, WebUser webuser);

    WebUser queryWebUserById(Integer id);

    void updateWebUser(WebUser webuser);

    void addWebUser(WebUser webuser);

    void deleteAll(String id);

    HashMap<String, Object> queryWebUserWei(int page, int rows, WebUser webuser);

    void updateWebUserId(Integer id);

    WebUser queryWebUserTtid(Integer id);
}
