<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@include file="../head.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="<%=request.getContextPath()%>/resources/stopwatch/st3/style.css" rel="stylesheet" type="text/css">

</head>
<body>

<div class="container">
  <div class="frame">
    <div class="go pause" id="watch">
      <div class="blur-top"></div>
      <div class="face">
        <div class="row-1">
          <div class="timer">
            <span id="timer_min">00</span>
            <span>:</span>
            <span id="timer_sec">01</span>
            <span>.</span>
            <span id="timer_mil">44</span>
          </div>
          <div class="time">
            <span id="time_mins">14</span>
            <span>:</span>
            <span id="time_hours">17</span>
          </div>
        </div>
        <div class="row-2">
          <div class="clock c c1">
            <i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i>
            <span class="inner-cover"></span>
            <i></i><i></i><i></i>
            <span class="outer-cover"></span>
            <div class="ns ns1">
              <b>05</b><b>10</b><b>15</b><b>20</b><b>25</b><b>30</b>
            </div>
            <span class="pin"></span>
            <span class="hand"></span>
          </div>
          <div class="clock c c2">
            <i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i>
            <span class="inner-cover"></span>
            <i></i><i></i><i></i><i></i><i></i><i></i>
            <span class="outer-cover"></span>
            <div class="ns ns2">
              <b>15</b><b>30</b><b>45</b><b>60</b>
            </div>
            <span class="pin"></span>
            <span class="hand"></span>
          </div>
          <div class="clock d c3">
            <i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i><i></i>
            <span class="inner-cover"></span>
            <i></i><i></i><i></i><i></i><i></i>
            <span class="outer-cover"></span>
            <div class="ns ns3">
              <b>1</b><b>2</b><b>3</b><b>4</b><b>5</b><b>6</b><b>7</b><b>8</b><b>9</b><b>0</b>
            </div>
            <span class="pin"></span>
            <span class="hand"></span>
          </div>
        </div>
        <div class="row row-3">
          <div class="lap_timer">
            <span id="lap_min">00</span>
            <span>:</span>
            <span id="lap_sec">00</span>
            <span>.</span>
            <span id="lap_mil">63</span>
          </div>
        </div>
        <div class="canvasContainer">
          <canvas id="graph" width="185" height="73"></canvas>
        </div>
        <div id="avg_time"></div>
        <div class="lap_numbers_container">
          <div id="lap_numbers"></div>
        </div>
        <div class="ctrls">
          <a class="" href="#start" id="start">开始</a>
          <a href="#stop" id="stop" class="hide">停止</a>
          <a href="#reset" id="reset" class="">重置</a>
          <a class="hide" href="#lap" id="lap">计时</a>
        </div>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript" src="<%=request.getContextPath()%>/resources/stopwatch/st3/script.js"></script>


</body>
</html>
<%@include file="../../foot.jsp"%>