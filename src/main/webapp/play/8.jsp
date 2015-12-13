<%@ page contentType="text/html;charset=UTF-8"%>
<html >
<head>
<%@include file="./head.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
 
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/shakeimage/ShakeBorder.js"></script>
<!--主要样式-->
<link href="<%=request.getContextPath()%>/resources/shakeimage/ShakeBorder.css" rel="stylesheet" />
  
</head>
<body>

<div style="text-align:center;font:normal 14px/24px 'MicroSoft YaHei';clear:both;width:560px;margin:0 auto;">
	<a href="#"><img class="ShakeAndBorder" alt="大饼"  src="<%=request.getContextPath()%>/resources/shakeimage/1.png" /></a>
</div>
<script type="text/javascript">$('.ShakeAndBorder').ShakeBorder();</script>
 
</body>
</html>