<%@ page contentType="text/html;charset=UTF-8"%>
<html >
<head>
<%@include file="./head.jsp"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/wave/style.css" media="screen" type="text/css" />
</head>
<body>
<input type="range" id="range" min="0" max="1" step="0.01" />

<script src="<%=request.getContextPath()%>/resources/wave/index.js"></script>

</body>
</html>
<%@include file="../foot.jsp"%>