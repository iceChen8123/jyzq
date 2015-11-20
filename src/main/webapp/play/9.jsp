<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@include file="./head.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/shake/main.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/shake/jshaker.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.block').click(function() {
			$(this).jshaker();
		});
	});
</script>

<!--必要样式-->
<style type="text/css">
#content .block {
	float: left;
	border: 1px solid #CCCCCC;
	background: #F0F0F0;
	padding: 10px;
	margin: 10px;
	width: 300px;
}
</style>

</head>
<body>
	<div id="content">
		<div class="block">
			<p>
				<strong>Duo ne laudem essent feugait, nonumy delenit
					legendos usu id.</strong> <span>Usu timeam invenire moderatius cu,</span>
				cum tale harum alterum ne, an pro senserit euripidis efficiendi. <span>Lorem
					ipsum vix ad albucius maluisset rationibus, mea eirmod</span> eleifend
				repudiare et.
			</p>
			<p>
				Ferri albucius appareat pro id, <span>qui aliquam feugait
					quaestio eu,</span> ne pri natum docendi voluptatum. <em>Cu tale
					atomorum laboramus usu, summo causae iriure cu pri.</em>
			</p>
			<p>
				Pro facer audiam vituperatoribus ei, mea liber pertinax
				mediocritatem eu, <span>qui ut vituperatoribus option malis.</span>
				<span>Nisl eligendi recusabo sed in, ut sint veri efficiendi
					mel.</span>
			</p>
		</div>

		<div class="block">
			<p>Idque atqui convenire quo et, vel justo civibus explicari no.
				Idque atqui convenire quo et, vel justo civibus explicari no. Te
				clita doctus facilis ius, vix movet nonummy luptatum an.</p>
			<p>Ferri albucius appareat pro id, qui aliquam feugait quaestio
				eu, ne pri natum docendi voluptatum. Cu tale atomorum laboramus usu,
				summo causae iriure cu pri.</p>
		</div>

		<div class="block">
			<p>Ullum alienum accusata an nam, ea per stet altera scaevola,
				nostro appareat comprehensam eam ea. Mel quod ipsum appetere ea, ex
				vis quod amet idque.</p>
			<ul>
				<li>Item 1</li>
				<li>Item 2</li>
				<li>Item 3
					<ul>
						<li>Sub Item 1</li>
						<li>Sub Item 2</li>
						<li>Sub Item 3</li>
						<li>Sub Item 4</li>
						<li>Sub Item 5</li>
					</ul>
				</li>
				<li>Item 4</li>
				<li>Item 5</li>
			</ul>
		</div>

		<div class="block">
			<img src="<%=request.getContextPath()%>/resources/shake/123.jpg"
				width="600" height="406" alt="美女" />
		</div>
	</div>
</body>
</html>