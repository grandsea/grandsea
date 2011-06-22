<%-- 
    Document   : grid
    Created on : 2009-11-18, 15:07:49
    Author     : zhouxh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
String contextPath = request.getContextPath();
String currentParentPath = contextPath + "/zhouxh";
%>
<html>
    <head>
        <jsp:include page="/commons/jspHeadInclude.jsp" flush="true" />
        <script type="text/javascript" src="<%=currentParentPath%>/simpleStore.js">
        </script>
        <title>Grid Test</title>
    </head>
    <body>
        <div id="basicGrid"></div>
    </body>
</html>
