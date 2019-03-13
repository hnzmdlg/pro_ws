package com.ws.service.impl;


import com.ws.bean.Dept;
import com.ws.bean.Role;
import com.ws.bean.UserBean;
import com.ws.mapper.UserBeanMappper;
import com.ws.service.UserBeanService;
import com.ws.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@Service
public class UserBeanServiceImpl implements UserBeanService {

    @Autowired
    private UserBeanMappper userBeanMappper;


    @Autowired
    private OSSClientUtil ossClient;

    //查询员工
    @Override
    public HashMap<String, Object> queryUserBean(int page, int rows, UserBean userBean) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        long total = userBeanMappper.queryTotal(userBean);
        //分页查询用户信息
        //计算开始位置   每页：3   第2页   456
        int start = (page-1)*rows;//3
        //计算结束位置
        int end = start + rows;//6
        List<UserBean> list = userBeanMappper.queryPage(start,rows,userBean);
        hashMap.put("total", total);//总条数
        hashMap.put("rows", list);//list集合
        return hashMap;
    }



    //查看用户拥有的权限
    @Override
    public List<String> queryPowerMenuByUserid(Integer id) {
        return userBeanMappper.queryPowerMenuByUserid(id);
    }


    //登录后修改 密码
    @Override
    public void updatPwd(UserBean userBean) {
        userBeanMappper.updatPwd(userBean);
    }


//查询角色
    @Override
    public List<Role> queryUserRole() {
        return userBeanMappper.queryUserRole();
    }
//查询部门
    @Override
    public List<Dept> queryUserDeptid() {
        return userBeanMappper.queryUserDeptid();
    }

    //修改
    @Override
    public void updateUserBean(UserBean userbean) {
        userBeanMappper.updateUserBean(userbean);
    }
//新增
    @Override
    public void addUserBean(UserBean userbean) {
        userBeanMappper.addUserBean(userbean);
    }
//修改回显
    @Override
    public UserBean queryUserById(Integer id) {
        return userBeanMappper.queryUserById(id);
    }
//删除
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            userBeanMappper.deleteAll(sid[i]);
        }
    }

    //测试 传图
    @Override
    public String updateHead(MultipartFile file, int i) {
        if (file == null || file.getSize() <= 0) {
            System.out.println("头像不能为空");
        }
        String name = ossClient.uploadImg2Oss(file);

        String imgUrl = ossClient.getImgUrl(name);

        return imgUrl;
    }

}
