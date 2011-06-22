<%@ page language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>My JSP 'first_dwr.jsp' starting page</title>
        <script type='text/javascript' src='dwr/util.js'></script>
        <script type='text/javascript' src='dwr/engine.js'></script>
        <script type='text/javascript' src='dwr/interface/service.js'> </script>
        <script type="text/javascript">
            function firstDwr(){
                service.sayHello("Jorwen",callBackHello);
            }
            function callBackHello(data){
                alert(data);
            }
        </script>
    </head>
    <body>
        <input type="button" name="button" value="测试" onclick="firstDwr()">
    </body>
</html>