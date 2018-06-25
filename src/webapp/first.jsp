<%--<%@ page import="com.GetStudents" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletRun1</title>
</head>
<body>

<%--<h2> ${mainTable}</h2>--%>
<table border="4" cellpadding="5" cellspacing="4">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>sec_name</td>
        <td>sex</td>
    </tr>
    <c:forEach var="student" items="${studentsList}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.secName}</td>
            <td>${student.sex}</td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="ServletRun" method="get">
    <input type="submit" value="add" name="id"/>
</form>

</body>
</html>
