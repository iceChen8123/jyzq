<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ page import="com.ctrip.paymentweb.common.beanvalidator.BeanValidators"%>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%@ page import="com.ctrip.paymentweb.common.utils.StringUtils" %>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%response.setStatus(200);%>
<%
	Throwable ex = null;
	if (exception != null)
		ex = exception;
	if (request.getAttribute("javax.servlet.error.exception") != null)
		ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
	//记录日志
	if (ex!=null){
		Logger logger = LoggerFactory.getLogger("500.jsp");
		logger.error(ex.getMessage(), ex);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>500 - 系统内部错误</title>
	<%@include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header"><h1>系统发生内部错误.</h1></div>
        <div><a href="javascript:" onclick="history.go(-1);" class="btn">返回上一页</a></div>
		<p>错误信息：</p><p>
		<%
			if (ex!=null){
				if (ex instanceof javax.validation.ConstraintViolationException){
					for (String s : BeanValidators.extractPropertyAndMessageAsList((javax.validation.ConstraintViolationException)ex, ": ")){
						out.print(s+"<br/>");
					}
				}else{
                    StringWriter sw = new StringWriter();
                    ex.printStackTrace(new PrintWriter(sw));
                    String exStr = org.apache.commons.lang.StringUtils.replace(sw.toString(),"\n\t","<br/>");
                    out.print(exStr+"<br/>");
                }
			}
		%>
		</p>
		<script>try{top.$.jBox.closeTip();}catch(e){}</script>
	</div>
</body>
</html>