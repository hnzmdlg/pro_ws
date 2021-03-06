<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/15
  Time: 10:43
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
        queryMulu();
    })

    function queryMulu(){
        $("#myTable").datagrid({
            url:"<%=request.getContextPath()%>/queryMulus",
            columns:[[{field:'check',checkbox:true},
                {field:'mid',title:'编号'},
                {field:'mname',title:'目录名称'},
                {field:'creadate',title:'创建时间',width:100},
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
