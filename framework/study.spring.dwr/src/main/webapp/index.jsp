<%@ page language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>My JSP 'first_dwr.jsp' starting page</title>
        <script type='text/javascript' src='dwr/util.js'></script>
        <script type='text/javascript' src='dwr/engine.js'></script>
        <script type='text/javascript' src='dwr/interface/service.js'> </script>
        <script type='text/javascript' src='dwr/interface/hello.js'> </script>
        <script type="text/javascript">
            function firstDwr(){
                service.sayHello("Jorwen",callBackHello);
            }
            function callBackHello(data){
                alert(data);
            }

            function sayGoodBye(){
                service.sayGoodBye("zhouxh", callBackGoodBye);
            }

            function callBackGoodBye(data){
                alert(data);
            }

            function getUser(){
                hello.getUser("zhouxh",callBackGetUser);
            }

            function callBackGetUser(data){
                alert(data);
            }
        </script>
    </head>
    <body>
        <input type="button" name="button" value="测试" onclick="firstDwr()">
        <input type="button" name="button" value="sayGoodBye" onclick="sayGoodBye()">
        <input type="button" name="button" value="getUser" onclick="getUser()">
    </body>
</html>