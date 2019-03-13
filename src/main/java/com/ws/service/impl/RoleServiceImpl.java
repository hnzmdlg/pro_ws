package com.ws.service.impl;

import com.ws.bean.Role;
import com.ws.mapper.RoleMapper;
import com.ws.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRole() {
        return roleMapper.queryRole();
    }


    //删除
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++) {
            roleMapper.deleteAll(sid[i]);
        }
    }

    //修改
    @Override
    public void updateRole(Role role) {

    }

    //新增
    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }
}
