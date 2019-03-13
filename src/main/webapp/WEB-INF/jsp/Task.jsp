<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
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

<div id="searchDivk">

    <a href="javascript:openDig()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">发起任务</a>

</div>

<!-- 定义表格 -->
<table id="myTablek"> </table>
<!-- 定义新增表格 -->
<div id="myDialog" class="easyui-dialog" style="width:500px;height:400px" data-options="modal:true,maximizable:true,resizable:true,buttons:'#myButton',closed:true,iconCls:'icon-save'">
    <form id="myForm" method="post">
        <input style="display:none" name="id">
        <table>

            <tr>
                <td>指定任务人</td>
                <td>
                    <input class="easyui-combobox" name="uid" id="roleId">
                </td>
            </tr>

            <tr>
                <td>任务内容</td>
                <td>
                    <input class="easyui-textbox" name="neirong">
                </td>
            </tr>

        </table>


    </form>

</div>

<!-- 定义按钮 -->
<div id="myButton">
    <a href="javascript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
    <a href="javascript:closeDig()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
</div>


</body>
<script>

    //查询角色
    function initRole(){
        $("#roleId").combobox({
            url:"<%=request.getContextPath() %>/queryTaskRole",
            valueField:"uid",
            textField:"name",
            multiple:true
        })


    }


    //新增
    function add(){
        $("#myForm").form("submit",{
            url:"<%=request.getContextPath() %>/addTask",
            success:function(){
                $.messager.alert("提示","保存成功","info")
                //关闭弹框
                $("#myDialog").dialog("close")
                //关闭
                closeDig()
                //刷新
                $("#myTablek").datagrid("load")

            }

        })

    }
    //打开对话框
    function openDig() {
        //重置表单
        $("#myForm").form("reset");
        //清除图片隐藏域
        $("#hideImg").val("");
        //清除图片
        $("#mypic").prop("src", "");
        //清空富文本框
        //editor.html("");

        initRole()
        //打开
        $("#myDialog").dialog({
            title:'新增用户',
            closed:false

        })

    }
    //关闭对话框
    function closeDig(){
        $("#myDialog").dialog("close")

    }


    $("#myTablek").datagrid({
        url:"<%=request.getContextPath()%>/queryTask",
        columns:[[
            {field:'check',checkbox:true},
            {field:'id',title:'编号',width:100,align:'center'},
            {field:'uname',title:'执行任务人',width:100,align:'center'},
            {field:'neirong',title:'任务内容',width:100,align:'center'},
            {field:'rdate',title:'发起任务时间',width:100,align:'center'},
            {field:'rtype',title:'性别',width:100,align:'center',formatter:function(value,row,index){
                    if(value==1){
                        return "完成";
                    }else{
                        return "未完成";
                    }
                }},


        ]],
        pagination:true,//开启分页
        pageList:[1,2,3,4,5,6], //初始化页面大小选择列表
        pageSize:3 , //初始化每页显示条数，默认是10
        pageNumber:1, //当前页,默认是1
        fit:true,
        toolbar:"#searchDiv",
        pagePosition:"top"
    })




</script>
</html>
