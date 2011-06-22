<%@page contentType="text/html" pageEncoding="utf-8"%>
<%response.setCharacterEncoding("utf-8"); %>
{
success: true, 
info:'你刚刚提交的数值是:<font color=\"red\"><%=request.getParameter("input")%></font><br/> 提交时间:<%=new java.util.Date()%>'
}