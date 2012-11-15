<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Author Page</title>
    <meta name="layout" content="main"/>
</head>

<body>

<g:each in="${books}" var="book">
    <div>Book Title : ${book?.title} ,  Author : ${book?.author?.name}</div>

</g:each>
<p>Time Taken to Execute this Query : <strong>${timeTaken}</strong></p>
</body>
</html>