<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/3/22
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>

<!--%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
-->
<%@include file="/header.jsp"%>
This is my JSP page.<br>
<h1>New User Registration</h1>
<form method="post" action="Register">
    <table>
        <tr> <td>Username:</td> <td><input type="text" name="Username" required><br/></td></tr>
        <tr> <td>password:</td> <td><input type="password" name="password" required minlength="8"><br/></td></tr>
        <tr> <td>Email:</td> <td><input type="email" name="Email" required><br/></td></tr>
        <tr>
            <td>Gender:</td>
            <td>
                <input type="radio" name="Gender" value="Male" checked="checked"/> Male <!-- checked="checked"默认选择项 -->
                <input type="radio" name="Gender" value="Female"/> Female
            </td>
        </tr>
        <tr> <td>Date of Birth:</td> <td><input type="date" name="Date" required dataformatas="yyyy-dd-mm"><br/></td></tr>
        <tr> <td></td><td><input type="submit" value="Register"/></td>  </tr>
    </table>
</form>
<%@include file="/footer.jsp"%>
