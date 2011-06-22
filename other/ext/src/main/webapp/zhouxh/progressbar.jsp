<%-- 
    Document   : progressbar
    Created on : 2009-11-18, 15:57:36
    Author     : zhouxh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="/commons/jspHeadInclude.jsp"></jsp:include>
<script type="text/javascript" src="progressbar.js"></script>
<title>ProgressBar</title>
</head>
<body>
<div id='status'></div>
<div id="progressBar"></div>
<div><button id="waitButton">wait</button></div>
<div id="waitBar"></div>
</body>
</html>
