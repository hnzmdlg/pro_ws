<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/2/21
  Time: 14:01
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
    <!-- 引入uploadify css js文件   -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/js/uploadify/uploadify.css">
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/uploadify/jquery.uploadify.min.js"></script>
    <!-- 引入kindeditor css js文件    -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/js/kindeditor-4.1.10/themes/default/default.css" />
    <script src="<%=request.getContextPath() %>/js/kindeditor-4.1.10/kindeditor-all.js"></script>
</head>
<body>
<div id="searchDivk">
    <a href="javascript:deleteBys()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
    <a href="javascript:openDig()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>

</div>

<!-- 定义表格 -->
<table id="myTablek"> </table>

<!-- 定义新增表格 -->
<div id="myDialog" class="easyui-dialog" style="width:500px;height:400px" data-options="modal:true,maximizable:true,resizable:true,buttons:'#myButton',closed:true,iconCls:'icon-save'">
    <form id="myForm" method="post">
        <input style="display:none" name="id">
        <table>
            <tr>
                <td>会员名称</td>
                <td>
                    <select class="easyui-combobox" name="vname">
                       <%-- <option value="">全部</option>--%>
                        <option value="1">普通会员</option>
                        <option value="2">vip</option>
                        <option value="3">vvip</option>
                        <option value="4">vvvip</option>
                        <option value="5">vvvvip</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>会员价格</td>
                <td>
                    <input class="easyui-textbox" name="vprice">
                </td>
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
       // $("#hideImg").val("");
        //清除图片
       // $("#mypic").prop("src", "");
        //清空富文本框
        //editor.html("");
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
    //修改：回显
    function openUpdateBy(id){
        //alert(id)
        $.ajax({
            url:"<%=request.getContextPath() %>/queryVipById",
            type:"post",
            data:{"id":id},
            success:function(data){
                //数据回显
                $("#myForm").form("load",data);
                //弹框
                $("#myDialog").dialog({
                    title:"修改用户",
                    closed:false
                })
            }
        })
    }



    //新增
    function add(){
        $("#myForm").form("submit",{
            url:"<%=request.getContextPath() %>/addVip",
            success:function(){
                $.messager.alert("提示","保存成功","info")
                //关闭弹框
                $("#myDialog").dialog("close")
                //关闭
                closeDig()
                //刷新
                search()
            }
        })
    }
    //单个删除
    function deleteByid(id){
        //alert(id)
        $.messager.confirm("提示","是否确定删除!",function(r){
            if(r){
                $.ajax({
                    url:"<%=request.getContextPath() %>/deleteVipAll",
                    type:"post",
                    data:{"id":id},
                    success:function(){
                        $.messager.alert("提示消息","删除成功","info");
                        search();
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
        var arr = $("#myTablek").datagrid("getChecked");
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
                url:"<%=request.getContextPath() %>/deleteVipAll",
                type:"post",
                data:{"id":ids},
                success:function(){
                    $.messager.alert("提示消息","删除成功","info");
                    search();
                },error:function(){
                    $.messager.alert("提示消息","删除失败","error");
                }
            })
        })
    }
    //查询
    $("#myTablek").datagrid({
        url:"<%=request.getContextPath()%>/queryVip",
        columns:[[
            {field:'check',checkbox:true},
            {field:'id',title:'编号',width:100,align:'center'},
            {field:'vname',title:'会员名称',width:100,align:'center',formatter:function(value,row,index){
                if(value==1){
                    return "普通会员";
                }else if(value==2){
                    return "vip";
                }else if(value==3){
                    return "vvip";
                }else if(value==4){
                    return "vvvip";
                }else if(value==5){
                    return "vvvvip";
                }
            }},
            {field:'vprice',title:'会员价格',width:100,align:'center'},
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
        toolbar:"#searchDivk",
        pagePosition:"top"
    })

</script>
</html>
