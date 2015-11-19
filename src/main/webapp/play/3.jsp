<%@ page contentType="text/html;charset=UTF-8"%>
<html >
<head>
<%@include file="./head.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/tanxing/gooey.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/tanxing/livedemo.css">
<script src="<%=request.getContextPath()%>/resources/tanxing/gooey.min.js"></script>
<style>
.prettyprint ol.linenums > li {
	list-style-type: decimal;
}
</style>
</head>
<body>
<script>
$(function($) {

	$("#gooey-upper").gooeymenu({
		bgColor: "#ff6666",
		contentColor: "white",
		style: "circle",
		horizontal: {
			menuItemPosition: "glue"
		},
		vertical: {
			menuItemPosition: "spaced",
			direction: "up"
		},
		circle: {
			radius: 80
		},
		margin: "small",
		size: 90,
		bounce: true,
		bounceLength: "small",
		transitionStep: 100,
		hover: "#e55b5b"
	});
	
	$("#gooey-h").gooeymenu({
		bgColor: "#68d099",
		contentColor: "white",
		style: "horizontal",
		horizontal: {
			menuItemPosition: "glue"
		},
		vertical: {
			menuItemPosition: "spaced",
			direction: "up"
		},
		circle: {
			radius: 90
		},
		margin: "small",
		size: 80,
		bounce: true,
		bounceLength: "small",
		transitionStep: 100,
		hover: "#5dbb89"
	});
	
	$("#gooey-round").gooeymenu({
		bgColor: "#68d099",
		contentColor: "white",
		style: "circle",
		horizontal: {
			menuItemPosition: "spaced"
		},
		vertical: {
			menuItemPosition: "spaced",
			direction: "up"
		},
		circle: {
			radius: 85
		},
		margin: "small",
		size: 80,
		bounce: true,
		bounceLength: "small",
		transitionStep: 100,
		hover: "#5dbb89"
	});
	
	$("#gooey-API").gooeymenu({
		bgColor: "#68d099",
		contentColor: "white",
		style: "circle",
		circle: {
			radius: 85
		},
		margin: "small",
		size: 70,
		bounce: true,
		bounceLength: "small",
		transitionStep: 100,
		hover: "#5dbb89",
		open: function() {
			$(this).find(".gooey-menu-item").css("background-color", "steelblue");
			$(this).find(".open-button").css("background-color", "steelblue");
		},
		close: function() {
			$(this).find(".gooey-menu-item").css("background-color", "#ffdf00");
			$(this).find(".open-button").css("background-color", "#ffdf00");
		}
	});
	
	$("#gooey-v").gooeymenu({
		bgColor: "#68d099",
		contentColor: "white",
		style: "vertical",
		horizontal: {
			menuItemPosition: "glue"
		},
		vertical: {
			menuItemPosition: "spaced",
			direction: "up"
		},
		circle: {
			radius: 90
		},
		margin: "small",
		size: 70,
		bounce: true,
		bounceLength: "small",
		transitionStep: 100,
		hover: "#68d099"
	});

});
</script>

<header class="plugin-demo-header">
<nav id="gooey-upper">
<input type="checkbox" class="menu-open" name="menu-open1" id="menu-open1"/>
<label class="open-button" for="menu-open1">
<span class="burger burger-1"></span>
<span class="burger burger-2"></span>
<span class="burger burger-3"></span>
</label>
<a href="#" class="gooey-menu-item"> 点我 </a>
<a href="#" class="gooey-menu-item"> 点他 </a>
<a href="#" class="gooey-menu-item"> 点她 </a>
<a href="#" class="gooey-menu-item"> 点它 </a>
</nav>
</header>
<div class="container">

	<div class="section-cont col-md-3" id="h-spaced-menu">
  <i class="desc">横向展开</i>
<div class="row">
	<div class="col-xs-12 col-sm-6 col-md-5">
		<nav id="gooey-h">
			<input type="checkbox" class="menu-open" name="menu-open2" id="menu-open2"/>
<label class="open-button" for="menu-open2">
<span class="burger burger-1"></span>
<span class="burger burger-2"></span>
<span class="burger burger-3"></span>
</label>

<a href="#" class="gooey-menu-item"> 哈哈 </a>
<a href="#" class="gooey-menu-item"> 呵呵 </a>
<a href="#" class="gooey-menu-item"> 嘿嘿 </a>
<a href="#" class="gooey-menu-item"> 嘻嘻 </a>
		</nav>   
	</div>
</div>
</div>
	<div class="section-cont col-md-3" id="round">
<div class="row">
	<div class="col-md-5 col-xs-12 col-sm-6 round-example">
		<i class="desc">圈圈展开</i>
		<nav id="gooey-round">
<input type="checkbox" class="menu-open" name="menu-open3" id="menu-open3"/>
<label class="open-button" for="menu-open3">
<span class="burger burger-1"></span>
<span class="burger burger-2"></span>
<span class="burger burger-3"></span>
</label>

<a href="#" class="gooey-menu-item">红烧牛腩</a>
<a href="#" class="gooey-menu-item">地三鲜</a>
<a href="#" class="gooey-menu-item">糖醋排条</a>
<a href="#" class="gooey-menu-item">排骨萝卜</a>
<a href="#" class="gooey-menu-item">粉蒸肉</a>
</nav>
	</div>
	</div>
	</div>  
	<div class="section-cont col-md-3" id="menu-v-example">
<div class="row">
	<div class="col-md-5 col-xs-12 vertical-example">
		<i class="desc">垂直展开</i>
		<nav id="gooey-v">
<input type="checkbox" class="menu-open" name="menu-open4" id="menu-open4"/>
<label class="open-button" for="menu-open4">
<span class="burger burger-1"></span>
<span class="burger burger-2"></span>
<span class="burger burger-3"></span>
</label>

<a href="#" class="gooey-menu-item"> 上得厅堂 </a>
<a href="#" class="gooey-menu-item"> 下得厨房 </a>
<a href="#" class="gooey-menu-item"> 打得过小三 </a>
<a href="#" class="gooey-menu-item"> 斗得过流氓 </a>
</nav>
	</div>
</div>
	</div>
	<div class="section-cont col-md-3" id="event-api">
		<div class="row">
			<div class="col-md-5 col-xs-12 event-api-ex">
				<i class="desc">事件API</i>
				<nav id="gooey-API">
<input type="checkbox" class="menu-open" name="menu-open5" id="menu-open5"/>
<label class="open-button" for="menu-open5">
<span class="burger burger-1"></span>
<span class="burger burger-2"></span>
<span class="burger burger-3"></span>
</label>

<a href="#" class="gooey-menu-item"> 文能控萝莉</a>
<a href="#" class="gooey-menu-item"> 武能定人妻 </a>
<a href="#" class="gooey-menu-item"> 进可压正太 </a>
<a href="#" class="gooey-menu-item"> 退能迎众基 </a>
<a href="#" class="gooey-menu-item"> 上能弯直男 </a>
<a href="#" class="gooey-menu-item"> 下能御腐女 </a>
<a href="#" class="gooey-menu-item"> 前可开蓬门 </a>
<a href="#" class="gooey-menu-item"> 后能扫门庭 </a>
</nav>
			</div>
		</div>
	</div>
	</div>

</body>
</html>
