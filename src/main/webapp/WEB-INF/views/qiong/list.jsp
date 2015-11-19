<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/WEB-INF/views/include/include.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/scrollpagination/datapage.js"></script>
<script type="text/javascript">
var pageNo = 0;
var divnum = 0;
$(function(){
	$('#scrollpaginationdemo').scrollPagination({
		'contentPage': "<%=request.getContextPath()%>/qiong/qiongren/get", // the url you are fetching the results
		'contentData': {pageNo:pageNo}, // these are the variables you can pass to the request, for example: children().size() to know which page you are
		'scrollTarget': $(window), // who gonna scroll? in this example, the full window
		'heightOffset': 10, // it gonna request when scroll is 10 pixels before the page ends
 		'beforeLoad': function(){ // before load function, you can display a preloader div
			$('#loading').fadeIn();	
		},
 		'afterLoad': function(data){ // after loading content, you can use this function to animate your new elements
			$.each(data, function(i, n){
				var page = n.title+':'+n.desc+'<br>';
         		$('#div'+divnum).html(page);
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
 <strong>哪有这么多穷人...</strong>
 </div>
</body>
</html>
