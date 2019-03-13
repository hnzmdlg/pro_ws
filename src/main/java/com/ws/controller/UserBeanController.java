package com.ws.controller;

import com.ws.bean.Dept;
import com.ws.bean.Role;
import com.ws.bean.UserBean;
import com.ws.service.UserBeanService;
import com.ws.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ws.utils.OSSClientConstants.BACKET_NAME;
import static com.ws.utils.OSSClientConstants.FOLDER;

@Controller
public class UserBeanController {



    @Autowired
    private UserBeanService userBeanService;


        @RequestMapping("domeOss")
        public String domeOss() {

            return "ossdome";

        }

    //查询用户表
    @RequestMapping("queryUserBean")
    @ResponseBody
    public HashMap<String,Object> queryUserBean(int page, int rows, UserBean userBean){


        return userBeanService.queryUserBean(page,rows,userBean);
    }

    //修改进入后的 用户密码
    @RequestMapping("updatpwd")
    @ResponseBody
    public  void  updatPwd(UserBean userBean, HttpSession session){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        userBean.setUid(uid);
        userBeanService.updatPwd(userBean);
    }

    //查询角色
    @RequestMapping("queryUserRole")
    @ResponseBody
    public List<Role> queryUserRole(){
        return userBeanService.queryUserRole();
    }

    //查询部门
    @RequestMapping("queryUserDeptid")
    @ResponseBody
    public List<Dept> queryUserDeptid(){
        return userBeanService.queryUserDeptid();
    }



    //上传图片
    @RequestMapping("uploadImg")
    @ResponseBody
    public String upload(HttpServletRequest request, @RequestParam(value="picFile",required=false) MultipartFile picFile) {
        String path = null;
        try {
            path = FileUtil.FileUpload(picFile, request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(path.contains("null")) {
            return null;
        }else {
            System.out.println(path);


            return path;

        }
    }


    @RequestMapping(value = "/headImgUpload.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> headImgUpload(HttpServletRequest request, MultipartFile file) throws IOException {
        Map<String, Object> value = new HashMap<String, Object>();
        value.put("success", true);
        value.put("errorCode", 0);
        value.put("errorMsg", "");
        String head = userBeanService.updateHead(file, 4);//此处是调用上传服务接口，4是需要更新的userId 测试数据。
        System.out.println(head);
        value.put("data", head);
        return value;
    }



    //修改 ： 新增
    @RequestMapping("addUser")
    @ResponseBody
    public void  addAnswer(UserBean userbean){

        Integer id = userbean.getId();
        if (id!=null){
            //修改

            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            userbean.setRegistration_date(sdf.format(data));
            userBeanService.updateUserBean(userbean);
        }else {
            //新增

            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            userbean.setRegistration_date(sdf.format(data));
            userBeanService.addUserBean(userbean);
        }

    }

    //修改回显
    @RequestMapping("queryUserById")
    @ResponseBody
    public UserBean queryEvaluateById(Integer id){

        UserBean  userbean   = userBeanService.queryUserById(id);
        return userbean;
    }


    //批量删除
    @RequestMapping("deleteUserAll")
    @ResponseBody
    public  void  deleteUserAll(String id){
        userBeanService.deleteAll(id);
    }

}
