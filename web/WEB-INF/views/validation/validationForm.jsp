<%--
  Created by IntelliJ IDEA.
  User: daeun
  Date: 2018. 7. 20.
  Time: PM 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validation Form</title>
</head>
<body>
<%
    String path = request.getContextPath();
%>
    <form action="<%=path%>/validation/check" method="post">
        ID: <input type="text" name="id"> <br>
        PW: <input type="password" name="pw"> <br>
        NAME: <input type="text" name="name"> <br>
        EMAIL: <input type="email" name="email"> <br>
        <input type="submit" value="가입">
    </form>
</body>
</html>
