<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/14
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入easyui样式文件 -->
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5/themes/default/easyui.css">
    <!-- 引入easyui图标样式文件 -->
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5/themes/icon.css">
    <!-- 引入jquery js文件 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/jquery.min.js"></script>
    <!-- 引入easyui的js文件 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/jquery.easyui.min.js"></script>
    <!-- 引文easyui支持中文js -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
    <!-- 引入uploadify css js文件 -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/js/uploadify/uploadify.css">
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/uploadify/jquery.uploadify.min.js"></script>
    <!-- 引入kindeditor css js文件 -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/js/kindeditor-4.1.10/themes/default/default.css" />
    <script src="<%=request.getContextPath() %>/js/kindeditor-4.1.10/kindeditor-all.js"></script>
</head>
<body>

<!-- 定义表格 -->
<table id="myTable">
</table>


</body>
<script type="text/javascript">
    $(function(){
        queryTrain();
    })

    function queryTrain(){
        $("#myTable").datagrid({
            url:"<%=request.getContextPath()%>/queryTrain",
            columns:[[{field:'check',checkbox:true},
                {field:'id',title:'编号'},
                {field:'name',title:'姓名'},
                {field:'sex',title:'性别',width:80,formatter:function(value,row,index){
                        if(value==1){
                            return "男";
                        }else{
                            return "女";
                        }
                    }},
                {field:'phone',title:'手机号码',width:100},
                {field:'qq',title:'QQ号',width:100},
                {field:'vx',title:'微信号',width:100},
                {field:'xl',title:'学历',width:80,formatter:function(value,row,index){
                        if(value==1){
                            return "小学";
                        }else if(value==2){
                            return "初中";
                        }else if(value==3){
                            return "高中";
                        }else if(value==4){
                            return "本科";
                        }else if(value==5){
                            return "研究生";
                        }else if(value==6){
                            return "博士";
                        }else if(value==7){
                            return "海外留学";
                        }else if(value==8){
                            return "无业游民";
                        }else if(value==9){
                            return "其他";
                        }
                    }},
                {field:'outdate',title:'毕业时间',width:100},
                {field:'money',title:'当前薪资',width:100},
                {field:'dqzt',title:'当前状态',width:80,formatter:function(value,row,index){
                        if(value==1){
                            return "在读";
                        }else if(value==2){
                            return "在实习";
                        }else if(value==3){
                            return "刚毕业";
                        }else if(value==4){
                            return "有一年以内工作经验";
                        }else if(value==5){
                            return "有二年以内工作经验";
                        }else if(value==6){
                            return "有三年以内工作经验";
                        }else if(value==7){
                            return "其他";
                        }
                    }},
                {field:'tools',title:'操作',width:100,align:'center',formatter:function(value,row,index){
                        /*var str = "<input type='button' value='修改密码' onClick='updatepass("+row.id+")'>";
                        return str;*/
                    }}
            ]],
            pagination:true,// 首先.开启分页
            pageList:[10,20,30,40,70,80],//初始化页面大小选择列表
            pageSize:10, //初始化每页显示条数，默认是10
            fit:true,
        })

    }


</script>
</html>
