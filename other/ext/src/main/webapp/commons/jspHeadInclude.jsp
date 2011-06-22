<%String contextPath = request.getContextPath(); %>

<!-- The following line defines content type and utf-8 as character set. -->
<!-- If you want your application to work flawlessly with various local -->
<!-- characters, just make ALL strings, on the page, json and database utf-8. -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- Ext relies on its default css so include it here. -->
<!-- This must come BEFORE javascript includes! -->
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/ext/resources/css/ext-all.css">

<!-- Include here your own css files if you have them. -->

<!-- First of javascript includes must be an adapter... -->
<script type="text/javascript" src="<%=contextPath%>/ext/adapter/ext/ext-base.js"></script>

<!-- ...then you need the Ext itself, either debug or production version. -->
<script type="text/javascript" src="<%=contextPath%>/ext/ext-all-debug.js"></script>