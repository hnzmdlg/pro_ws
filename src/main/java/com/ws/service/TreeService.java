package com.ws.service;

import com.ws.bean.PowerMenu;
import com.ws.bean.Tree;
import com.ws.bean.UserBean;

import java.util.List;

public interface TreeService {



    List<Tree> queryTree(Integer uid,Tree tree);

    List<Tree> queryTree2(Integer uid,Tree tree);

    List<Tree> queryTree3(Integer uid,Tree tree);

    List<Tree> queryTree4(Integer uid,Tree tree);

    List<Tree> queryTree5(Integer uid,Tree tree);


    List<Tree> queryTree6(Integer uid,Tree tree);


    List<Tree> queryTree7(Integer uid, Tree tree);


    List<Tree> queryTree8(Integer uid,Tree tree);

    List<Tree> queryTree9(Integer uid,Tree tree);

    List<Tree> queryTree10(Integer uid,Tree tree);




    UserBean queryUserByLoginNumber(String username);


    List<Tree> authTree2(String id);

    void saveRolePower(Integer roleId, String powerIds);

    List<PowerMenu> querypowerMenu(String powerId);

    String savePowerMenu(PowerMenu powerMenu);

    void deleteAll(String id);


}
