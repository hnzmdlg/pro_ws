package com.ws.controller;

import com.ws.bean.PowerMenu;
import com.ws.bean.Tree;
import com.ws.bean.UserBean;
import com.ws.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class TreeController {

    @Autowired
    private TreeService treeService;

    //用户树
    @RequestMapping("authTree")
    @ResponseBody
    public List<Tree> queryTree(HttpSession session,Tree tree){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return treeService.queryTree(uid,tree);
    }

    //课程树


    @RequestMapping("queryTree2")
    @ResponseBody
    public List<Tree> queryTree2(HttpSession session,Tree tree){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return treeService.queryTree2(uid,tree);
    }

    //报表树
    @RequestMapping("reportTree")
    @ResponseBody
    public List<Tree> reportTree(HttpSession session,Tree tree){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return treeService.queryTree3(uid,tree);
    }

    //日志树
    @RequestMapping("journalTree")
    @ResponseBody
    public List<Tree> journalTree(HttpSession session,Tree tree){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return treeService.queryTree4(uid,tree);
    }

    //广告树
    @RequestMapping("advTree")
    @ResponseBody
    public List<Tree> advTree(HttpSession session,Tree tree){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return treeService.queryTree5(uid,tree);
    }

    //新闻树
    @RequestMapping("xwTree")
    @ResponseBody
    public List<Tree> xwTree(HttpSession session,Tree tree){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return treeService.queryTree6(uid,tree);
    }

    //会员树
    @RequestMapping("vipTree")
    @ResponseBody
    public List<Tree> vipTree(HttpSession session,Tree tree){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return treeService.queryTree7(uid,tree);
    }

    //审核树
    @RequestMapping("examineTree")
    @ResponseBody
    public List<Tree> examineTree(HttpSession session,Tree tree){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return treeService.queryTree8(uid,tree);
    }

    //任务树
    @RequestMapping("taskTree")
    @ResponseBody
    public List<Tree> taskTree(HttpSession session,Tree tree){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return treeService.queryTree9(uid,tree);
    }

    //投诉树
    @RequestMapping("complaintTree")
    @ResponseBody
    public List<Tree> complaintTree(HttpSession session,Tree tree){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return treeService.queryTree10(uid,tree);
    }

    //登陆 queryLogin
    //登录
    @RequestMapping("login")
    @ResponseBody
    public String login(UserBean user, String valCode, HttpSession session){

        UserBean user2 = treeService.queryUserByLoginNumber(user.getUsername());
        if(user2==null){
            return "2";
        }
        //验证密码
        if(!user.getUserpwd().equals(user2.getUserpwd())){
            return "3";
        }
        session.setAttribute("user", user2);//user与注销登录的session一样
        return "登陆成功";
    }

    //注销
    @RequestMapping("clearUser")
    public void clearUser(HttpSession session, HttpServletResponse response) throws IOException {
        session.removeAttribute("user");
        response.sendRedirect("/login.jsp");
    }

    //查询中间表的树
    @RequestMapping("authTree2")
    @ResponseBody
    public  List<Tree>  authTree2(String id){
        return treeService.authTree2(id);
    }


    //赋权限
    @RequestMapping("saveRolePower")
    @ResponseBody
    public  void  saveRolePower(Integer roleId,String powerIds){
        treeService.saveRolePower(roleId,powerIds);
    }

    //查询 权限详情
    @ResponseBody
    @RequestMapping("querypowerMenu")
    public  List<PowerMenu> querypowerMenu(String powerId){

        return treeService.querypowerMenu(powerId);
    }

    //新增
    @ResponseBody
    @RequestMapping("savePowerMenu")
    public  String savePowerMenu(PowerMenu powerMenu){

        return treeService.savePowerMenu(powerMenu);
    }

    //删除权限
    //批量删除
    @RequestMapping("deletePowerMenuAll")
    @ResponseBody
    public  void  deleteAll(String id){
        treeService.deleteAll(id);
    }
}
