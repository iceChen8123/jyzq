<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>用户登录</title>
<%@include file="/WEB-INF/views/include/head.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
	$("#myForm").validate();
});
</script>
</head>
<body>
<div class="col-md-2" ></div>
<div class="col-md-6" >
	<form:form action="login" commandName="user" method="post" id="myForm">
		<div class="control-group">
			<label for="username">用户名</label>
			<div class="controls">
				<form:input path="userName" class="required" maxlength="40" minlength="5" />
			</div>
		</div>
		<div class="control-group">
			<label for="password">密码</label>
			<div class="controls">
				<form:input type="password" path="password" class="required"
					placeholder="密码" minlength="6" />
			</div>
		</div>
		<div class="footer">
                    <label class="checkbox inline">
                        <input type="checkbox" id="rememberMe" name="rememberMe"> <span style="color:#08c;">记住我</span>
                    </label>
                    <input class="btn btn-primary" type="submit" value="登 录"/>
                </div>
	</form:form>
	</div>
</body>
</html>