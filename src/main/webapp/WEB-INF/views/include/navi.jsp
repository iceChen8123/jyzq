<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/resources/jquery-validation/1.11.1/jquery.validate.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/resources/jquery-validation/1.11.1/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/jquery-validation/1.11.1/jquery.validate.method.min.js" type="text/javascript"></script>
<script type="text/javascript">
function showtips(){
	if($('#message').val()){
		alert($('#message').val());
	}
}
$(document).ready(function() {
	$("#myForm").validate();
	showtips();
});
function newtask(){
	$('#myModal').modal('show');
}
var choicenum = 2;
function addChoice(){
	if(choicenum >= 6){
		alert('u have too much choises.Sorry ~_~');
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
var subject = 'EAT';
function changeSubject(v){
	subject = v;
}
</script>
</head>
<input id="message" value="${message }" hidden="true">
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
        <shiro:lacksRole name="simple"><li><button type="button" class="btn btn-info btn-lg" ><a href="<%=request.getContextPath()%>/login">登录</a></button></li></shiro:lacksRole>
        <li><button type="button" class="btn btn-warning btn-lg" ><a href="<%=request.getContextPath()%>/register">注册</a></button></li>
        <li><button type="button" class="btn btn-default btn-lg" ><a href="<%=request.getContextPath()%>/logout">退出</a></button></li>
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
      	<form method="post" id="myForm" action="<%=request.getContextPath()%>/b/choise/new">
      	  <div class="control-group" >
		    <label for="title" >标题:</label>
		    <input type="text" class="form-control input-lg required" name="title" id="title" placeholder="写得好，大家都会看...">
		  </div>
		  <div class="control-group" >
		    <label for="choiceType" >发愁的事:</label>
		    <c:forEach items="${fns:getChoiceTypes()}" var="ct">
		    	<label class="radio-inline"><input type="radio" name="choiseType" value="${ct.choiceCode }" checked="checked">${ct.choiceName }</label>
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
		  <div class="control-group" >
		    <label for="title" >描述:</label>
		    <input type="text" class="form-control input-lg required" name="choiseDesc" id="choiseDesc" placeholder="详细描述，更有助于大家投票的准确性">
		  </div>
		  <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" >Save</button>
      </div>
		</form>
      </div>
    </div>
  </div>
</div>
</html>