package com.ws.service.impl;

import com.ws.bean.PowerMenu;
import com.ws.bean.Tree;
import com.ws.bean.UserBean;
import com.ws.mapper.TreeMapper;
import com.ws.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl  implements TreeService {

    @Autowired
    private TreeMapper treeMapper;
//查询树


    @Override
    public List<Tree> queryTree(Integer uid,Tree tree) {
        return treeMapper.queryTree(uid,tree);
    }

    @Override
    public List<Tree> queryTree2(Integer uid,Tree tree) {
        return treeMapper.queryTree2(uid,tree);
    }

    @Override
    public List<Tree> queryTree3(Integer uid,Tree tree) {
        return treeMapper.queryTree3(uid,tree);
    }

    @Override
    public List<Tree> queryTree4(Integer uid,Tree tree) {
        return treeMapper.queryTree4(uid,tree);
    }


    @Override
    public List<Tree> queryTree5(Integer uid,Tree tree) {
        return treeMapper.queryTree5(uid,tree);
    }

    @Override
    public List<Tree> queryTree6(Integer uid,Tree tree) {
        return treeMapper.queryTree6(uid,tree);
    }

    @Override
    public List<Tree> queryTree7(Integer uid, Tree tree) {
        return treeMapper.queryTree7(uid,tree);
    }


    @Override
    public List<Tree> queryTree8(Integer uid,Tree tree) {
        return treeMapper.queryTree8(uid,tree);
    }

    @Override
    public List<Tree> queryTree9(Integer uid,Tree tree) {
        return treeMapper.queryTree9(uid,tree);
    }

    @Override
    public List<Tree> queryTree10(Integer uid,Tree tree) {return treeMapper.queryTree10(uid,tree); }




    //登陆
    @Override
    public UserBean queryUserByLoginNumber(String username) {
        return treeMapper.queryUserByLoginNumber(username);
    }
    //查询中间树
    @Override
    public List<Tree> authTree2(String id) {

        List<Tree>  RoleId = treeMapper.queryByRoleId(id);

        List<Tree> list = treeMapper.authTree2();
        for (Tree tree :list) {
            for ( Tree role: RoleId) {
                if (tree.getId()==role.getId()){
                    tree.setChecked(true);
                }
            }
        }

        return list;
    }
    //新增权限列表
    @Override
    public void saveRolePower(Integer roleId, String powerIds) {

        // 新增前删除 新增重复的
        treeMapper.deleteRolePowerById(roleId);
        //新增权限列表
        String[] split = powerIds.split(",");

        for (int i=0;i<split.length;i++){
            treeMapper.saveRolePower(roleId,split[i]);
        }
    }

    @Override
    public List<PowerMenu> querypowerMenu(String powerId) {

        return treeMapper.querypowerMenu(powerId);
    }

    //新权限详情
    @Override
    public String savePowerMenu(PowerMenu powerMenu) {
        return treeMapper.savePowerMenu(powerMenu);
    }


    //删除权限
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            treeMapper.deleteAll(sid[i]);
        }
    }




}
