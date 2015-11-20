<%@ page contentType="text/html;charset=UTF-8"%>
<html >
<head>
<%@include file="./head.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 
</head>
<body>

<style type="text/css">
.relogio{width:550px;height:550px;margin:40px auto 0 auto;}
</style>

<div class="relogio"></div>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bentclock/index.js"></script>

</body>
</html>