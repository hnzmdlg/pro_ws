package com.ws.service;

import com.ws.bean.Role;

import java.util.List;

public interface RoleService  {
    List<Role> queryRole();

    void deleteAll(String id);

    void updateRole(Role role);

    void addRole(Role role);
}
