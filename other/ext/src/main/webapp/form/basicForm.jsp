<%-- 
    Document   : basicForm.jsp
    Created on : 2009-11-18, 16:21:44
    Author     : zhouxh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
String currentParentPath = contextPath + "/form";
%>
<html>
    <head>
        <title>A tradional form</title>
        <jsp:include page="/commons/jspHeadInclude.jsp"></jsp:include>
        <!-- Include your own Javascript file here - adapt the filename to your filename-->
        <script type="text/javascript" src="<%=currentParentPath%>/basicForm.js"></script>
    </head>
    <body>
       <div id="mytraditionalform"></div>
    </body>
</html>

