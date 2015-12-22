<%@ page contentType="text/html;charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<title>我是一个程序猿</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@include file="navi.jsp"%>
</head>
<body>
<ul class="list-group">
  <li class="list-group-item list-group-item-info">
  <div class="media-left">
      <a href="#">
        <img class="media-object" src="<%=request.getContextPath()%>/resources/head.jpg">
      </a>
    </div>
    <div class="media-body">
      <h3 class="media-heading">猿某某</h3>
      	<p>小猿一只.</p>
    </div>
  </li>
  <li> <div class="btn-group btn-group-justified" role="group" aria-label="...">
  <div class="btn-group" role="group">
  	<a class="btn btn-info" href="#" role="button">Link</a>
  </div>
</div>
  </li>
</ul>
</body>
</html>
