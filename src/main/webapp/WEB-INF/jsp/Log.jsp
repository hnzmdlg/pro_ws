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
</head>
<body>
<!-- 条件查询+定义按扭 -->
<!-- 工具栏 -->
<div id="toolbar">
	方法名:<input class="easyui-textbox" id="method">
	请求参数:<input class="easyui-textbox" id="reqParam">
	<%--创建时间:<input class="easyui-datebox" id="start">--%>
	<%---<input class="easyui-datebox" id="end"><br>--%>
	<a href="javascript:searchLog()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
	<a href="javascript:outWorld()"  class="btn btn-info"  style="width: 100px;margin-left: 290px;margin-top: -100px;">导出日志</a>
</div>

<table id="myTable"></table>
</body>
<script type="text/javascript">

	//导出Excel文档
	function outWorld(){
		location.href="exportApplyForm";

	}

$("#myTable").datagrid({
	url:"<%=request.getContextPath()%>/findLog",

	columns:[[
	          {field:'id',title:'编号',width:300,align:'center'},
	          {field:"createDate",title:'日志时间',width:300,align:'center'},
	          /*{field:"userName",title:'用户',width:100,align:'center'},*/
	          {field:"ip",title:'ip',width:100,align:'center'},
	          {field:"className",title:'类名',width:100,align:'center'},
	          {field:"method",title:'method',width:100,align:'center'},
	        /*  {field:"reqParam",title:'reqParam',width:100,align:'center'},*/
	          {field:"repParam",title:'repParam',width:100,align:'center'},
	          
	          
	          ]],
	
			fit:true,
			pagination:true,
			pageList:[1,2,3,4,5,6,7,8,10],
			 pageSize:10 , //初始化每页显示条数，默认是10
			 pageNumber:1, //当前页,默认是1
			 fit:true,
			 toolbar:"#toolbar",
			 pagePosition:"top",
			 queryParams:{flag:"${flag}"},
})

function searchLog(){
	//alert("${flag}");
	$("#myTable").datagrid("load",{
		method:$("#method").textbox("getValue"),
		reqParam:$("#reqParam").textbox("getValue"),
		start:$("#start").datebox("getValue"),
		end:$("#end").datebox("getValue"),
		flag:"${flag}"
	})
}
</script>
</html>
