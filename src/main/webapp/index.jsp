<%@ page contentType="text/html;charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<title>穷在当下</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@include file="navi.jsp"%>
<script type="text/javascript">
var money=0;
var s = function(m,n){ return (m/n)%100 }
var ran = function getRandom(n){
    return Math.floor(Math.random()*n)
    }
var slice = 5;
var up = true;
$(function(){  
    run();            
    var interval;  
        function run() {  
           interval = setInterval(chat, "100");  
        }  
        function chat() {  
        	if(up){
	        	money++;
        		if(money == 100*slice){
        			up = false;
        		}
        	}else{
	        	money--
        		if(money == 0){
        			up = true;
        		}
        	}
            $('#barbar1').attr("style", "width: "+s(money,ran(slice))+"%");
            $('#barbar2').attr("style", "width: "+s(money,ran(slice))+"%");
            $('#barbar3').attr("style", "width: "+s(money,ran(slice))+"%");
            $('#barbar4').attr("style", "width: "+s(money,ran(slice))+"%");
        }  
}); 

</script>
</head>
<body>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">点我真的没毛用</h4>
      </div>
      <div class="modal-body">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">你点我</button>
        <button type="button" class="btn btn-primary" onclick="alert('叫你点他,还点我,怪我咯?')">←你点他</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="tellAdvice" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">点我真的没毛用</h4>
      </div>
      <div class="modal-body">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">你点我</button>
        <button type="button" class="btn btn-primary" onclick="alert('叫你点他,还点我,怪我咯?')">←你点他</button>
      </div>
    </div>
  </div>
</div>


<div class="jumbotron">
<div class="container">
  <h1 align="center">Hello, world!</h1>
  <h1 align="center">我是程序猿,我很穷!(不要质疑这个事实)</h1>
  <div class="progress">
  <span class="glyphicon glyphicon-jpy" aria-hidden="true"></span>
  <div id="barbar1" class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
  </div></div>
  <div class="progress">
  <span class="glyphicon glyphicon-jpy" aria-hidden="true"></span>
  <div id="barbar2" class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
  </div></div>
  <div class="progress">
  <span class="glyphicon glyphicon-jpy" aria-hidden="true"></span>
  <div id="barbar3" class="progress-bar progress-bar-warning progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
  </div></div>
  <div class="progress">
  <span class="glyphicon glyphicon-jpy" aria-hidden="true"></span>
  <div id="barbar4" class="progress-bar progress-bar-danger progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
  </div>
</div>
  <p align="center"><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">点我没毛用</button></p>
  <br>
  <div class="col-md-2 alert alert-success" role="alert">无聊点点看<span class="glyphicon glyphicon-hand-up" aria-hidden="true"></span>
  	<ul>
	  <li><a href="play/hacker.jsp">黑客帝国效果</a></li>
	  <li><a href="play/1.jsp">跟随鼠标的点点</a></li>
	  <li><a href="play/2.jsp">随意拖动小球球</a></li>
	  <li><a href="play/4.jsp">随意拖拽的小树</a></li>
	  <li><a href="play/5.jsp">女生必备素质</a></li>
	  <li><a href="play/6.jsp">催眠波浪线</a></li>
	  <li><a href="play/7.jsp">那天下着雪</a></li>
	  <!-- <li><a href="play/8.jsp">晃动的大饼</a></li> -->
	  <li><a href="play/9.jsp">疯狂抖动的屏幕</a></li>
	  <li><a href="play/10.jsp">艺术钟表</a></li>
	  <li><a href="play/11.jsp">时尚计时器</a></li>
	  <li><a href="play/12.jsp">微信飞机大战</a></li>
	  <li><a href="play/stopwatch/3.jsp">高级秒表</a></li>
	</ul>
</div>
</div>
</div>
</body>
</html>
<%@include file="foot.jsp"%>