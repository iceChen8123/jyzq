<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<script src="<%=request.getContextPath()%>/resources/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/resources/jquery-validation/1.11.1/jquery.validate.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/resources/jquery-validation/1.11.1/jquery.validate.min.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath()%>/resources/jquery-validation/1.11.1/jquery.validate.method.min.js" type="text/javascript"></script>
<script type="text/javascript">
function listchoisetype(){
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/b/choisetype/get',    
        data:{},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	$.each(data, function(i, n){
         		if(n.valid == 1){
        			$('#choiseCode').append("<option value=\""+ n.choiseCode+"\" selected=\"selected\">"+n.choiseName+"</option>");
        		}
        	});
        }    
    });    
}
function listcity(){
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/b/city/get',    
        data:{},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	$.each(data, function(i, n){
        		$('#cityId').append("<option value=\""+ n.id+"\" selected=\"selected\">"+n.cityName+"</option>");
        	});
        }    
    });    
}
function changeSubjects(){
	var choiseCode = $('#choiseCode').val();
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/b/subject/getbychoisecode',    
        data:{choiseCode:choiseCode},    
        cache:false,    
        dataType:'json',    
        success:function(data){
    		$('#subjectId').empty();
        	$.each(data, function(i, n){
        		$('#subjectId').append("<option value=\""+ n.id+"\">"+n.subjectName+"</option>");
        	});
        }    
    });    
}
function initSubjects(){
	if($('#subjectId').val()){
		return;
	}
	var choiseCode = $('#choiseCode').val();
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/b/subject/getbychoisecode',    
        data:{choiseCode:choiseCode},    
        cache:false,    
        dataType:'json',    
        success:function(data){
    		$('#subjectId').empty();
        	$.each(data, function(i, n){
        		$('#subjectId').append("<option value=\""+ n.id+"\">"+n.subjectName+"</option>");
        	});
        }    
    });    
}
var cityId;
var address;
function getlatestaddressinfo(){
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/b/choise/getlatestaddressinfo',    
        data:{},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	cityId = data.cityId;
        	address = data.address;
        }    
    });    
}
function showtips(){
	if($('#message').val()){
		alert($('#message').val());
	}
}
var subject = 'food';
function changeSubject(){
	//alert($('#subject').val());
	//if($('#subject').val()){
		subject = $('#subject').val();
	//}
}
$(document).ready(function() {
	$("#myForm").validate();
	showtips();
	changeSubject();
	listcity();
});
function newtask(){
	listchoisetype();
	$('#myModal').modal('show');
}
var choicenum = 2;
function addChoice(){
	if(choicenum >= 6){
		alert('我+_+ 这么多纠结，我们也无能为力了  ~_~');
		return;
	}
	choicenum++;
	var content = "<input type='text' class='form-control input-lg required' name='choiceList"+choicenum+"' id='choiceList"+choicenum+"' placeholder='你的选择?'>";
	$("#choiceInput").append(content); 
	if(choicenum == 6){
		$('#moreButton').val('不能再多了#_#');
		$('#moreButton').attr("disabled", true);
	}
} 
</script>
</head>
<input id="message" value="${message }" hidden="true">
<input id="subject" value="${subject }" hidden="true">
<nav class="navbar navbar-inverse" >
  <div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<c:forEach items="${fns:getChoiceTypes()}" var="ct">
        	<li><a href="<%=request.getContextPath()%>/choise?type=${ct.choiseCode }" )">${ct.choiseName }</a></li>
      	</c:forEach>
      		<li><a href="<%=request.getContextPath()%>/choise/list" )">随便看看</a></li>
        	<li><a href="<%=request.getContextPath()%>/b/advice" )">用着不爽</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><button type="button" class="btn btn-success btn-lg" onclick="newtask()" >神,帮帮我</button></li>
        <shiro:notAuthenticated><li><button type="button" class="btn btn-info btn-lg" ><a href="<%=request.getContextPath()%>/login">登录</a></button></li>
        <li><button type="button" class="btn btn-warning btn-lg" ><a href="<%=request.getContextPath()%>/register">注册</a></button></li></shiro:notAuthenticated>
        <shiro:authenticated><li><button type="button" class="btn btn-info btn-lg" ><a href="<%=request.getContextPath()%>/b/choise/history/my">纠结史</a></button></li></shiro:authenticated>
        <shiro:hasRole name="admin"><li><button type="button" class="btn btn-info btn-lg" ><a href="<%=request.getContextPath()%>/b/manage">我叫后门</a></button></li></shiro:hasRole>
        <shiro:hasRole name="admin"><li><button type="button" class="btn btn-info btn-lg" ><a href="<%=request.getContextPath()%>/b/advice/get">好建议</a></button></li></shiro:hasRole>
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
        <h4 class="modal-title" id="myModalLabel">撕心裂肺的纠结</h4>
      </div>
      <div class="modal-body">
      	<form method="post" id="myForm" action="<%=request.getContextPath()%>/b/choise/new">
      	  <div class="control-group" >
		    <label for="title" >标题(吸引大家帮你投票，写好点哦):</label>
		    <input type="text" class="form-control input-lg required" name="title" id="title" placeholder="写得好，大家都会看...">
		  </div>
		  <div class="control-group" >
		    <label for="choiceType" >发愁的事:</label>
		    <select class="form-control input-lg required" id="choiseCode" name="choiseCode" onchange="changeSubjects()">
		    </select>
		  </div>
		  <div class="control-group" >
		    <label for="subjectId" >再具体点:</label>
		    <select class="form-control input-lg required" id="subjectId" name="subjectId" onclick="initSubjects()">
		    </select>
		  </div>
		  <div class="control-group" >
		    <label for="cityId" >所在城市:</label>
		    <select class="form-control input-lg required" id="cityId" name="cityId" >
		    </select>
		  </div>
		  <div class="control-group" >
		    <label for="address" >地址:</label>
		     <input type="text" class="form-control input-lg" name="address" id="address" placeholder="选填，大致位置，方便大家投票时判断">
		  </div>
		  <div class="control-group">
		    <label for="choiceList">纠结的东东:</label>
		  </div>
		  <div class="control-group" id="choiceInput">
		    <input type="text" class="form-control input-lg required" name="choiceList1" id="choiceList1" placeholder="你的选择?">
		    <input type="text" class="form-control input-lg required" name="choiceList2" id="choiceList2" placeholder="你的选择?">
		  </div>
		  <div class="control-group">
		    <input id="moreButton" type="button" class="form-control input-lg" value="我还有其他纠结的..." onclick="addChoice()">
		  </div>
		  <div class="control-group" >
		    <label for="title" >描述:</label>
		    <input type="text" class="form-control input-lg" name="choiseDesc" id="choiseDesc" placeholder="详细描述，更有助于大家投票的准确性">
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