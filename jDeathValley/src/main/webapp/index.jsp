<%--
  Created by IntelliJ IDEA.
  User: iddqd
  Date: 1/24/18
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stephan Karsakov lab</title>
</head>
<body>
    <div align="center">
        <h1>Valley Of Death</h1>
        <form name="richest" action="ControllerServlet" method="POST" >
            richest user<br/>
            <input type="text"/>
            <input type="submit" name="bt" value="richest"/>


        </form>

        <form name="byId" action="ControllerServlet" method="POST"  >
            sum accounts<br/>
            <input type="text" name="add an Id" value="id"/>
            <input type="submit" name="bt" value="byId"/>
        </form>
    </div>
</body>
</html>
