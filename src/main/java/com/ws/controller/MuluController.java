package com.ws.controller;

import com.ws.bean.Interview;
import com.ws.bean.Mulu;
import com.ws.bean.Train;
import com.ws.service.MuluService;
import com.ws.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class MuluController {

    @Autowired
    private MuluService muluService;

    // 分页查询目录
    @RequestMapping("queryMulus")
    @ResponseBody
    public HashMap<String,Object> queryMulu(int page, int rows, Mulu mulu){
        return muluService.queryMulu(page,rows,mulu);
    }

    // 前台查询目录
    @RequestMapping("showmulu")
    @ResponseBody
    public List<Mulu> showmulu(Mulu mulu){
        return muluService.showmulu(mulu);
    }

    //查询调差目录
    @RequestMapping("querymuluok")
    @ResponseBody
    public List<Interview> querymuluok(HttpSession session){
        Integer id = (Integer)session.getAttribute("mid");
        return muluService.querymuluok(id);
    }

    //查询打开详细数据
    @RequestMapping("addSessionOpenmuluuuu")
    @ResponseBody
    public Interview addSessionOpenmuluuuu(HttpSession session){
        Integer id = (Integer)session.getAttribute("mid");
        return muluService.addSessionOpenmuluuuu(id);
    }

}
