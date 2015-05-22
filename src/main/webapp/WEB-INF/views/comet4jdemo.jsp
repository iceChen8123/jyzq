<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Comet4J Hello World</title>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<script type="text/javascript" src="resources/comet4j.js"></script>
<script type="text/javascript">
	function init() {
		var kbDom = document.getElementById('kb');
		JS.Engine.on('hello', function(kb) {//侦听一个channel
			kbDom.innerHTML = kb;
		});
		JS.Engine.start('conn');
	}
</script>
</head>
<body onload="init()">
	后台信息:
	<span id="kb">nothing here.</span>
</body>
</html>

<body>
</body>
</html>