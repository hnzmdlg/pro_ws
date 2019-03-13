<%--
  Created by IntelliJ IDEA.
  User: 64188
  Date: 2019/1/26
  Time: 17:20
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
<div id="myDialog"  style="width:500px;height:400px" data-options="buttons:'#myButton">

    <form id="myForm" method="post">
    <table align="center">

        <tr>
            <td>新密码</td>
            <td>
                <input class="easyui-passwordbox"  id="name">
            </td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td>
                <input class="easyui-passwordbox" name="userpwd" id="name2">
            </td>
        </tr>
        <!-- 定义按钮 -->



    </table>
        <!-- 定义按钮 -->
        <div id="myButton"align="center">
            <a href="javascript:update()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
            <a href="javascript:closeDig()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
        </div>

</form>
</div>
</body>

<script>


    //新增
    function update(){
       var nane= $("#name").val();

        var nane2= $("#name2").val();

        if(nane!=$("#name2").val()){
            $.messager.alert("提示","两次密码必须保持一致","error")

        }
        if(nane==$("#name2").val()){
            $("#myForm").form("submit",{
                url:"<%=request.getContextPath() %>/updatpwd",
                success:function(){
                    $.messager.alert("提示","修改成功","info")
                    //关闭弹框
                    $("#myDialog").dialog("close")
                    $("#myForm").form("reset");
                    //关闭
                    closeDig()

                },error:function(){
                    $.messager.alert("提示消息","修改失败","error");


                }

            })


        }


    }

</script>
</html>
