<%@ page contentType="text/html;charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<title>不要变成自己曾经讨厌的那种人</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@include file="navi.jsp"%>
<style>
#menu {
	font: 13px "trebuchet MS", Arial, Helvetica;
}
#menu a {
	color: #2A679F;
}
#menu, #menu ul {
	margin: 0;
	padding: 0;
	list-style: none;
}
#menu {
	width: 80%;
	margin: 60px auto;
	border: 1px solid #222;
	background-color: #111;
	background-image: -moz-linear-gradient(#444, #111);
	background-image: -webkit-gradient(linear, left top, left bottom, from(#444), to(#111));
	background-image: -webkit-linear-gradient(#444, #111);
	background-image: -o-linear-gradient(#444, #111);
	background-image: -ms-linear-gradient(#444, #111);
	background-image: linear-gradient(#444, #111);
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	-moz-box-shadow: 0 1px 1px #777, 0 1px 0 #666 inset;
	-webkit-box-shadow: 0 1px 1px #777, 0 1px 0 #666 inset;
	box-shadow: 0 1px 1px #777, 0 1px 0 #666 inset;
}
#menu:before, #menu:after {
	content: "";
	display: table;
}
#menu:after {
	clear: both;
}
#menu {
	zoom: 1;
}
#menu li {
	float: left;
	border-right: 1px solid #222;
	-moz-box-shadow: 1px 0 0 #444;
	-webkit-box-shadow: 1px 0 0 #444;
	box-shadow: 1px 0 0 #444;
	position: relative;
}
#menu a {
	float: left;
	padding: 12px 30px;
	color: #999;
	text-transform: uppercase;
	font: bold 12px Arial, Helvetica;
	text-decoration: none;
	text-shadow: 0 1px 0 #000;
}
#menu li:hover > a {
	color: #fafafa;
}
*html #menu li a:hover {
	color: #fafafa;
}
#menu ul {
	margin: 20px 0 0 0;
	_margin: 0;
	opacity: 0;
	visibility: hidden;
	position: absolute;
	top: 38px;
	left: 0;
	z-index: 1;
	background: #444;
	background: -moz-linear-gradient(#444, #111);
	background-image: -webkit-gradient(linear, left top, left bottom, from(#444), to(#111));
	background: -webkit-linear-gradient(#444, #111);
	background: -o-linear-gradient(#444, #111);
	background: -ms-linear-gradient(#444, #111);
	background: linear-gradient(#444, #111);
	-moz-box-shadow: 0 -1px rgba(255,255,255,.3);
	-webkit-box-shadow: 0 -1px 0 rgba(255,255,255,.3);
	box-shadow: 0 -1px 0 rgba(255,255,255,.3);
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	-webkit-transition: all .2s ease-in-out;
	-moz-transition: all .2s ease-in-out;
	-ms-transition: all .2s ease-in-out;
	-o-transition: all .2s ease-in-out;
	transition: all .2s ease-in-out;
}
#menu li:hover > ul {
	opacity: 1;
	visibility: visible;
	margin: 0;
}
#menu ul ul {
	top: 0;
	left: 150px;
	margin: 0 0 0 20px;
	_margin: 0;
	-moz-box-shadow: -1px 0 0 rgba(255,255,255,.3);
	-webkit-box-shadow: -1px 0 0 rgba(255,255,255,.3);
	box-shadow: -1px 0 0 rgba(255,255,255,.3);
}
#menu ul li {
	float: none;
	display: block;
	border: 0;
	_line-height: 0;
	-moz-box-shadow: 0 1px 0 #111, 0 2px 0 #666;
	-webkit-box-shadow: 0 1px 0 #111, 0 2px 0 #666;
	box-shadow: 0 1px 0 #111, 0 2px 0 #666;
}
#menu ul li:last-child {
	-moz-box-shadow: none;
	-webkit-box-shadow: none;
	box-shadow: none;
}
#menu ul a {
	padding: 10px;
	width: 130px;
	_height: 10px;
	display: block;
	white-space: nowrap;
	float: none;
	text-transform: none;
}
#menu ul a:hover {
	background-color: #0186ba;
	background-image: -moz-linear-gradient(#04acec, #0186ba);
	background-image: -webkit-gradient(linear, left top, left bottom, from(#04acec), to(#0186ba));
	background-image: -webkit-linear-gradient(#04acec, #0186ba);
	background-image: -o-linear-gradient(#04acec, #0186ba);
	background-image: -ms-linear-gradient(#04acec, #0186ba);
	background-image: linear-gradient(#04acec, #0186ba);
}
#menu ul li:first-child > a {
	-moz-border-radius: 3px 3px 0 0;
	-webkit-border-radius: 3px 3px 0 0;
	border-radius: 3px 3px 0 0;
}
#menu ul li:first-child > a:after {
	content: '';
	position: absolute;
	left: 40px;
	top: -6px;
	border-left: 6px solid transparent;
	border-right: 6px solid transparent;
	border-bottom: 6px solid #444;
}
#menu ul ul li:first-child a:after {
	left: -6px;
	top: 50%;
	margin-top: -6px;
	border-left: 0;
	border-bottom: 6px solid transparent;
	border-top: 6px solid transparent;
	border-right: 6px solid #3b3b3b;
}
#menu ul li:first-child a:hover:after {
	border-bottom-color: #04acec;
}
#menu ul ul li:first-child a:hover:after {
	border-right-color: #0299d3;
	border-bottom-color: transparent;
}
#menu ul li:last-child > a {
	-moz-border-radius: 0 0 3px 3px;
	-webkit-border-radius: 0 0 3px 3px;
	border-radius: 0 0 3px 3px;
}
/* Mobile */
#menu-trigger {
	display: none;
}
@media screen and (max-width: 600px) {
	/* nav-wrap */
	#menu-wrap {
		position: relative;
	}
	#menu-wrap * {
		-moz-box-sizing: border-box;
		-webkit-box-sizing: border-box;
		box-sizing: border-box;
	}
	/* menu icon */
	#menu-trigger {
		display: block;
		height: 40px;
		line-height: 40px;
		cursor: pointer;
		padding: 0 0 0 35px;
		border: 1px solid #222;
		color: #fafafa;
		font-weight: bold;
		background-color: #111;
		-moz-border-radius: 6px;
		-webkit-border-radius: 6px;
		border-radius: 6px;
		-moz-box-shadow: 0 1px 1px #777, 0 1px 0 #666 inset;
		-webkit-box-shadow: 0 1px 1px #777, 0 1px 0 #666 inset;
		box-shadow: 0 1px 1px #777, 0 1px 0 #666 inset;
	}
	/* main nav */
	#menu {
		margin: 0;
		padding: 10px;
		position: absolute;
		top: 40px;
		width: 100%;
		z-index: 1;
		background-color: #444;
		display: none;
		-moz-box-shadow: none;
		-webkit-box-shadow: none;
		box-shadow: none;
	}
	#menu:after {
		content: '';
		position: absolute;
		left: 25px;
		top: -8px;
		border-left: 8px solid transparent;
		border-right: 8px solid transparent;
		border-bottom: 8px solid #444;
	}
	#menu ul {
		position: static;
		visibility: visible;
		opacity: 1;
		margin: 0;
		background: none;
		-moz-box-shadow: none;
		-webkit-box-shadow: none;
		box-shadow: none;
	}
	#menu ul ul {
		margin: 0 0 0 20px !important;
		-moz-box-shadow: none;
		-webkit-box-shadow: none;
		box-shadow: none;
	}
	#menu li {
		position: static;
		display: block;
		float: none;
		border: 0;
		margin: 5px;
		-moz-box-shadow: none;
		-webkit-box-shadow: none;
		box-shadow: none;
	}
	#menu ul li {
		margin-left: 20px;
		-moz-box-shadow: none;
		-webkit-box-shadow: none;
		box-shadow: none;
	}
	#menu a {
		display: block;
		float: none;
		padding: 0;
		color: #999;
	}
	#menu a:hover {
		color: #fafafa;
	}
	#menu ul a {
		padding: 0;
		width: auto;
	}
	#menu ul a:hover {
		background: none;
	}
	#menu ul li:first-child a:after, #menu ul ul li:first-child a:after {
		border: 0;
	}
}
@media screen and (min-width: 600px) {
	#menu {
		display: block !important;
	}
}
/* iPad */
.no-transition {
	-webkit-transition: none;
	-moz-transition: none;
	-ms-transition: none;
	-o-transition: none;
	transition: none;
	opacity: 1;
	visibility: visible;
	display: none;
}
#menu li:hover > .no-transition {
	display: block;
}
</style>
</head>
<body>

<div id="menu-wrap">
	<ul id="menu">
		<li> <a href="">家中烂人</a>
			<ul>
				<li> <a href="">对父母大喊大叫</a></li>
				<li> <a href="">对妻子要求严苛</a></li>
				<li> <a href="">懒,甚至懒得照顾自己</a></li>
			</ul>
		</li>
		<li> <a href="">办公室臭虫</a>
			<ul>
				<li> <a href="">厕所里就着屎味抽烟</a></li>
				<li> <a href="">大声语,如入无人之境</a></li>
			</ul>
		</li>
		<li><a href="">缓慢移动的大便</a>
			<ul>
				<li><a href="">公开场合烟味四溢</a></li>
				<li><a href="">堵于要道,做人生抉择</a></li>
			</ul>
		</li>
	</ul>
</div>

<script>
$(function() {
	if ($.browser.msie && $.browser.version.substr(0,1) < 7){
	$('li').has('ul').mouseover(function(){
		$(this).children('ul').css('visibility','visible');
		}).mouseout(function(){
		$(this).children('ul').css('visibility','hidden');
		});
	}

	/* Mobile */
	$('#menu-wrap').prepend('<div id="menu-trigger">Menu</div>');
	$("#menu-trigger").on('click', function(){
		$("#menu").slideToggle();
	});

	// iPad
	var isiPad = navigator.userAgent.match(/iPad/i) != null;
	if (isiPad) $('#menu ul').addClass('no-transition');
});
</script>
</body>
</html>
