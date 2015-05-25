<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<html>
<head>
<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
<link href="resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<link href="resources/jquery-validation/1.11.1/jquery.validate.min.css" type="text/css" rel="stylesheet" />
<script src="resources/jquery-validation/1.11.1/jquery.validate.min.js" type="text/javascript"></script>
<script src="resources/jquery-validation/1.11.1/jquery.validate.method.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#myForm").validate({
        submitHandler:function(form){
            form.submit();
        }
    });
});
function newtask(){
	$('#myModal').modal('show');
}
function login(){
	$('#login').modal('show');
}
var choicenum = 2;
function addChoice(){
	if(choicenum >= 6){
		alert('u have too much choice.Sorry ~_~');
		return;
	}
	choicenum++;
	var content = "<input type='text' class='form-control input-lg required' name='choiceList"+choicenum+"' id='choiceList"+choicenum+"' placeholder='你的选择?'>";
	$("#choiceInput").append(content); 
	if(choicenum == 6){
		$('#moreButton').val('NO MORE');
		$('#moreButton').attr("disabled", true);
	}
} 
var subject = '';
function changeSubject(v){
	subject = v;
}
</script>
</head>
<nav class="navbar navbar-inverse" >
  <div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<c:forEach items="${fns:getChoiceTypes()}" var="ct">
        	<li><a href="${ct.choiceCode }" )">${ct.choiceName }</a></li>
      	</c:forEach>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><button type="button" class="btn btn-success btn-lg" onclick="newtask()" >helpme</button></li>
        <li><button type="button" class="btn btn-info btn-lg" onclick="login()">登录</button></li>
        <li><button type="button" class="btn btn-warning btn-lg">注册</button></li>
        <li><button type="button" class="btn btn-default btn-lg">退出</button></li>
      </ul>
    </div>
  </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">HAPPY TITLE</h4>
      </div>
      <div class="modal-body">
      	<form method="post" id="myForm" action="choise/new">
		  <div class="control-group" >
		    <label for="choiceType" >发愁的事:</label>
		    <c:forEach items="${fns:getChoiceTypes()}" var="ct">
		    	<label class="radio-inline"><input type="radio" name="choiceType" value="${ct.choiceCode }">${ct.choiceName }</label>
		    </c:forEach>
		  </div>
		  <div class="control-group">
		    <label for="choiceList">choice:</label>
		  </div>
		  <div class="control-group" id="choiceInput">
		    <input type="text" class="form-control input-lg required" name="choiceList1" id="choiceList1" placeholder="你的选择?">
		    <input type="text" class="form-control input-lg required" name="choiceList2" id="choiceList2" placeholder="你的选择?">
		  </div>
		  <div class="control-group">
		    <input id="moreButton" type="button" class="form-control input-lg" value="Give Me More" onclick="addChoice()">
		  </div>
		  <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" id="newChoise">Save changes</button>
      </div>
		</form>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Login</h4>
      </div>
      <div class="modal-body">
            <form id="loginForm"  class="form login-form" action="login" method="post">
                <div class="body">
					<div class="control-group">
						<label for="username">登录名</label>
						<div class="controls">
							<input type="text" id="username" name="username" class="required" value="${username}" placeholder="登录名">
						</div>
					</div>
					<div class="control-group">
						<label for="password">密码</label>
						<div class="controls">
							<input type="password" id="password" name="password" class="required" placeholder="密码"/>
						</div>
					</div>
                </div>
                <div class="footer">
                    <input class="btn btn-primary" type="submit" value="登 录"/>
                </div>
            </form>
            </div>
        </div>
    </div>
</div>

</html>