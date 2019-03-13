<%--
  Created by IntelliJ IDEA.
  User: 64188
  Date: 2019/2/4
  Time: 15:15
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
<div id="searchDiv">

   网站用户名称：<input class="easyui-textbox" id="name">
    <a href="javascript:searchUSer()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>

    <a href="javascript:deleteBys()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
    <a href="javascript:openDig()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>

</div>
<!-- 定义表格 -->
<table id="myTable"> </table>

<!-- 定义新增表格 -->
<div id="myDialog" class="easyui-dialog" style="width:400px;height:300px" data-options="modal:true,maximizable:true,resizable:true,buttons:'#myButton',closed:true,iconCls:'icon-save'">
    <form id="myForm" method="post">
        <input style="display:none" name="id">

        <table>
            <tr>
                <td>网站用户账号</td>
                <td>
                    <input class="easyui-textbox" name="name">
                </td>
            </tr>
            <tr>
                <td>网站用户密码</td>
                <td>
                    <input class="easyui-textbox" name="pwd">
                </td>
            </tr>
            <tr>
                <td>网站用户邮箱</td>
                <td>
                    <input class="easyui-textbox" name="email">
                </td>
            </tr>

            <tr>
                <td>网站用户性别</td>
                <td>
                    <input type="radio" value="1" name="sex">男
                    <input type="radio" value="0" name="sex">女
                </td>
            </tr>
            <tr>
                <td>是否注册会员</td>
                <td>
                    <input type="radio" value="1" name="member">是
                    <input type="radio" value="0" name="member">否
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




    //打开对话框
    function openDig() {
        //重置表单
        $("#myForm").form("reset");
        //清除图片隐藏域
        $("#hideImg").val("");
        //清除图片
        $("#add_img").prop("src", "");
        //清空富文本框
        //editor.html("");

       // initRole()
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


    //新增//修改
    function add(){
        $("#myForm").form("submit",{
            url:"<%=request.getContextPath() %>/addWebUser",
            success:function(){
                $.messager.alert("提示","保存成功","info")
                //关闭弹框
                $("#myDialog").dialog("close")

                //关闭
                closeDig()
                //刷新
                searchUSer()
            }

        })

    }


    //修改：回显
    function openUpdateBy(id){
        //alert(id)
        $.ajax({
            url:"<%=request.getContextPath() %>/queryWebUserById",
            type:"post",
            data:{"id":id},
            success:function(data){


                //数据回显
                $("#myForm").form("load",data);
               // initRole()

                //弹框
                $("#myDialog").dialog({
                    title:"修改用户",
                    closed:false
                })
            }
        })
    }

    //单个删除
    function deleteByid(id){

        //alert(id)
        $.messager.confirm("提示","是否确定删除!",function(r){
            if(r){
                $.ajax({
                    url:"<%=request.getContextPath() %>/deleteWebUserAll",
                    type:"post",
                    data:{"id":id},
                    success:function(){
                        $.messager.alert("提示消息","删除成功","info");
                        searchUSer();
                    },error:function(){
                        $.messager.alert("提示消息","删除失败","error");


                    }
                })

            }

        })
    }


    //批量删除
    function deleteBys(){

        //获取复选框
        var arr = $("#myTable").datagrid("getChecked");
        if(arr.length<=0){
            $.messager.alert("提示消息","请至少选择一条数据！","warning");
            return;
        }
        $.messager.confirm("提示","是否确认删除"+arr.length+"条数据？",function(r){
            if(r){
                var ids = "";
                for(var i=0;i<arr.length;i++){
                    //alert(arr[i].id);
                    if(ids==""){
                        ids += arr[i].id;
                    }else{
                        ids += ","+arr[i].id;
                    }
                }

            }

            //alert(ids)
            $.ajax({
                url:"<%=request.getContextPath() %>/deleteWebUserAll",
                type:"post",
                data:{"id":ids},
                success:function(){
                    $.messager.alert("提示消息","删除成功","info");
                    searchUSer();
                },error:function(){
                    $.messager.alert("提示消息","删除失败","error");


                }
            })

        })
    }

    //条件查询
    function searchUSer(){
        $("#myTable").datagrid("load",{
            //name:$("#name").textbox("getValue")
        })
    }

    //查询
    $("#myTable").datagrid({
        url:"<%=request.getContextPath()%>/queryWebUser",
        columns:[[
            {field:'check',checkbox:true},
            {field:'id',title:'编号'},
            {field:'name',title:'网站用户名称'},
            {field:'pwd',title:'用户密码'},
            {field:'email',title:'用户邮箱'},
            {field:'sex',title:'性别',formatter:function(value,row,index){
                    if(value==1){
                        return "男";
                    }else{
                        return "女";
                    }
                }},
            {field:'member',title:'是否是会员',formatter:function(value,row,index){
                    if(value==1){
                        return "是";
                    }else{
                        return "不是";
                    }
                }},
            {field:'expiredate',title:'注册时间'},

            {field:'tools',title:'操作', width:100,align:'center',formatter:function(value,row,index){
                    var str = "<a href='javascript:openUpdateBy("+row.id+")'>修改</a>"
                    str+="| <a href='javascript:deleteByid("+row.id+")'>删除</a>"
                    return str;
                }}

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
