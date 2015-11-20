<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@include file="../head.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/resources/stopwatch/st4/countdown.css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/stopwatch/st4/countdown.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/stopwatch/st4/flip_counter.js"></script>
<script type="text/javascript">
(function($){
	$(function(){
		var endTime = new Date($('#flip-counter').data('date'));
		var finished = false;
		var countdown = $.Countdown({
			endTime:endTime,
			afterFinish: function() {
				finished = true;
			}
		});
		var myCounter = new flipCounter('flip-counter', {
			dateFormat:true,
			value:countdown.toString(),
			auto:false,
			tFH:20,
			bFH:20,
			bOffset:200,
			fW:30,
			speed:40
			});
		var intervalId = setInterval(function() {
			if (finished) {
				clearInterval(intervalId);
				return;
			}
			countdown.update();
			myCounter.setValue(countdown.toString())
		}, 1000);
	});
})(jQuery)
</script>
</head>
<body>

<div id="hero_outer">
	
	<div id="flip-counter" class="flip-counter" data-date="june 19,2016 00:00:00"></div>

</div>

</body>
</html>

