<%--
  Created by IntelliJ IDEA.
  User: reuben
  Date: 10/31/17
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Admin</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-inverse">

            <div class="navbar-header">
                <a class="navbar-brand" href="#">      Book store</a>
            </div>
            <ul class="nav navbar-nav">
                <li  ><a href="#">Home</a></li>
                <li class="dropdown">
                    <a href="javascript:void(0)" class="dropbtn">ADD</a>
                    <ul>
                        <li>
                            <div class="dropdown-content">
                                <a href="addAdmin">Admin</a>
                                <a href="AddLibrarian">Librarian</a>
                                <a href="addMember">Member</a>
                            </div>

                        </li>
                    </ul>

                </li>
                <li><a href="viewLibrarians">View</a>
                    <ul>
                        <li>
                            <a href="viewAdmin">Admin</a>
                            <a href="viewLibrarians">Librarian</a>
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
    <form action="deleteAdmin" method="post">
        Staff No:<input type="text" name="regNo" value="<%=session.getAttribute("aId")%>">
        First name:<input type="text" name="fname" value="<%=session.getAttribute("firstName")%>">
        Last name:<input type="text" name="lName" value="<%=session.getAttribute("lastName")%>">
        Email:<input type="text" name="em" value="<%=session.getAttribute("aEmail")%>">
        Gender:<input type="text" name="gen" value="<%=session.getAttribute("aGender")%>">
        <input type="submit" value="Delete">
    </form>`
</div>
</body>
</html>
