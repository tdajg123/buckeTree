<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BUCKETREE</title>
<tiles:insertAttribute name="header" />
</head>
<body>
	<tiles:insertAttribute name="menubar" />
	<tiles:insertAttribute name="content" />
	<tiles:insertAttribute name="chat_popup" />
	<tiles:insertAttribute name="footer" />
</body>
</html>