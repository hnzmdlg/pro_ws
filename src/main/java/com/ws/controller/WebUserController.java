package com.ws.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ws.bean.WebUser;
import com.ws.service.WebUserService;
import com.ws.utils.CommonCanstant;
import com.ws.utils.HttpClientUtil;
import com.ws.utils.MD5Util;
import com.ws.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
public class WebUserController {

    @Autowired
    private WebUserService webUserService;



    //查询用户表
    @RequestMapping("queryWebUser")
    @ResponseBody
    public HashMap<String,Object> queryCatalog(int page, int rows, WebUser webuser){

        HashMap<String,Object> list = webUserService.queryWebUser(page,rows, webuser);

        return list;
    }



    //修改回显
    @RequestMapping("queryWebUserById")
    @ResponseBody
    public WebUser queryWebUserById(Integer id){

        WebUser  webUser   = webUserService.queryWebUserById(id);
        return webUser;
    }



    //修改 ： 新增
    @RequestMapping("addWebUser")
    @ResponseBody
    public void  addAnswer(WebUser webuser){

        Integer id = webuser.getId();
        if (id!=null){
            //修改
            webUserService.updateWebUser(webuser);
        }else {
            //新增
            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            webuser.setExpiredate(sdf.format(data));

            webUserService.addWebUser(webuser);
        }

    }



    //批量删除
    @RequestMapping("deleteWebUserAll")
    @ResponseBody
    public  void  deleteCatalogAll(String id){
        webUserService.deleteAll(id);
    }



    //查询未审核用户表
    @RequestMapping("queryWebUserWei")
    @ResponseBody
    public HashMap<String, Object> queryWebUserWei(int page, int rows, WebUser webuser) {
        HashMap<String, Object> list = webUserService.queryWebUserWei(page, rows, webuser);

        return list;
    }

    //审核通过
    @RequestMapping("updateWebUserId")
    @ResponseBody
    public String updateWebUserId(Integer id) {
        webUserService.updateWebUserId(id);

        //验证通过审核了吗
        WebUser webUser = webUserService.queryWebUserTtid(id);
        //通过后发送短信提醒
        if (webUser.getTtid() == 1) {
            String url = CommonCanstant.SEND_MSG_URL;
            HashMap<String, Object> params = new HashMap<>();
            params.put("accountSid", CommonCanstant.SEND_MSG_ACCOUNT_ID);//开发者主账号ID
            params.put("to", webUser.getPhone());//短信接收端手机号码集合
            String time = TimeUtil.format(new Date());
            params.put("timestamp", time);//时间戳
            String sigStr = CommonCanstant.SEND_MSG_ACCOUNT_ID + CommonCanstant.SEND_MSG_TOKEN + time;
            params.put("sig", MD5Util.getMD5(sigStr));//签名。MD5(ACCOUNT SID + AUTH TOKEN + timestamp)。共32位（小写）
            params.put("templateid", "1119802013");//短信模板ID
            // long str = Math.round(Math.random() * 89999 + 10000);
            String str = ":提交用户新增审核通过";
            params.put("param", str + ",1");//短信模板ID
            String respData = HttpClientUtil.post(url, params);
            JSONObject parseObject = JSON.parseObject(respData);
            String string = parseObject.getString("respCode");
            System.out.println(respData);
            if (!"00000".equals(string)) {
                return "验证码发送失败";

            }
        }
        return "验证码发送成功";
    }

}
