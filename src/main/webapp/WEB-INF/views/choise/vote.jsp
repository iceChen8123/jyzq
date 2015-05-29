<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<title>JYZQ</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/WEB-INF/views/include/head.jsp"%>
<script src="<%=request.getContextPath()%>/resources/highcharts.js"></script>
<script type="text/javascript">
function showtips(){
	if($('#message').val()){
		alert($('#message').val());
	}
}
	$(document).ready(function() {
		showtips();
		genpie();
	});
function genpie(){
	var id = $('#id').val();
	var btnType =['btn-primary','btn-success','btn-info','btn-warning','btn-danger','btn-default'];
	
	$.ajax({    
        type:'get',        
        url:'<%=request.getContextPath()%>/choise/get',    
        data:{id: id},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        		var seriesdata = [];
        		$.each(data.choiseAndVote, function(i, a){
        			seriesdata[i] = [a.choise, parseInt(a.vote)];
        			$('#onlineP').append("<li><button type=\"button\" class=\"btn "+btnType[i]+" btn-lg\" onclick=\"vote('"+a.choise+"')\">"+ a.choise +"</button></li>");
        		});
         		$('#test0').highcharts({
         			credits:{
         				text:data.title,
         				href: "<%=request.getContextPath()%>/b/choise/vote?id="+data.id
         			},
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    },
                    subtitle:{
                    	text: data.choiseDesc
                    },
                    title: {
                        text: data.title
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
                        name: data.choiseType,
                        data: seriesdata
                    }]
                });
        }    
    });
}
function vote(s){
	var choise = s;
	var id = $('#id').val();
	$.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/b/choise/vote',    
        data:{id:id,choise:choise},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	alert(data);
        	location.reload();
        }    
    });    
}
</script>
</head>
<body>
<input id="message" value="${message }" hidden="true">
<input id="id" value="${id }" hidden="true">
	<div id="test0" class="col-md-12" ></div>
	<div id="test1" class="col-md-12" >
	<ul id="onlineP">
		</ul>
	</div>
</body>
</html>
