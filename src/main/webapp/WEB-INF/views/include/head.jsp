<%@ page contentType="text/html;charset=UTF-8" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Cache-Control" content="max-age=3600" />
<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"24"},"slide":{"type":"slide","bdImg":"2","bdPos":"right","bdTop":"179.5"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
<html>
<head>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/jyzq.png" type="image/x-icon" />
<meta name="keywords" content="纠友自取,纠结,选择困难症,选择恐惧症,纠结是我的态度,咎由自取,choose,choise" />
<meta name="description" content="纠友相聚,分外亲.我为人人，人人为我" />
<meta name="author" content="ice">
<title>纠友自取</title>
<script type="text/javascript">
var duoshuoQuery = {short_name:"jyzq"};
(function() {
	var ds = document.createElement('script');
	ds.type = 'text/javascript';ds.async = true;
	ds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.js';
	ds.charset = 'UTF-8';
	(document.getElementsByTagName('head')[0] 
	 || document.getElementsByTagName('body')[0]).appendChild(ds);
})();
function getonlinenumber(){
	$.ajax({    
        type:'post',        
        url:'',    
        data:{},    
        cache:false,    
        dataType:'json',    
        success:function(data){
			$('#onlinenumber').html(data.onlinenumber);
        }    
    });    
}
$(document).ready(function(){  
	//getonlinenumber();
	 //setInterval("getonlinenumber()", 2000);  
	}); 
</script>
</head>
<div class="page-header">
<div class="container-fluid directional" >
  <div class="col-md-11"><h1 align="center" style="font-family: '幼圆'"><a href="<%=request.getContextPath()%>">纠友自取</a></h1></div>
  <div class="col-md-1">&nbsp;</div>
  <!-- <div class="col-md-11">&nbsp;</div>
  <div class="col-md-1"><h6 align="right" style="vertical-align: bottom;">
  <span style="font-family: '幼圆'">在线纠友:<span id="onlinenumber"></span></span> </h6>
  </div> -->
</div>
</div>
<%@include file="/WEB-INF/views/include/navi.jsp"%>
</html>