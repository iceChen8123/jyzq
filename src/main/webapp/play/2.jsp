<%@ page contentType="text/html;charset=UTF-8"%>
<html >
<head>
<%@include file="./head.jsp"%>

<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";overflow-x:hidden;}
</style>


</head>
<body>
<div align="right"><span class="label label-success">双击清空,单击连续增加,拖动撞击.ok...开始发泄吧</span></div>
	<div id="canvas">
	  <script  type="text/javascript" src="<%=request.getContextPath()%>/resources/ball/protoclass.js"></script>
	  <script  type="text/javascript" src="<%=request.getContextPath()%>/resources/ball/box2d.js"></script>
	  <script  type="text/javascript" src="<%=request.getContextPath()%>/resources/ball/main.js"></script>
	</div>
</body>
</html>
<%@include file="../foot.jsp"%>