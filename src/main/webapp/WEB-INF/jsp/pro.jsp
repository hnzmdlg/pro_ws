<%--
  Created by IntelliJ IDEA.
  User: 64188
  Date: 2019/2/3
  Time: 16:51
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
<div id="searchDiv2">

    <a href="javascript:deleteBys()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>

</div>


<!-- 定义表格 -->
<table id="myTable2"> </table>

</body>
<script>

    //单个删除
    function deleteByid(id){

        //alert(id)
        $.messager.confirm("提示","是否确定删除!",function(r){
            if(r){
                $.ajax({
                    url:"<%=request.getContextPath() %>/deleteProblemAll",
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
        var arr = $("#myTable2").datagrid("getChecked");
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
                url:"<%=request.getContextPath() %>/deleteProblemAll",
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

    //条件查询
    function search(){
        $("#myTable2").datagrid("load",{

        })

    }


    //查询
    $("#myTable2").datagrid({
        url:"<%=request.getContextPath()%>/queryProblem2",
        columns:[[
            {field:'check',checkbox:true},
            {field:'id',title:'编号',width:100,align:'center'},
            {field:'pname',title:'提问人',width:100,align:'center'},
            {field:'pcreatetime',title:'提问时间',width:100,align:'center'},
            {field:'psfzr',title:'提问时间',width:100,align:'center'},
            {field:'tools',title:'操作', width:100,align:'center',formatter:function(value,row,index){
                    var str = "<a href='javascript:openUpdateBy("+row.id+")'>空</a>"
                    str+="| <a href='javascript:deleteByid("+row.id+")'>删除</a>"
                    return str;
                }}

        ]],
        pagination:true,//开启分页
        pageList:[1,2,3,4,5,6], //初始化页面大小选择列表
        pageSize:3 , //初始化每页显示条数，默认是10
        pageNumber:1, //当前页,默认是1
        fit:true,
        toolbar:"#searchDiv2",
        pagePosition:"top"
    })



</script>
</html>
