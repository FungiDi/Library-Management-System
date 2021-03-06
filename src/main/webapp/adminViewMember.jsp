<%--
  Created by IntelliJ IDEA.
  User: reuben
  Date: 11/1/17
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Members</title>
    <head>
        <title>Admins</title>
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
                <li class="active" ><a href="#">Home</a></li>
                <li class="dropdown">
                    <a href="javascript:void(0)" class="dropbtn">ADD</a>
                    <ul>
                        <li>
                            <div class="dropdown-content">
                                <a href="addAdmin">Admin</a>
                                <a href="AddLibrarian">Librarian</a>
                                <a href="adminAddMember">Member</a>
                            </div>

                        </li>
                    </ul>

                </li>
                <li><a href="viewLibrarians">View</a>
                    <ul>
                        <li>
                            <a href="viewAdmin">Admin</a>
                            <a href="adminViewLibrarian">Librarian</a>
                            <a href="adminViewMember">Member</a>
                        </li>
                    </ul>
                </li>

            </ul>
            Login<ul class="nav navbar-nav navbar-right">
            <%--<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>--%>
            <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
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
                <td>Name</td>
                <td>email</td>
                <td>Gender</td>
                <td>Membership Type</td>


                </thead>
            </tr>
            <c:forEach var="all" items="${memb}">
            <tr>

                <td><c:out value="${all.memberRegNo}"></c:out></td>
                <td><c:out value="${all.firstName}">
                </c:out><c:out value="${all.lastName}"></c:out></td>
                    <%--<td></td>--%>
                <td><c:out value="${all.email}"></c:out></td>
                <td><c:out value="${all.gender}"></c:out></td>
                <td><c:out value="${all.membershipType}"></c:out></td>

                <form action="editMemberOne" method="post">
                    <input type="hidden" name="staffregNo" value="${all.memberRegNo}">
                    <td><input type="submit" value="Edit"></td>
                </form>
                <form action="deleteMemberOne" method="post">
                    <input type="hidden" name="staffregNo" value="${all.memberRegNo}">
                    <td><input type="submit" value="Delete"></td>
                </form>

            </tr>
            </c:forEach>
    </div>
</div>

</body>
</html>
