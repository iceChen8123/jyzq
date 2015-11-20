<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@include file="../head.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/stopwatch/st2/materialize.min.css">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/stopwatch/st2/styles.css">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/stopwatch/st2/jquery.timepicker.css">


<script src="<%=request.getContextPath()%>/resources/stopwatch/st2/materialize.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/stopwatch/st2/jquery.timepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/stopwatch/st2/hammer.js"></script>
<script src="<%=request.getContextPath()%>/resources/stopwatch/st2/script.js"></script>
<script src="<%=request.getContextPath()%>/resources/stopwatch/st2/alarm.js"></script>
<script src="<%=request.getContextPath()%>/resources/stopwatch/st2/stopwatch.js"></script>
<script src="<%=request.getContextPath()%>/resources/stopwatch/st2/timer.js"></script>
</head>
<body>

<div class="wrapper">

	<header class="switch-clocks z-depth-1">
		<a class="alarm waves-effect">报警</a>
		<a class="stopwatch waves-effect">秒表</a>
		<a class="timer waves-effect">计时器</a>
	</header>

	<div class="app">

		<div class="container alarm hidden">
			<form>

				<div class="control input-field">
					<input id="alarm-input" type="text" class="validate">
					<label for="alarm-input">设置时间</label>
				</div>

				<div class="control switch">
					<label>
						关闭
						<input type="checkbox" disabled id="alarm-btn">
						<span class="lever"></span>
						开启
					</label>
				</div>

				<div class="control checkbox">
					<input type="checkbox" id="alarm-sounds" />
					<label for="alarm-sounds">声音</label>
				</div>

			</form>

			<div class="clock z-depth-1 inactive">
				<span>取消设置</span>
				<div class="overlay waves-effect"></div>
			</div>
		</div>

		<div class="container stopwatch">
			<form>
				<a id="stopwatch-btn-start" class="waves-effect waves-teal btn-flat">开始</a>
				<a id="stopwatch-btn-pause" class="waves-effect waves-teal btn-flat">暂停</a>
				<a id="stopwatch-btn-reset" class="waves-effect waves-teal btn-flat">重置</a>
			</form>

			<div class="clock inactive z-depth-1">
				<span>0:00:00.0</span>
				<div class="overlay waves-effect"></div>
			</div>
		</div>

		<div class="container timer hidden">
			<form>
				<div class="control input-field">
					<input id="timer-input" type="number">
					<label for="timer-input">分钟</label>
				</div>

				<a class="timer-btn start waves-effect"><i class="mdi-av-play-arrow"></i></a>
				<a class="timer-btn pause waves-effect"><i class="mdi-av-pause"></i></a>
				<a class="timer-btn reset waves-effect"><i class="mdi-av-replay"></i></a>

				<div class="control checkbox">
					<input type="checkbox" id="timer-sounds" />
					<label for="timer-sounds">声音</label>
				</div>

			</form>

			<div class="clock inactive z-depth-1 waves-effect">0:00</div>
		</div>


	</div>

	<div id="times-up-modal" class="modal">
		<div class="modal-content">
			<h3>时间到了!</h3>
		</div>
		<div class="modal-footer">
			<a href="#!" class="dismiss-alarm-sounds modal-action waves-effect waves-red btn-flat">关闭闹钟</a>
		</div>
	</div>

</div>



</body>
</html>
