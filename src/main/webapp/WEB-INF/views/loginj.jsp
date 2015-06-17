<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>用户登录</title>
<%@include file="/WEB-INF/views/include/head.jsp"%>
<script type="text/javascript">
function browserRedirect() {
    var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) {
        $('#browser1').show();
        $('#dsshow').hide();
    }
}

$(document).ready(function() {
	$("#myForm").validate();
});

var duoshuoQuery = {
	       short_name: "jyzq", 
	       sso: { 
	           login: "http://www.jyzq.pub/loginfromds/", //替换为你自己的回调地址
	           logout: "http://www.jyzq.pub/tologout" //替换为你自己的回调地址
	       }};
</script>
</head>
<body>
<div hidden="true" id="browser1" name="browser1">
	<p class="bg-info " style="font-family: '幼圆'" >陛下,你是高科技移动端用户,请用本站的用户名登录.</p>
	</div>
<div class="col-md-2" ></div>
<div class="col-md-6" >
	<form:form action="login" commandName="user" method="post" id="myForm">
		<div class="control-group">
			<label class="control-label" for="username">用户名</label>
			<div class="controls">
				<form:input path="userName" class="required" maxlength="40" minlength="5" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="password">密码</label>
			<div class="controls">
				<form:input type="password" path="password" class="required"
					placeholder="密码" minlength="6" />
			</div>
		</div>
		<div class="footer" >
                    <label class="checkbox inline" hidden="true">
                        <input type="checkbox" id="rememberMe" name="rememberMe" checked="checked" hidden="true"> 
                    </label>
                    <input class="btn btn-primary" type="submit" value="登 录"/>
                    <input class="btn btn-default" type="button" onclick="window.location.href='<%=request.getContextPath()%>/register'" value="注册"/>
                </div>
	</form:form>
	<div id="dsshow">
	<div class="ds-login"> </div> 
	</div>
	</div>
	<script type="text/javascript">
	browserRedirect();
	</script>
</body>
</html>