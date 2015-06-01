<%@ page contentType="text/html;charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/WEB-INF/views/include/head.jsp"%>
<script src="<%=request.getContextPath()%>/resources/highcharts.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.carousel').carousel();
		$('.carousel-example-generic').carousel();
	});
</script>
</head>
<body>
<!-- Carousel
    ================================================== -->

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>
  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active" style="background:url(<%=request.getContextPath()%>/resources/img/i.jpg); background-size:100% 100%;background-repeat:no-repeat;height:90%">
      <div class="carousel-caption">
      	<span style="font-size: x-large;color: black;font-weight: bolder;">你是否被<span style="color: blue">“午饭<span class="glyphicon glyphicon-cutlery" aria-hidden="true"></span>吃什么”</span>这样的问题<span style="color: red">蹂躏<span class="glyphicon glyphicon-certificate" aria-hidden="true"></span></span>过?</span>
      	<hr>
      	<span style="font-size: xx-large;color: black;font-weight: bolder;">你是否被<span style="color: maroon;">“该选哪件衣服<span class="glyphicon glyphicon-user" aria-hidden="true"></span>”</span>这样的问题<span style="color: lime;">糟蹋<span class="glyphicon glyphicon-flash" aria-hidden="true"></span></span>过?</span>
      </div>
    </div>
    <div class="item" style="background:url(<%=request.getContextPath()%>/resources/img/i.jpg); background-size:100% 100%;background-repeat:no-repeat;height:90%">
      <div class="carousel-caption">
        <span style="font-size: xx-large;color: black;font-weight: bolder;">你是否被<span style="color: blue">“我的未来<span class="glyphicon glyphicon-screenshot" aria-hidden="true"></span>该怎样”</span>这样的问题<span style="color: fuchsia;">撕扯<span class="glyphicon glyphicon-scissors" aria-hidden="true"></span></span>过?</span>
      	<hr>
      </div>
    </div>
    <div class="item" style="background:url(<%=request.getContextPath()%>/resources/img/i.jpg); background-size:100% 100%;background-repeat:no-repeat;height:90%">
      <div class="carousel-caption">
        <span style="font-size: xx-large;color: black;font-weight: bold;">来来来～～～把</span><span style="font-size: xx-large;font-weight: bold;color: lime;"><span style="color: purple;">你的纠结<span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span></span>丢给我们</span>
       	<hr>
      	<span style="font-size: xx-large;color: black;font-weight: bolder;">我们<span style="color: blue;font-weight: bolder;">人多
      	<span class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span>
      	<span class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span>
      	<span class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span>
      	<span class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span>
      	<span class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span></span>
      	<hr>
      	<span style="font-size: large;color: black;font-weight: bolder;">我们<a href="<%=request.getContextPath()%>/hello"><span style="font-size: xx-large;">帮</span></a>你
      	<span style="font-size: xx-large;color: red;font-weight: bolder;">
      	<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
      	<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
      	<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
      	<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
      	<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></span>
      	</span>
      </div>
    </div>
  </div>
  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
    <!-- /.carousel -->
</body>
</html>
