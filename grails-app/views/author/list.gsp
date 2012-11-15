<%--
  Created by IntelliJ IDEA.
  User: prakash
  Date: 15/11/12
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Authors List</title>
    <meta name="layout" content="main"/>

</head>

<body>

<h3>Author Name : ${author?.name}</h3>

<div>
    <table>
        <th>
            Book Title
        </th>
        <g:each in="${bookTitles}" var="bookTitle">
            <tr><td>
                ${bookTitle}
            </td></tr>
        </g:each>
    </table>

    <p>Time Taken to Execute this Query : <strong>${timeTaken}</strong></p>
</div>
</body>
</html>