<%@ page contentType="text/html;charset=UTF-8"%>
<html >
<head>
<%@include file="./head.jsp"%>

<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
body{font-family:Arial, "MS Trebuchet", sans-serif;}
#list{margin:0 auto;height:600px;width:600px;overflow:hidden;position:relative;background-color:#000;}
#list a{position:absolute;text-decoration:none;color:#666;}
#list a:hover{color:#ccc;}
</style>

</head>
<body>

	<div id="list">
		<ul>
			<li><a href="#">上得厅堂</a></li>
			<li><a href="#">下得厨房</a></li>
			<li><a href="#">打得过小三</a></li>
			<li><a href="#">斗得过流氓</a></li>
			<li><a href="#">卖的了萌</a></li>
			<li><a href="#">耍得了二</a></li>
			<li><a href="#">扮得了少女</a></li>
			<li><a href="#">演的了女王</a></li>
			<li><a href="#">晒的了下限</a></li>
			<li><a href="#">红的了脸颊</a></li>
			<li><a href="#">玩的了小清新</a></li>
			<li><a href="#">咽得下重口味</a></li>
		</ul>
	</div>

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	var element = $('#list a');
	var offset = 0; 
	var stepping = 0.07;
	var list = $('#list');
	var $list = $(list)
	$list.mousemove(function(e){
		var topOfList = $list.eq(0).offset().top
		var listHeight = $list.height()
		stepping = (e.clientY - topOfList) /  listHeight * 0.2 - 0.1;
	});
	
	for (var i = element.length - 1; i >= 0; i--){
		element[i].elemAngle = i * Math.PI * 2 / element.length;
	}
	
	setInterval(render, 20);
	
	function render(){
		for (var i = element.length - 1; i >= 0; i--){
			var angle = element[i].elemAngle + offset;
			x = 120 + Math.sin(angle) * 30;
			y = 45 + Math.cos(angle) * 40;
			size = Math.round(40 - Math.sin(angle) * 40);
			var elementCenter = $(element[i]).width() / 2;
			var leftValue = (($list.width()/2) * x / 100 - elementCenter) + "px"
			$(element[i]).css("fontSize", size + "pt");
			$(element[i]).css("opacity",size/100);
			$(element[i]).css("zIndex" ,size);
			$(element[i]).css("left" ,leftValue);
			$(element[i]).css("top", y + "%");
		}
		offset += stepping;
	}
	
});
</script>
</body>
</html>
<%@include file="../foot.jsp"%>