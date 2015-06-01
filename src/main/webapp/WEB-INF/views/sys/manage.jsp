<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/WEB-INF/views/include/head.jsp"%>
<script src="<%=request.getContextPath()%>/resources/highcharts.js"></script>
<script type="text/javascript">
function getchoisetype(){
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/b/choisetype/get',    
        data:{},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	$.each(data, function(i, n){
        		var date = new Date(n.createTime).toLocaleString();
        		var o;
        		if(n.valid == 0){
        			o = "<a href=\"<%=request.getContextPath()%>/b/choiseType/renew?id="+ n.id+"\">reopen</a>";
        		}else{
        			o = "<a href=\"<%=request.getContextPath()%>/b/choiseType/del?id="+ n.id+"\">delete</a>";
        		}
         		$('#choisetypeB').append("<tr><td>"+ o+ "</td><td>"+ n.choiseCode+"</td><td>"+ n.choiseName+"</td><td>"+ n.valid+"</td><td>"+ date+"</td></tr>");
        	});
        }    
    });    
}
function getsubject(){
    $.ajax({    
        type:'post',        
        url:'<%=request.getContextPath()%>/b/subject/get',    
        data:{},    
        cache:false,    
        dataType:'json',    
        success:function(data){
        	$.each(data, function(i, n){
        		var date = new Date(n.createTime).toLocaleString();
        		var o;
        		if(n.valid == 0){
        			o = "<a href=\"<%=request.getContextPath()%>/b/choiseSubject/renew?id="+ n.id+"\">reopen</a>";
        		}else{
        			o = "<a href=\"<%=request.getContextPath()%>/b/choiseSubject/del?id="+ n.id+"\">delete</a>";
        		}
         		$('#choisesubjectB').append("<tr><td>"+ o+ "</td><td>"+ n.choiseCode+"</td><td>"+ n.subjectName+"</td><td>"+ n.expiredTime+"</td><td>"+ n.voteArea+"</td><td>"+ n.valid+"</td><td>"+ date+"</td></tr>");
        	});
        }    
    });    
}
function newchoisetype(){
	$('#choisetypeModal').modal('show');
}
function newchoisesubject(){
	$('#choisesubjectModal').modal('show');
}
	$(document).ready(function() {
		$("#choiseTypeForm").validate();
		$("#choiseSubjectForm").validate();
		getchoisetype();
		getsubject();
	});
</script>
</head>
<body>
	<div class="col-md-6" >
	<table class="table table-hover table-bordered" id="choisetypeT">
	<thead>
		<tr><th>o</th><th>choiseCode</th><th>choiseName</th><th>valid</th><th>createTime</th></tr>
	</thead>
	  <tbody id="choisetypeB">
	  </tbody>
	  <tfoot><tr align="right"><td colspan="5"><input type="button" class="btn btn-lg" onclick="newchoisetype()" value="新建choisetype"></td></tr></tfoot>
	</table>
	</div>
	<div class="col-md-6" >
	<table class="table table-hover table-bordered" id="subjectT">
	  <thead>
		<tr><th>o</th><th>choiseCode</th><th>subjectName</th><th>expiredTime</th><th>voteArea</th><th>valid</th><th>createTime</th></tr>
		</thead>
	  <tbody id="choisesubjectB">
	  </tbody>
	  <tfoot><tr align="right"><td colspan="7"><input type="button" class="btn btn-lg" onclick="newchoisesubject()" value="新建choisesubject"></td></tr></tfoot>
	</table>
	</div>
	
	<!-- choiseTypeForm -->
<div class="modal fade" id="choisetypeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">choiseType新增</h4>
      </div>
      <div class="modal-body">
      	<form method="post" id="choiseTypeForm" action="<%=request.getContextPath()%>/b/choiseType/new">
      	  <div class="control-group" >
		    <label for="choiseCode" >choiseCode:</label>
		    <input type="text" class="form-control input-lg required" name="choiseCode" id="choiseCode" placeholder="choiseCode">
		  </div>
      	  <div class="control-group" >
		    <label for="choiseName" >choiseName:</label>
		    <input type="text" class="form-control input-lg required" name="choiseName" id="choiseName" placeholder="choiseName">
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
<!-- choiseTypeForm end -->

	<!-- choiseSubjectForm -->
<div class="modal fade" id="choisesubjectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">choiseType新增</h4>
      </div>
      <div class="modal-body">
      	<form method="post" id="choiseSubjectForm" action="<%=request.getContextPath()%>/b/choiseSubject/new">
      	  <div class="control-group" >
		    <label for="choiseCode" >choiseCode:</label>
		    <input type="text" class="form-control input-lg required" name="choiseCode" id="choiseCode" placeholder="choiseCode">
		  </div>
      	  <div class="control-group" >
		    <label for="subjectName" >subjectName:</label>
		    <input type="text" class="form-control input-lg required" name="subjectName" id="subjectName" placeholder="subjectName">
		  </div>
      	  <div class="control-group" >
		    <label for="expiredTime" >subjectName:</label>
		    <input type="text" class="form-control input-lg required" name="expiredTime" id="expiredTime" placeholder="expiredTime">
		  </div>
      	  <div class="control-group" >
		    <label for="voteArea" >voteArea:</label>
		    <input type="text" class="form-control input-lg required" name="voteArea" id="voteArea" placeholder="voteArea">
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
<!-- choiseSubjectForm end -->
</body>
</html>
