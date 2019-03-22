<%--
  Created by IntelliJ IDEA.
  User: 64188
  Date: 2019/1/29
  Time: 13:05
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
    <a href="javascript:openDig()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
</div>
<!-- 定义表格 -->
<table id="myTable"> </table>
<!-- 定义新增表格 -->
<div id="myDialog" class="easyui-dialog" style="width:400px;height:300px" data-options="modal:true,maximizable:true,resizable:true,buttons:'#myButton',closed:true,iconCls:'icon-save'">
    <form id="myForm" method="post">

        <table>
            <tr>
                <td>套餐名称</td>
                <td>
                    <input class="easyui-textbox" name="name">
                </td>
            </tr>
            <tr>
                <td>时间</td>
                <td>
                    <input class="easyui-textbox" name="mouth">
                </td>
            </tr>
            <tr>
                <td>价格</td>
                <td>
                    <input class="easyui-textbox" name="money">
                </td>
            </tr>

            <tr>
                <td>头像</td>
                <td>
                    <!-- 显示图片 -->
                    <img width="100px" height="100px"  id="mypic">
                    <!-- 文件域 上传图片 -->
                    <div id="eimg"></div>
                    <!-- 隐藏域 上传图片的路径 -->
                    <input type="hidden" name="img"  id="create_user">

                    <%--显示进度条--%>
                    <div id="uploadfileQueue"></div>
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

    //新增//修改
    function add(){
        $("#myForm").form("submit",{
            url:"<%=request.getContextPath() %>/addMeal",
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


    //关闭对话框
    function closeDig(){
        $("#myDialog").dialog("close")

    }




    //注册会员表


        $("#myTable").datagrid({
            url:"${ctx}/querymeal",
            fit:true,
            columns:[[
                {field:'id',title:'编号'},
                {field:'name',title:'套餐'},
                {field:'mouth',title:'月份/月'},
                {field:'money',title:'价钱/元'},
                {field:'img',title:'封面',width:100,formatter:function(value,row,index){
                        return "<img width='50px' height='50px' src='"+value+"'>";
                    }},
                {field:'status',title:'状态',formatter:function(value,row,index){
                        if (value==1) {
                            return '可购买';
                        }else{
                            return '停止购买';
                        }
                    }},
            ]]
        })



    //条件查询
    function searchAnswer(){
        $("#myTable").datagrid("load",{

        })
    }



    ////初始化uploadify

    $("#eimg").uploadify({
        //开启调试
        'debug': false,
        //是否自动上传
        'auto': true,
        'multi': false,  //是否多文件上传
        //'buttonImage':'<%=request.getContextPath()%>/js/uploadify/background.png', //浏览将要上传文件按钮的背景图片路径
        'buttonText': '选择文件',
        //flash
        'swf': "<%=request.getContextPath()%>/js/uploadify/uploadify.swf",
        'fileObjName': "picFile",
        'queueSizeLimit': 5,
        //文件选择后的容器ID
        'queueID': 'uploadfileQueue',
        //后台运行上传的程序
        'uploader': '<%=request.getContextPath()%>/uploadImg',
        'width': '100',
        'height': '24',
        //是否支持多文件上传，这里为true，你在选择文件的时候，就可以选择多个文件
        'multi': true,
        'fileTypeDesc': '支持的格式：',
        'fileTypeExts': '*.jpg;*.jpge;*.gif;*.png',
        'fileSizeLimit': '1MB',
        //上传完成后多久删除进度条
        'removeTimeout': 1,
        //返回一个错误，选择文件的时候触发
        'onSelectError': function (file, errorCode, errorMsg) {
            switch (errorCode) {
                case -100:
                    alert("上传的文件数量已经超出系统限制的" + $('#file_upload').uploadify('settings', 'queueSizeLimit') + "个文件！");
                    break;
                case -110:
                    alert("文件 [" + file.name + "] 大小超出系统限制的" + $('#file_upload').uploadify('settings', 'fileSizeLimit') + "大小！");
                    break;
                case -120:
                    alert("文件 [" + file.name + "] 大小异常！");
                    break;
                case -130:
                    alert("文件 [" + file.name + "] 类型不正确！");
                    break;
            }
        },
        //检测FLASH失败调用
        'onFallback': function () {
            alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
        },
        //上传到服务器，服务器返回相应信息到data里
        'onUploadSuccess': function (file, data, response) {
            //alert(data);
            $("#mypic").attr("src", "<%=request.getContextPath()%>/"+data);
            $("#create_user").val(data);
        },
        //多文件上传，服务器返回相应的信息
        'onQueueComplete': function (queueData) {
            //alert(queueData.uploadsSuccessful);
        }
    });


</script>
</html>
