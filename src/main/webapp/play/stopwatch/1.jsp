<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@include file="../head.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/stopwatch/st1/style.css" media="screen" type="text/css" />
</head>
<body>

<input id="help" class="help" name="controls" type="checkbox" />
<input id="settings" class="settings" name="controls" type="checkbox" />

<input id="orange" class="orange"  name="color" type="radio"  />
<input id="green" class="green"  name="color" type="radio" checked="checked" />

<div class="stopwatch">

	<input id="start" class="start" name="controls" type="radio" />
	<input id="stop" class="stop" name="controls" type="radio" />
	<input id="reset" class="reset" name="controls" type="radio" />

	<div class="container">
		<div class="arrow_cont">
			<div class="arrow"></div>
		</div>
	
		<div class="digit_contianer">
			<div class="animcont">
				<div class="hours">0 1 2 3 4 5 6 7 8 9</div>
			</div>
			<div class="animcont">
				<div class="hours">0 1 2 3 4 5 6 7 8 9</div>
			</div>
			<div class="space">:</div>
			<div class="animcont">
				<div class="min1">0 1 2 3 4 5</div>
			</div>
			<div class="animcont">
				<div class="min">0 1 2 3 4 5 6 7 8 9</div>
			</div>
			<div class="space">:</div>
			<div class="animcont">
				<div class="sec1">0 1 2 3 4 5</div>
			</div>
			<div class="animcont">
				<div class="sec">0 1 2 3 4 5 6 7 8 9</div>
			</div>
			<div class="space">:</div>	
			<div class="animcont">
				<div class="mil0">0 1 2 3 4 5 6 7 8 9</div>
			</div>
			<div class="animcont">
				<div class="mil1">0 1 2 3 4 5 6 7 8 9</div>
			</div>
			<div class="animcont">
				<div class="mil">0 1 2 3 4 5 6 7 8 9</div>
			</div>
		</div>
		<div class="controls">
			<label class="stop_" id="haptic" for="stop"></label>
			<label id="haptic2" class="start_" for="start"></label>
			<label id="haptic3" class="reset_" for="reset"></label>
		</div>
	</div>
	
</div>

</body>
</html>