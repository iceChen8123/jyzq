<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/WEB-INF/views/include/include.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#uploadForm").validate();
		listcity();
	});
	
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
	
	function commitUpload(){
		var title = $('#title').val();
		var cityId = $('#cityId').val();
		var descMe = $('#descMe').val();
	    $.ajax({    
	        type:'post',        
	        url:'<%=request.getContextPath()%>/qiong/upload',    
	        data:{title:title,cityId:cityId,descMe:descMe},    
	        cache:false,    
	        dataType:'json',    
	        success:function(data){
	        	if(data.code != 0){
	        		alert(data.reason);
	        	}else{
	        		location.href = '<%=request.getContextPath()%>/qiong/list';
	        	}
	        }    
	    });    
	}
</script>
</head>
<body>
<div class="modal-body">
<!--       	<form method="post" id="uploadForm" enctype="multipart/form-data"> -->
      	<form method="post" id="uploadForm" >
      	  <div class="control-group" >
		    <label for="title" >你哪穷?</label>
		    <input type="text" class="form-control input-lg required" name="title" id="title" placeholder="穷的买不起山东煎饼~~~~穷的娶不起老婆~_~">
		  </div>
		  <div class="control-group" >
		    <label for="cityId" >穷在何方:</label>
		    <select class="form-control input-lg required" id="cityId" name="cityId" >
		    </select>
		  </div>
		  <!-- <div class="control-group">
			 <label for="file">来张照片(图片小于4M):</label>
	    	 <input type="file" id="file" name="file">
	    	 <p class="help-block">不打算晒晒自己有多穷吗???</p>
	    	 </div> -->
		  <div class="control-group" >
		    <label for="descMe" >说说那些穷事吧:</label>
		  	<textarea class="form-control input-lg required" rows="3" name="descMe" id="descMe" placeholder="我是一个小屌丝~咿呀咿呀哟~"></textarea>
		  </div>
		  <div class="modal-footer">
        	<button type="button" class="btn btn-primary" onclick="commitUpload()">提交</button>
      		</div>
		</form>
      </div>
</body>
</html>
