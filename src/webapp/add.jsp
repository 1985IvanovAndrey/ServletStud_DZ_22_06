<%--
  Created by IntelliJ IDEA.
  User: Dron
  Date: 24.06.2018
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletAdd</title>
</head>
<body>

<h2>Добавление нового студента:</h2>

<form action="ServletAdd" method="get">

    Name     <input type="text" name="name"/>
    <br>
    Sec_name <input type="text" name="secName"/>
    <br>
    Sex      <input type="text" name="sex"/>

    <input type="submit" value="addStudent" name="id"/>
</form>

</body>
</html>
