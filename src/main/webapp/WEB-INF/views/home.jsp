<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/WEB-INF/views/include/head.jsp"%>
<script src="<%=request.getContextPath()%>/resources/highcharts.js"></script>
<script type="text/javascript">
function getPie(){
	var choiseType = subject;
	$.ajax({    
        type:'get',        
        url:'<%=request.getContextPath()%>/choise/some/get',    
        data:{choiseType: choiseType,pageNo:0},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	$.each(data, function(i, n){
        		var seriesdata = [];
        		$.each(n.choiseAndVote, function(it, a){
        			seriesdata[it] = [a.choise, parseInt(a.vote)];
        		});
         		$('#test'+i).highcharts({
         			credits:{
         				text:n.title,
         				href: "<%=request.getContextPath()%>/b/choise/vote?id="+n.id
         			},
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    },
                    title: {
                        text: n.title,
                        style:{color:"#333333",fontSize:"12px"}
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: false
                            },
                            showInLegend: true
                        }
                    },
                    series: [{
                        type: 'pie',
                        name: n.choiseType,
                        data: seriesdata
                    }]
                });
        	});
        }    
    });    
}
function getOnline(){
    $.ajax({    
        type:'get',        
        url:'<%=request.getContextPath()%>/online/some/get',    
        data:{},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	alert(data);
        	$.each(data, function(i, n){
         		$('#onlineP').append("<li>"+n+"</li>");
        	});
        }    
    });    
}
	$(document).ready(function() {
		getPie();
		//getOnline();
	});
	function tomore(){
		location.href='<%=request.getContextPath()%>/choise/list?type='+subject;
	}
</script>
</head>
<body>
<div>
<!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Example headline.</h1>
              <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Another example headline.</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>One more for good measure.</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->

</div>
	<div class="col-md-12" >
	<div id="test0" class="col-md-2" ></div>
	<div id="test1" class="col-md-2" ></div>
	<div id="test2" class="col-md-2" ></div>
	<div id="test3" class="col-md-2" ></div>
	<div id="test4" class="col-md-2" ></div>
	<div id="test5" class="col-md-2" ></div>
	<div id="test6" class="col-md-2" ></div>
	<div id="test7" class="col-md-2" ></div>
	<div id="test8" class="col-md-2" ></div>
	<div id="test9" class="col-md-2" ></div>
	<div id="test10" class="col-md-2" ></div>
	<div id="test11" class="col-md-2" ></div>
	</div>
	<!-- <div class="col-md-2" >
	<div class="panel panel-default">
		<div class="panel-heading"><h3 class="panel-title">online</h3></div>
		<div class="panel-body">
		<ul id="onlineP">
		</ul>
		  </div>
		  </div>
	</div> -->
	<div class="col-md-4" ></div>
	<div class="col-md-4" >
	<button type="button" class="btn btn-primary btn-lg btn-block" onclick="tomore()">MORE</button>
	</div>
	<div class="col-md-4" ></div>
</body>
</html>
