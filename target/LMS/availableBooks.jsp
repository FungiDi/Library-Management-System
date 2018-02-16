<%--
  Created by IntelliJ IDEA.
  User: reuben
  Date: 10/27/17
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Available Books</title>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-inverse">

            <div class="navbar-header">
                <a class="navbar-brand" href="#">      Book store</a>
            </div>
            <ul class="nav navbar-nav">
                <li ><a href="memberLogin">Home</a></li>

                <li class="active"><a href="">Available books</a></li>
                <li><a href="viewAllBooks">view Books</a></li>


                <ul class="nav navbar-nav navbar-right">
                    <%--<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>--%>
                    <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>
            </ul>

        </nav>

    </div>
</div>
<div class="container">
    <div class="jumbotron">
        <table class="table table-bordered">
            <tr>
                <thead>
                <td>RegNo</td>
                <td>Title</td>
                <td>Author</td>
                <td>Publisher</td>
                <td>Category</td>

                </thead>
            </tr>
            <c:forEach var="avail" items="${available}">
            <tr>

                <td><c:out value="${avail.bookReg}"></c:out></td>
                <td><c:out value="${avail.title}"></c:out></td>
                <td><c:out value="${avail.auther}"></c:out></td>
                <td><c:out value="${avail.publisher}"></c:out></td>
                <td><c:out value="${avail.bookCategory}"></c:out></td>

            </tr>
            </c:forEach>
    </div>
</div>
</body>
</html>
