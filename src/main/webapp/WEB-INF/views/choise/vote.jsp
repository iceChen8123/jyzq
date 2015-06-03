<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/WEB-INF/views/include/head.jsp"%>
<script src="<%=request.getContextPath()%>/resources/highcharts.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
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
        		$('#choiseinfo').append("<li>"+data.title+"</li>");
        		$('#choiseinfo').append("<li>"+data.city+"</li>");
        		if(data.address){
        		$('#choiseinfo').append("<li>"+data.address+"</li>");
        		}
        		$('#choiseinfo').append("<li>"+new Date(data.createTime).toLocaleString()+"</li>");
        		var seriesdata = [];
        		$.each(data.choiseAndVote, function(i, a){
        			seriesdata[i] = [a.choise+'('+ parseInt(a.vote)+ ')', parseInt(a.vote)];
        			$('#onlineP').append("<li><button type=\"button\" class=\"btn "+btnType[i]+" btn-lg\" onclick=\"vote('"+a.choise+"','"+ data.subjectId+ "')\">"+ a.choise +"</button></li>");
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
                        name: data.choiseCode,
                        data: seriesdata
                    }]
                });
        }    
    });
}
function vote(c,sid){
	var choise = c;
	var subjectId = sid;
	var id = $('#id').val();
	$.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/b/choise/vote',    
        data:{id:id,subjectId:subjectId,choise:choise},    
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
<input id="id" value="${id }" hidden="true">
	<div class="col-md-3" >
		<ul id="choiseinfo">
		</ul>
	</div>
	<div id="test0" class="col-md-9" ></div>
	<div id="test1" class="col-md-12" >
	<ul id="onlineP">
		</ul>
	</div>
</body>
</html>
