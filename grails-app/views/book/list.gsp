<%--
  Created by IntelliJ IDEA.
  User: prakash
  Date: 15/11/12
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

<g:each in="${books}" var="book">
    <div>Book Title : ${book?.title} ,  Author : ${book?.author?.name}</div>

</g:each>
<p>Time Taken to Execute this Query : <strong>${timeTaken}</strong></p>
</body>
</html>