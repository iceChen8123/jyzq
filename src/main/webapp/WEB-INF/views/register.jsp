<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>用户注册</title>
<%@include file="/WEB-INF/views/include/head.jsp"%>
<script type="text/javascript">
function setdsid(){
	if($('#dsid').val()){
		$('#dsId').val($('#dsid').val());
	}
	$('#regform').attr('action','<%=request.getContextPath()%>/register');
	$('#regform').submit();
}
</script>
</head>
<body>
<div class="col-md-2" ></div>
<div class="col-md-6" >
<input hidden="true" value="${dsid }" id="dsid">
	<form:form id="regform" commandName="user" method="post" onsubmit="setdsid()">
	<form:input name="dsId" id="dsId" hidden="true" path="dsId" />
		<div class="control-group">
			<label class="control-label" for="username">用户名</label>
			<div class="controls">
				<form:input path="userName" class="required" maxlength="40" minlength="6" />(6个以上字母或数字)
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="password">密码</label>
			<div class="controls">
				<form:input type="password" path="password" class="required"
					placeholder="密码"  maxlength="40" minlength="6"  />(6个以上字母或数字)
			</div>
		</div>
		<div class="footer" >
			<div class="controls">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="保存" />&nbsp;
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>