<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>用户登录</title>
<%@include file="/WEB-INF/views/include/head.jsp"%>
<script type="text/javascript">
function listchoisetype(){
	var code = $('#code');
    $.ajax({    
        type:'post',        
        url:'http://api.duoshuo.com/oauth2/access_token',    
        data:{code:code},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	alert(data);
        }    
    });    
}
$(document).ready(function() {
	listchoisetype();
});

</script>
</head>
<body>
<input id="code" value="${code }">
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
	<div class="ds-login"> </div>
	</div>
</body>
</html>