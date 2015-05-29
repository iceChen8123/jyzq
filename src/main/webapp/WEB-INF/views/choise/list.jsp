<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/WEB-INF/views/include/head.jsp"%>
<%-- <script src="<%=request.getContextPath()%>/resources/jquery/jquery-1.9.1.min.js" type="text/javascript"></script> --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/scrollpagination/datapage.js"></script>
<script src="<%=request.getContextPath()%>/resources/highcharts.js"></script>
<script type="text/javascript">
var pageNo = 0;
var divnum = 0;
$(function(){
	$('#scrollpaginationdemo').scrollPagination({
		'contentPage': "<%=request.getContextPath()%>/choise/some/get", // the url you are fetching the results
		'contentData': {choiseType:subject, pageNo:pageNo}, // these are the variables you can pass to the request, for example: children().size() to know which page you are
		'scrollTarget': $(window), // who gonna scroll? in this example, the full window
		'heightOffset': 10, // it gonna request when scroll is 10 pixels before the page ends
/* 		'beforeLoad': function(){ // before load function, you can display a preloader div
			$('#loading').fadeIn();	
		},
 */		'afterLoad': function(data){ // after loading content, you can use this function to animate your new elements
			$.each(data, function(i, n){
        		var seriesdata = [];
        		$.each(n.choiseAndVote, function(it, a){
        			seriesdata[it] = [a.choise, parseInt(a.vote)];
        		});
         		$('#div'+divnum).highcharts({
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
         		var index = divnum+1;
         		$('#div'+divnum).after("<div id=\"div"+index+"\" class=\"col-md-2\" ></div>");
         		divnum++;
        	});
			 $('#content').append(data); 
			 var objectsRendered = $('#content').children('[rel!=loaded]');
			 $(objectsRendered).fadeInWithDelay();
		}
	});
	// code for fade in element by element
	$.fn.fadeInWithDelay = function(){
		var delay = 0;
		return this.each(function(i,n){
			$(this).delay(delay).animate({opacity:1}, 200);
			delay += 100;
		});
	};
		   
});
$(document).ready(function() {
	$('#nomore').hide();
});
</script>
</head>
<body>
<div id="scrollpaginationdemo" class="col-md-12">
	<div id="div0" class="col-md-2" ></div>
    <div id="loading">loading...........</div>
</div>
<div id="nomore" align="center">
 <strong>No More</strong>
 </div>
</body>
</html>
