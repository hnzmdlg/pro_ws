<%--
  Created by IntelliJ IDEA.
  User: 64188
  Date: 2019/2/4
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!-- 引入 ECharts 文件 -->
    <script src="<%=request.getContextPath() %>/js/echarts.min.js"></script>
    <!-- 引入 Jquery 文件 -->
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
<!-- 定义布局 -->
<div class="easyui-layout" data-options="fit:true">

<!--================================-->
<div data-options="region:'west',title:'报表1'" style="width:30%">

    <div id="main" style="width: 300px;height:400px;"></div>
    <a href="javascript:fangfa()" >数据库 </a>
</div>

<!-- ====================================== -->
<div data-options="region:'center',title:'报表2'"style="width:40%">

    <div id="main2" style="width: 300px;height:400px;"></div>
    <a href="javascript:fangfa2()" >数据库 2</a>
</div>

<!-- =============================================== -->
<div data-options="region:'east',title:'报表3'"style="width:40%">

    <div id="main3" style="width: 400px;height:400px;"></div>
    <a href="javascript:fangfa3()" >数据库 3</a>
</div>

</div>


</body>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]

    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);




    function fangfa(){

        $.ajax({
            url:"<%=request.getContextPath() %>/queryUser",
            type:"json",
            success:function (data) {
                alert(data);
                myChart.setOption({
                        series: [{
                            name: '销量',
                            type: 'bar',

                            data: data,

                        }]
                    }
                );
            }

        })
    }

    <!-- 饼状图-->
    // 绘制图表。
    var myChart2 =   echarts.init(document.getElementById('main2'));


    var option = {
        series: {
            type: 'pie',
            data: [
                {name: 'A', value: 1212},
                {name: 'B', value: 2323},
                {name: 'C', value: 1919}
            ]
        }
    }

    myChart2.setOption(option);
    function fangfa2(){

        $.ajax({
            url:"<%=request.getContextPath() %>/queryUser2",
            datatype:"json",
            success:function (data) {
                alert(data);
                myChart2.setOption({
                        series: {
                            type: 'pie',
                            data: data,

                        }
                    }
                );
            }

        })
    }

    //曲线图
    var myChart3= echarts.init(document.getElementById('main3'));

    var option = {
        title: {text: 'Line Chart'},
        tooltip: {},
        toolbox: {
            feature: {
                dataView: {},
                saveAsImage: {
                    pixelRatio: 2
                },
                restore: {}
            }
        },
        xAxis: {},
        yAxis: {},

        series: [{
            type: 'line',
            smooth: true,
            data: [[12, 5], [24, 20], [36, 36], [48, 10], [60, 10], [72, 20]]
        }]
    }
    myChart3.setOption(option);
    function fangfa3(){

        $.ajax({
            url:"<%=request.getContextPath() %>/queryUser",
            type:"json",
            success:function (data) {
                alert(data);
                myChart3.setOption({
                        series: {
                            type: 'line',
                            smooth: true,
                            data: data,

                        }
                    }
                );
            }

        })
    }


</script>
</html>

