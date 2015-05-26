<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@include file="/WEB-INF/views/include/head.jsp"%>
</head>
<body>
<div class="col-md-2" ></div>
<div class="col-md-6" >
	<form:form action="register" commandName="user" method="post">
		<div class="control-group">
			<label for="username">用户名</label>
			<div class="controls">
				<form:input path="userName" class="required" />
			</div>
		</div>
		<div class="control-group">
			<label for="password">密码</label>
			<div class="controls">
				<form:input type="password" path="password" class="required"
					placeholder="密码" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="保存" />&nbsp;
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>