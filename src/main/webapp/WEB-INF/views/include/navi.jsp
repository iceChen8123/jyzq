<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Cache-Control" content="max-age=3600" />
<script src="<%=request.getContextPath()%>/resources/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/resources/jquery-validation/1.11.1/jquery.validate.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/resources/jquery-validation/1.11.1/jquery.validate.min.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath()%>/resources/jquery-validation/1.11.1/jquery.validate.method.min.js" type="text/javascript"></script>
<script type="text/javascript">
var checkSubmitFlg = false;
function checkSubmit() {
 if (!checkSubmitFlg) {
// 第一次提交
  checkSubmitFlg = true;
  return true;
 } else {

//重复提交
  return false;
 }
}
function listchoisetype(){
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/choisetype/get',    
        data:{},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	$('#choiseCode').empty();
        	$.each(data, function(i, n){
         		if(n.valid == 1){
        			$('#choiseCode').append("<option value=\""+ n.choiseCode+"\" selected=\"selected\">"+n.choiseName+"</option>");
        		}
        	});
        }    
    });    
}
function getlatestaddressinfo(){
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/b/choise/getlatestaddressinfo',    
        data:{},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	$('#cityId').val(data.cityId);
        	$('#address').val(data.address);
        }    
    });    
}
function listcity(){
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/city/get',    
        data:{},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	$.each(data, function(i, n){
        		if(cityId == n.id){
	        		$('#cityId').append("<option value=\""+ n.id+"\" selected=\"selected\">"+n.cityName+"</option>");
        		}else{
	        		$('#cityId').append("<option value=\""+ n.id+"\" >"+n.cityName+"</option>");
        		}
        	});
        }    
    });    
}
function changeSubjects(){
	var choiseCode = $('#choiseCode').val();
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/subject/getbychoisecode',    
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
        url:'<%=request.getContextPath()%>/subject/getbychoisecode',    
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
function showtips(){
	if($('#message').val()){
		$('#allllinfo').html($('#message').val());
		$('#allll').show();
		//alert($('#message').val());
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
	checkiflogin();
	getlatestaddressinfo();
	listchoisetype();
	$('#myModal').modal('show');
}
function checkiflogin(){
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/checkiflogin',    
        data:{},    
        cache:false,    
        dataType:'json',    
        success:function(data){
    		if(data == 'false'){
    			location.href = '<%=request.getContextPath()%>/login?message=pleaseloginfirst';
    		}
        }    
    });    
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
function chooseforme(){
	$("#myForm").attr('action', "<%=request.getContextPath()%>/b/choise/chooseforme");
	$("#myForm").submit();
}
</script>
</head>
<input id="message" value="${message }" hidden="true">
<input id="subject" value="${subject }" hidden="true">
<nav class="navbar navbar-inverse" >
      <ul class="nav navbar-nav nav-pills ">
      	<c:forEach items="${fns:getChoiceTypes()}" var="ct">
        	<li style="font-family: '幼圆'"><a href="<%=request.getContextPath()%>/choise?type=${ct.choiseCode }" )">${ct.choiseName }</a></li>
      	</c:forEach>
      		<li style="font-family: '幼圆'"><a href="<%=request.getContextPath()%>/choise/list" )">随便看看</a></li>
        	<li style="font-family: '幼圆'"><a href="<%=request.getContextPath()%>/b/advice" )">用着不爽</a></li>
      </ul>
      <ul class="nav navbar-nav nav-pills navbar-right">
        <li style="font-family: '幼圆'"><button type="button" class="btn btn-success btn-lg" onclick="newtask()" >神,帮帮我</button></li>
        <shiro:lacksPermission name="login"><li style="font-family: '幼圆'"><button type="button" class="btn btn-info btn-lg" onclick="window.location.href='<%=request.getContextPath()%>/login'" >登录</button></li>
        <li style="font-family: '幼圆'"><button type="button" class="btn btn-warning btn-lg"  onclick="window.location.href='<%=request.getContextPath()%>/register'" >注册</button></li></shiro:lacksPermission>
        <shiro:hasRole name="simple"><li style="font-family: '幼圆'"><button type="button" class="btn btn-info btn-lg" onclick="window.location.href='<%=request.getContextPath()%>/b/choise/history/my'">纠结史</button></li></shiro:hasRole>
        <shiro:hasRole name="admin"><li style="font-family: '幼圆'"><button type="button" class="btn btn-info btn-lg"  onclick="window.location.href='<%=request.getContextPath()%>/b/manage'">我叫后门</button></li></shiro:hasRole>
        <shiro:hasRole name="admin"><li style="font-family: '幼圆'"><button type="button" class="btn btn-info btn-lg"  onclick="window.location.href='<%=request.getContextPath()%>/b/advice/get'">好建议</button></li></shiro:hasRole>
        <li style="font-family: '幼圆'"><button type="button" class="btn btn-default btn-lg" onclick="window.location.href='<%=request.getContextPath()%>/tologout'" >退出</button></li>
      </ul>
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
      	<form method="post" id="myForm" action="<%=request.getContextPath()%>/b/choise/new" onsubmit="return checkSubmit();">
      	  <div class="control-group" >
		    <label for="title" >标题:</label>
		    <input type="text" class="form-control input-lg required" data-toggle="tooltip" data-placement="top" title="吸引大家帮你投票，写好点哦" name="title" id="title" placeholder="写得好，大家都会看...">
		  </div>
		  <div class="control-group" >
		    <label for="choiceType" >发愁的事:</label>
		    <select class="form-control input-lg required" data-toggle="tooltip" data-placement="top" title="为了这玩意,老纠结了*_*" id="choiseCode" name="choiseCode" onchange="changeSubjects()">
		    </select>
		  </div>
		  <div class="control-group" >
		    <label for="subjectId" >再具体点:</label>
		    <select class="form-control input-lg required" data-toggle="tooltip" data-placement="top" title="这个没啥用,看着选吧,哈哈~_~" id="subjectId" name="subjectId" onclick="initSubjects()">
		    </select>
		  </div>
		  <div class="control-group" >
		    <label for="cityId" >所在城市:</label>
		    <select class="form-control input-lg required" id="cityId" name="cityId" >
		    </select>
		  </div>
		  <div class="control-group" >
		    <label for="address" >地址:</label>
		     <input type="text" class="form-control input-lg" data-toggle="tooltip" data-placement="top" title="填下哦,帮你投票的小伙伴,可能就在周围呢^_^" name="address" id="address" placeholder="选填，大致位置，方便大家投票时判断">
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
		    <input type="text" class="form-control input-lg" data-toggle="tooltip" data-placement="top" title="陛下,就请您勉为其难的写点什么吧...." name="choiseDesc" id="choiseDesc" placeholder="详细描述，更有助于大家投票的准确性">
		  </div>
		  <div class="modal-footer">
        <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="top" title="系统随机帮你挑一个,不用等,快快滴@_@" onclick="chooseforme()" >随机个</button>
        <button type="submit" class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="丢给大家投票去" >丢给大家</button>
      </div>
		</form>
      </div>
    </div>
  </div>
</div>
<div class="alert alert-info alert-dismissible" id="allll" role="alert" hidden="true">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	<strong id="allllinfo"></strong>
</div>
</html>