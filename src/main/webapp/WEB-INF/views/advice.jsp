<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/WEB-INF/views/include/head.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#adviceForm").validate();
	});
</script>
</head>
<body>
<div class="modal-body">
      	<form method="post" id="adviceForm" action="<%=request.getContextPath()%>/b/advice">
      	  <div class="control-group" >
		    <label for="title" >主题:</label>
		    <input type="text" class="form-control input-lg required" name="title" id="title" placeholder="比如:这个地方看着好不爽">
		  </div>
		  <div class="control-group" >
		    <label for="advice" >描述:</label>
		  	<textarea class="form-control input-lg required" rows="3" name="advice" id="advice" placeholder="哪里用着不爽呢？或者，你还有好的想法及建议，只要你告诉我，我就尽量帮你做到！"></textarea>
		  </div>
		  <div class="modal-footer">
        	<button type="submit" class="btn btn-primary" >提交</button>
      		</div>
		</form>
      </div>
</body>
</html>
