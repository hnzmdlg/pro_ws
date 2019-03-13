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
	<!-- 引文tree的工具js -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/util-js.js"></script>

</head>
<body>
<div class="easyui-layout" data-options="fit:true">
	<!-- 上 -->
	<div
			data-options="region:'north',height:100,title:'北',collapsidle:false"
	>
	</div>
	<!-- 左 -->
	<div
			data-options="region:'west',width:200,title:'功能导航',split:true,iconCls:'icon-search'"
	>
		<div class="easyui-accordion" data-options="fit:true,selected:0">

			<div data-options="title:'用户管理'">
				<ul id="orgTree"></ul>
			</div>
			<div data-options="title:'课程管理'">
				<ul id="asynTree"></ul>
			</div>
			<div data-options="title:'报表管理'">
				<ul id="asynTree2"></ul>
			</div>
			<div data-options="title:'日志管理'">
				<ul id="asynTree3"></ul>
			</div>
			<div data-options="title:'广告管理'">
				<ul id="asynTree4"></ul>
			</div>

			<div data-options="title:'新闻管理'">
				<ul id="asynTree5"></ul>
			</div>

			<div data-options="title:'会员管理'">
				<ul id="asynTree6"></ul>
			</div>

		</div>

	</div>
	<!-- 中 -->
	<div data-options="region:'center',title:'详细功能'">
		<!-- 定义选项卡 -->
		<div class="easyui-tabs" data-options="fit:true" id="myTabs">

			<div data-options="title:'首页'">
				欢迎您
			</div>

		</div>

	</div>


</div>
</body>

<script type="text/javascript">
    //异 步树
    /*$("#asynTree").tree({
        url:"<%=request.getContextPath() %>/tree/queryTreeAsyn.do?pid=0",
		onBeforeExpand:function(node){
			$("#asynTree").tree("options").url="<%=request.getContextPath() %>/tree/queryTreeAsyn.do?pid="+node.id;

		},
		onClick:function(node){
			//alert(node.url)
			if(node.url!=null){
				if($("#myTabs").tabs("exists",node.text)){

					$("#myTabs").tabs("select",node.text);
				}else{

					$("#myTabs").tabs("add",{
						title:node.text,
						closable:true,
						content:createJsp(node.url)


					})
				}

			}
		}

	})*/
    function createJsp(url){
        return "<iframe frameborder='0' src='<%=request.getContextPath() %>"+url+"' style='width:100%;height:100%' scrolling='auto'></iframe>";


    }

    //加载同步树：工具js    员工
    $("#orgTree").tree({
        url:"<%=request.getContextPath() %>/authTree",
        parentField:"pid",
        onClick:function(node){
            //alert(node.url)
            if(node.url!=null){
                if($("#myTabs").tabs("exists",node.text)){

                    $("#myTabs").tabs("select",node.text);
                }else{

                    $("#myTabs").tabs("add",{
                        title:node.text,
                        closable:true,
                        content:createJsp(node.url),

                        //更新页面
                        tools:[{
                            iconCls:'icon-mini-refresh',
                            handler:function(){
                                // 更新选项卡
                                var tab = $('#myTabs').tabs('getSelected');
                                $("#myTabs").tabs('update',{
                                    tab: tab,
                                    options:{
                                        content: createJsp(node.url)
                                    }
                                });
                            }
                        }]

                    })
                }

            }
        }

    })

    //加载同步树：工具js    课程
    $("#asynTree").tree({
        url:"<%=request.getContextPath() %>/queryTree2",
        parentField:"pid",
        onClick:function(node){
            //alert(node.url)
            if(node.url!=null){
                if($("#myTabs").tabs("exists",node.text)){

                    $("#myTabs").tabs("select",node.text);
                }else{

                    $("#myTabs").tabs("add",{
                        title:node.text,
                        closable:true,
                        content:createJsp(node.url),

                        //更新页面
                        tools:[{
                            iconCls:'icon-mini-refresh',
                            handler:function(){
                                // 更新选项卡
                                var tab = $('#myTabs').tabs('getSelected');
                                $("#myTabs").tabs('update',{
                                    tab: tab,
                                    options:{
                                        content: createJsp(node.url)
                                    }
                                });
                            }
                        }]

                    })
                }

            }
        }

    })


    //加载同步树：工具js    报表
    $("#asynTree2").tree({
        url:"<%=request.getContextPath() %>/reportTree",
        parentField:"pid",
        onClick:function(node){
            //alert(node.url)
            if(node.url!=null){
                if($("#myTabs").tabs("exists",node.text)){

                    $("#myTabs").tabs("select",node.text);
                }else{

                    $("#myTabs").tabs("add",{
                        title:node.text,
                        closable:true,
                        content:createJsp(node.url),

                        //更新页面
                        tools:[{
                            iconCls:'icon-mini-refresh',
                            handler:function(){
                                // 更新选项卡
                                var tab = $('#myTabs').tabs('getSelected');
                                $("#myTabs").tabs('update',{
                                    tab: tab,
                                    options:{
                                        content: createJsp(node.url)
                                    }
                                });
                            }
                        }]

                    })
                }

            }
        }

    })

    //加载同步树：工具js    日志
    $("#asynTree3").tree({
        url:"<%=request.getContextPath() %>/journalTree",
        parentField:"pid",
        onClick:function(node){
            //alert(node.url)
            if(node.url!=null){
                if($("#myTabs").tabs("exists",node.text)){

                    $("#myTabs").tabs("select",node.text);
                }else{

                    $("#myTabs").tabs("add",{
                        title:node.text,
                        closable:true,
                        content:createJsp(node.url),

                        //更新页面
                        tools:[{
                            iconCls:'icon-mini-refresh',
                            handler:function(){
                                // 更新选项卡
                                var tab = $('#myTabs').tabs('getSelected');
                                $("#myTabs").tabs('update',{
                                    tab: tab,
                                    options:{
                                        content: createJsp(node.url)
                                    }
                                });
                            }
                        }]

                    })
                }

            }
        }

    })


    //加载同步树：工具js    广告

    $("#asynTree4").tree({
        url:"<%=request.getContextPath() %>/advTree",
        parentField:"pid",
        onClick:function(node){
            //alert(node.url)
            if(node.url!=null){
                if($("#myTabs").tabs("exists",node.text)){

                    $("#myTabs").tabs("select",node.text);
                }else{

                    $("#myTabs").tabs("add",{
                        title:node.text,
                        closable:true,
                        content:createJsp(node.url),

                        //更新页面
                        tools:[{
                            iconCls:'icon-mini-refresh',
                            handler:function(){
                                // 更新选项卡
                                var tab = $('#myTabs').tabs('getSelected');
                                $("#myTabs").tabs('update',{
                                    tab: tab,
                                    options:{
                                        content: createJsp(node.url)
                                    }
                                });
                            }
                        }]

                    })
                }

            }
        }

    })

    //加载同步树：工具js    广告

    $("#asynTree5").tree({
        url:"<%=request.getContextPath() %>/xwTree",
        parentField:"pid",
        onClick:function(node){
            //alert(node.url)
            if(node.url!=null){
                if($("#myTabs").tabs("exists",node.text)){

                    $("#myTabs").tabs("select",node.text);
                }else{

                    $("#myTabs").tabs("add",{
                        title:node.text,
                        closable:true,
                        content:createJsp(node.url),

                        //更新页面
                        tools:[{
                            iconCls:'icon-mini-refresh',
                            handler:function(){
                                // 更新选项卡
                                var tab = $('#myTabs').tabs('getSelected');
                                $("#myTabs").tabs('update',{
                                    tab: tab,
                                    options:{
                                        content: createJsp(node.url)
                                    }
                                });
                            }
                        }]

                    })
                }

            }
        }

    })

    //加载同步树：工具js    广告

    $("#asynTree6").tree({
        url:"<%=request.getContextPath() %>/vipTree",
        parentField:"pid",
        onClick:function(node){
            //alert(node.url)
            if(node.url!=null){
                if($("#myTabs").tabs("exists",node.text)){

                    $("#myTabs").tabs("select",node.text);
                }else{

                    $("#myTabs").tabs("add",{
                        title:node.text,
                        closable:true,
                        content:createJsp(node.url),

                        //更新页面
                        tools:[{
                            iconCls:'icon-mini-refresh',
                            handler:function(){
                                // 更新选项卡
                                var tab = $('#myTabs').tabs('getSelected');
                                $("#myTabs").tabs('update',{
                                    tab: tab,
                                    options:{
                                        content: createJsp(node.url)
                                    }
                                });
                            }
                        }]

                    })
                }

            }
        }

    })

</script>
</html>