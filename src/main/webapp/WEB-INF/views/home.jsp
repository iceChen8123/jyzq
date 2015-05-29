<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<title>JYZQ</title>
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
                        text: n.title
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
