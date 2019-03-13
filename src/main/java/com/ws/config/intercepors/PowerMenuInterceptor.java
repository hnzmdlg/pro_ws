package com.ws.config.intercepors;


import com.ws.bean.UserBean;
import com.ws.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class PowerMenuInterceptor implements HandlerInterceptor {



    @Autowired
    private UserBeanService userBeanService;

    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //这里的User是登陆时放入session的
        HttpSession session = request.getSession();
    //这里的User是登陆时放入session的
        UserBean user = (UserBean) session.getAttribute("user");
        //获取id
        Integer id = user.getId();
        List<String> urlList = userBeanService.queryPowerMenuByUserid(id);

        //比较
        //获取当前请求的路径
        String requestURI = request.getRequestURI();

        for (String url : urlList) {
            if (requestURI.contains(url)) {
                return true;
            }
        }


        request.getRequestDispatcher("/nopower.jsp").forward(request, response);

        return false;
    }


}
