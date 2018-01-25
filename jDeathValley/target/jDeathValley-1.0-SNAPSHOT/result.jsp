<%--
  Created by IntelliJ IDEA.
  User: iddqd
  Date: 1/24/18
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>result</title>
</head>
<body>
    <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>Result of query</h2></caption>
                <tr>
                    <th>Name</th>
                    <th>SureName</th>
                    <th>Sum of all accounts</th>
                    <th>List of AccountId:</th>
                </tr>
                <tr>
                    <td><c:out value="${nameResult}"/></td>
                    <td><c:out value="${sureNameResult}"/></td>
                    <td><c:out value="${resultSum}"/></td>
                    <td><%--AccountIds in one cell:--%>
                        <c:forEach begin="0" end="${fn:length(resultArray) - 1}" var="index">
                            <c:out value="${resultArray[index]}"/>
                            <br/>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        <a href="index.jsp">return to previous page</a>
    </div>
</body>
</html>
