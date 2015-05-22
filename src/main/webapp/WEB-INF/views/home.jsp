<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<title>JYZQ</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/WEB-INF/views/include/head.jsp"%>
<script src="resources/highcharts.js"></script>
<script type="text/javascript">
function getPie(){
	// Build the chart
 	for (var a = 1; a < 13; a++) {
 		$('#test'+a).highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: 'title'
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
                name: 'Browser share',
                data: [
                    ['Firefox',   10*Math.random()],
                    ['IE',       10*Math.random()],
                    {
                        name: 'Chrome',
                        y: 10*Math.random(),
                        sliced: true,
                        selected: true
                    },
                    ['Safari',    10*Math.random()],
                    ['Opera',     10*Math.random()],
                    ['Others',   10*Math.random()]
                ]
            }]
        });
 	}
 	// end charts
}
function getOnline(){
	for (var a = 1; a < 30; a++) {
 		$('#onlineP').append("<li>Cras justo odio</li>");
 	}
}
	$(document).ready(function() {
		//getPie();
		getOnline();
	});
</script>
</head>
<body>
	<div class="col-md-9" >
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
	<div id="test12" class="col-md-2" ></div>
	</div>
	<div class="col-md-2" >
	<div class="panel panel-default">
		<div class="panel-heading"><h3 class="panel-title">online</h3></div>
		<div class="panel-body">
		<ul id="onlineP">
		</ul>
		  </div>
		  </div>
	</div>
</body>
</html>
<body>
</body>
</html>