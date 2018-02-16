<%--
  Created by IntelliJ IDEA.
  User: reuben
  Date: 10/23/17
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Staff</title>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<form method="post" action="AddStaff">
    Staff No:<input type="text" name="regNo">
    First Name:<input type="text" name="fname">
    Last Name:<input type="text" name="lname">
    Gender:<select name="gen">
    <option>Male</option>
    <option>Female</option>
</select>
    Staff Type:<input type="text" name="sType">
    email Address:<input type="email" name="email">
    Password:<input type="password" name="pass">
    <input type="submit" value="Submit">
</form>

</body>
</html>
