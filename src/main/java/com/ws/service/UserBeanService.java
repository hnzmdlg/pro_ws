package com.ws.service;

import com.ws.bean.Dept;
import com.ws.bean.Role;
import com.ws.bean.UserBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface UserBeanService {
    HashMap<String,Object> queryUserBean(int page, int rows, UserBean userBean);

    void updatPwd(UserBean userBean);

    List<String> queryPowerMenuByUserid(Integer id);

    List<Role> queryUserRole();

    List<Dept> queryUserDeptid();

    void updateUserBean(UserBean userbean);

    void addUserBean(UserBean userbean);

    UserBean queryUserById(Integer id);

    void deleteAll(String id);

    String updateHead(MultipartFile file, int i);
}
