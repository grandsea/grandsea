<%-- 
    Document   : editorGridPanel
    Created on : 2009-11-19, 14:02:29
    Author     : zhouxh
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="/commons/jspHeadInclude.jsp"></jsp:include>
<script type="text/javascript" src="messageBox.js"></script>
<script type="text/javascript"
	src="../../ext/examples/shared/examples.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../ext/examples/shared/examples.css" />
<style type="text/css">
.x-window-dlg .ext-mb-download {
	background: transparent
		url(../../ext/examples/message-box/images/download.gif) no-repeat top left;
	height: 46px;
}
</style>
<title>Windows</title>
</head>
<body>
<div>
<button id="confirmButton">confirm</button>
</div>
<div>
<button id="promptButton">promptButton</button>
</div>
<div>
<button id="multiLinePromptButton">multiLinePromptButton</button>
</div>
<div>
<button id="yesNoCancelButton">yesNoCancelButton</button>
</div>
<div>
<button id="progressButton">progressButton</button>
</div>
<div>
<button id="waitButton">waitButton</button>
</div>
<div>
<button id="alertButton">alertButton</button>
</div>
<p>
<b>Icons</b><br/>
Standard alert with optional icon.
<select id="icons">
	<option id="error" selected="selected">Error</option>
	<option id="info">info</option>
	<option id="question">question</option>
	<option id="warning">warning</option>
</select>
</p>
<div>
<button id="iconButton">iconButton</button>
</div>
</body>
</html>
