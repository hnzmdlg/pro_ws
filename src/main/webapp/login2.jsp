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
	<!-- 定义登录框 -->
	<div class="easyui-dialog" data-options="width:300,height:200,closable:false,title:'系统登录',iconCls:'icon-tip',buttons:'#button'">
		<form id="loginForm" method="post">
			  <table>
				  <tr>
					<td>用户名</td>
					<td>
						<input class="easyui-textbox" name="username" data-options="required:true,iconCls:'icon-man'">
					</td>
				  </tr>
				  <tr>
					<td>密码</td>
					<td>
						<input class="easyui-passwordbox" name="userpwd" data-options="required:true,iconCls:'icon-lock'">
					</td>
				  </tr>
				  <tr>

			  </table>
		</form>
	</div>
	<!-- 按钮 -->
	<div id="button">
		<a href="javascript:login()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登录</a>
		<a href="javascript:toReg()" class="easyui-linkbutton" data-options="iconCls:'icon-redo'">注册</a>
	</div>
</body>
<script type="text/javascript">


//跳到注册页面
function toReg(){
	location.href="<%=request.getContextPath() %>/register.jsp";
}

//登录
function login(){
	$("#loginForm").form("submit",{
		url:"<%=request.getContextPath() %>/login",
		success:function(data){
			$.messager.alert("提示",data,"info");
			if(data=="登陆成功"){
				location.href="<%=request.getContextPath() %>/index";
			}
		}
	})
}
</script>
</html>