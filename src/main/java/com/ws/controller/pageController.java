package com.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {

    @RequestMapping("log")
    public  String  log(){

        return "Log";
    }


    @RequestMapping("index")
    public  String  main(){

        return "index";
    }

    @RequestMapping("lunbo")
    public  String  lunbo(){

        return "lunbo2";
    }

    @RequestMapping("userlist")
    public  String  userlist(){

        return "show";
    }

    @RequestMapping("rolepower")
    public  String  rolepower(){

        return "rolepower";
    }

    @RequestMapping("updatePwd")
    public  String  updatePwd(){

        return "updatePwd";
    }


    @RequestMapping("pingjia")
    public  String  pingjia(){

        return "pingjia";
    }


    @RequestMapping("problem")
    public  String  problem(){

        return "pro";
    }

    @RequestMapping("answer")
    public  String  answer(){

        return "answer";
    }


    @RequestMapping("kecheng")
    public  String  kecheng(){

        return "kecheng";
    }

    @RequestMapping("catalog")
    public  String  catalog(){

        return "catalog";
    }

    @RequestMapping("webuser")
    public  String  webuser(){

        return "webuser";
    }


    @RequestMapping("ecahers")
    public  String  ecahers(){

        return "ecahers";
    }


    @RequestMapping("advertisement")
    public  String  advertisement(){

        return "advertisement";
    }

    @RequestMapping("administration")
    public  String  administration(){

        return "Administration";
    }


    @RequestMapping("exeList")
    public  String  exeList(){

        return "exeList";
    }

    @RequestMapping("kechengshen")
    public  String  kechengshen(){

        return "kechengshen";
    }

    @RequestMapping("webusertt")
    public  String  webusertt(){

        return "webusertt";
    }

    @RequestMapping("Task")
    public  String  Task(){

        return "Task";
    }


    @RequestMapping("woTask")
    public  String  woTask(){

        return "woTask";
    }


    @RequestMapping("weiTask")
    public  String  weiTask(){

        return "weiTask";
    }
    @RequestMapping("section")
    public  String  section(){

        return "section";
    }
    @RequestMapping("node")
    public  String  node(){

        return "node";
    }

    @RequestMapping("train")
    public  String  train(){

        return "train";
    }

    @RequestMapping("mulu")
    public  String  mulu(){

        return "mulu";
    }

    @RequestMapping("interview")
    public  String  interview(){

        return "interview";
    }

    @RequestMapping("answerr")
    public  String  answerr(){

        return "answerr";
    }


    //跳转新闻审核
    @RequestMapping("toauditing")
    public  String  toauditing(){

        return "Auditing";
    }

    //跳转薪资
    @RequestMapping("salary")
    public  String  salary(){

        return "Salary";
    }

    //跳转薪资
    @RequestMapping("toseek")
    public  String  toseek(){

        return "Seek";
    }

    //跳转学员审核
    @RequestMapping("salaryting")
    public  String  salaryting(){

        return "salaryList";
    }
    //跳转咨询审核
    @RequestMapping("toseekList")
    public  String  toseekList(){

        return "seekList";
    }
}
