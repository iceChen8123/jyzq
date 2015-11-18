<%@ page contentType="text/html;charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"24"},"slide":{"type":"slide","bdImg":"2","bdPos":"right","bdTop":"179.5"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
<script charset="Shift_JIS"src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.js"></script>
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
</div>
</div>
</body>
</html>
