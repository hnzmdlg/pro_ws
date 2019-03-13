<%--
  Created by IntelliJ IDEA.
  User: 64188
  Date: 2019/1/25
  Time: 10:59
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
    <!-- 引文tree的工具js -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/util-js.js"></script>
</head>
<body>
<!-- 定义布局 -->
<div class="easyui-layout" data-options="fit:true">
    <!-- 角色权限============================================================= -->
    <div data-options="region:'west',title:'角色权限'" style="width:30%">
<!-- 查询角色-->
        <table id="querRole"></table>
    </div>

    <div id="searchDiv">

<%--
        <a href="javascript:deleteBys1()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
--%>
        <a href="javascript:openDig()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
    </div>

    <!-- 定义角色表格 -->
    <table id="myTable"> </table>
    <!-- 定义新增表格 -->
    <div id="myDialog" class="easyui-dialog" style="width:400px;height:300px" data-options="modal:true,maximizable:true,resizable:true,buttons:'#myButton',closed:true,iconCls:'icon-save'">
        <form id="myForm" method="post">
            <input style="display:none" name="id">
            <input style="display:none" name="puser">
            <input style="display:none" name="cid">
            <input style="display:none" name="status">
            <table>
                <tr>
                    <td>角色</td>
                    <td>
                        <input class="easyui-textbox" name="rname">
                    </td>
                </tr>
                <tr>
                    <td>简介</td>
                    <td>
                        <input class="easyui-textbox" name="info">
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


<!-- 权限列表====================================== -->
<div data-options="region:'center',title:'权限列表'"style="width:40%">
    <div class="easyui-panel" data-options="footer:'#footer',fit:true">
        <!-- 定义隐藏域id -->
        <input  id="roleId" type="hidden">
        <!-- 定义树 -->
        <ul id="orgTree"></ul>

        <!-- 定义按钮 -->
    <div id="footer" style="text-align:right">
        <a href="javascript:saveRolePower()"class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
    </div>

        <div id="mm" class="easyui-menu" style="width:120px;">
            <div onclick="append()" data-options="iconCls:'icon-add'">追加</div>
            <div onclick="edit()" data-options="iconCls:'icon-edit'">修改</div>
            <div onclick="remove()" data-options="iconCls:'icon-remove'">移除</div>
        </div>

    </div>
</div>


<!-- 权限详情=============================================== -->
<div data-options="region:'east',title:'权限详情'"style="width:40%">
    <!-- 定义 新增按钮 -->
    <div id="powerToolbar">

        <a href="javascript:openPowerDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
        <a href="javascript:deleteBys()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>

    </div>

<!--定义权限展示-->
    <table id="TreeTable"></table>

    <!-- 定义详细新增，修改对话框 -->
    <div class="easyui-dialog" id="powerMenuDig" data-options="width:300,height:200,modal:true,iconCls:'icon-save',closed:true,buttons:'#menubuttons'">
        <form method="post" id="menuForm">
            <input type="hidden"  name="power_id" id="powerId">
            <table>
                <tr>
                    <td>名称</td>
                    <td>
                        <input class="easyui-textbox" name="name">
                    </td>
                </tr>
                <tr>
                    <td>url路径</td>
                    <td>
                        <input class="easyui-textbox" name="url">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!-- 详细对话框按钮 -->
    <div id="menubuttons">
        <a href="javascript:savePowerMenu()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
        <a href="javascript:closeDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
    </div>

</div>

</div>

</body>

<script>
    //新增//修改
    function add(){
        $("#myForm").form("submit",{
            url:"<%=request.getContextPath() %>/addRole",
            success:function(){
                $.messager.alert("提示","保存成功","info")
                //关闭弹框
                $("#myDialog").dialog("close")
                //关闭
                closeDig()
                //刷新
                searchAnswer()
            }

        })

    }

    //打开对话框
    function openDig() {
        //重置表单
        $("#myForm").form("reset");
        ////清除图片隐藏域
        //$("#hideImg").val("");
        //清除图片
        //$("#mypic").prop("src", "");
        //清空富文本框
        //editor.html("");
        //打开
        $("#myDialog").dialog({
            title:'新增角色',
            closed:false

        })
    }

    //关闭对话框
    function closeDig(){
        $("#myDialog").dialog("close")

    }

    //单个删除
    function deleteByid(id){

        //alert(id)
        $.messager.confirm("提示","是否确定删除!",function(r){
            if(r){
                $.ajax({
                    url:"<%=request.getContextPath() %>/deleteRoleAll",
                    type:"post",
                    data:{"id":id},
                    success:function(){
                        $.messager.alert("提示消息","删除成功","info");
                        searchAnswer()
                    },error:function(){
                        $.messager.alert("提示消息","删除失败","error");


                    }
                })

            }

        })
    }


    //批量删除
    function deleteBys1(){

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
                url:"<%=request.getContextPath() %>/deleteRoleAll",
                type:"post",
                data:{"id":ids},
                success:function(){
                    $.messager.alert("提示消息","删除成功","info");
                    searchAnswer()
                },error:function(){
                    $.messager.alert("提示消息","删除失败","error");


                }
            })

        })
    }

    //条件查询
    function searchAnswer(){
        $("#myTable").datagrid("load",{
         /*   contont:$("#contont").textbox("getValue")*/
        })
    }







    $(function(){
        initPowerTree(-1);
        initTreeTable(-1); //初始化权限详细表格
    })
    //左===============================================================

    //查询
    $("#querRole").datagrid({
        url:"<%=request.getContextPath()%>/queryRole",
        columns:[[
            {field:"check",checkbox:true},
            {field:'id',title:'编号',align:'center'},
            {field:'rname',title:'角色',align:'center'},
            {field:'info',title:'简介',align:'center'},
            {field:'tools',title:'操作',align:'center',formatter:function(value,row,index){
                var str = "<a href='javascript:openPower("+row.id+")'>赋权限</a>"
                str+="| <a href='javascript:deleteByid("+row.id+")'>删除</a>"
                return str;
            }},

        ]],
        fit:true,
        toolbar:"#searchDiv"


    })
//中====================================================
    //给角色权限赋值：
    function saveRolePower(){
        var roleId = $("#roleId").val();
        //获取选中的权限树节点
        var powerArr = $("#orgTree").tree("getChecked");
        var powerIds = "";
        for(i=0;i<powerArr.length;i++){
            if(powerIds==""){
                powerIds+=powerArr[i].id;
            }else{
                powerIds+=","+powerArr[i].id;
            }
        }
       // alert(powerIds)
        $.ajax({
            url:"<%=request.getContextPath() %>/saveRolePower",
            type:"post",
            data:{"roleId":roleId,"powerIds":powerIds},
            success:function(){
                $.messager.alert("提示","赋权限成功！","info");

            }

        })
    }


    //给角色赋权限：回显权限
    function openPower(id){
        //alert(id)
        $("#roleId").val(id);

        initPowerTree(id)
    }

    //加载同步树：工具js
    function initPowerTree(id){

        $("#orgTree").tree({
            url:"<%=request.getContextPath() %>/authTree2?id="+id ,
            checkbox:true,
            parentField:"pid",
            onContextMenu:function(e, node){
                //组织浏览器本身的右击事件
                e.preventDefault();
                // 选中节点
                $('#navTree').tree('select', node.target);
                // 显示快捷菜单
                $('#mm').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            },
            ///修改权限节点
            onAfterEdit:function(node){
                //alert(node.text)
                $.ajax({
                    url:"<%=request.getContextPath() %>/tree/updateTree.do",
                    type:"post",
                    data:{"id":node.id,"text":node.text},
                    success:function(){
                        $.messager.alert("提示","修改权限节点成功！","info");

                    }
                })
            },
            //定义详情双击事件
            onDblClick:function(node){
               //alert(11)
                initTreeTable(node.id);
                $("#powerId").val(node.id);

            }
        })

    }

    //右=============================================

    //单个删除
    function deleteById(id){

        //alert(id)
        $.messager.confirm("提示","是否确定删除!",function(r){
            if(r){
                $.ajax({
                    url:"<%=request.getContextPath() %>/deletePowerMenuAll",
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
        var arr = $("#menuForm").datagrid("getChecked");
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
                url:"<%=request.getContextPath() %>/deletePowerMenuAll",
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





    //保存权限详细信息
    function  savePowerMenu() {
        $("#menuForm").form("submit",{
            url:"savePowerMenu",
            success:function () {
                $.messager.alert("提示","添加权限详细成功！","info");
                $("#powerMenuDig").dialog("close");//关闭弹框
                initTreeTable($("#powerId").val());


            }

        })
    }

    //打开对话框
    function openPowerDialog() {
        //清空
        $("#menuForm").form("reset");
        $("#powerMenuDig").dialog({

            title:"新增权限",
            closed:false

        })

    }
    //初始化权限详细表格
    function initTreeTable(powerId){
        //alert(powerId)
        $('#TreeTable').datagrid({
            url:"<%=request.getContextPath() %>/querypowerMenu?powerId="+powerId,
            toolbar:"#powerToolbar",
            fit:true,
            columns:[[
                {field:"check",checkbox:true},
                {field:"id",title:"id"},
                {field:"name",title:"名称"},
                {field:"url",title:"路径"},
                {field:"tools",title:"操作",formatter:function(value,row,index){
                    return "<a href='javascript:deleteById("+row.id+")'>删除</a>";
                }}
            ]]
        })
    }

</script>
</html>
