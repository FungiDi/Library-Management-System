<%--
  Created by IntelliJ IDEA.
  User: reuben
  Date: 10/29/17
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <head>
        <title>Welcome</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
<body>
<style>
    .nav ul {
        position: absolute;
        white-space: nowrap;
        border-bottom: 5px solid  orange;
        z-index: 1;
        left: -99999em;

    }
    .nav > li:hover > ul {
        left: auto;
        margin-top: 5px;
        min-width: 100%;


    }
    .nav > li li:hover > ul {
        left: 100%;
        margin-left: 1px;
        top: -1px;
        position: relative;
        display: block;
    }
    /* arrow hover styling */
    .nav > li > a:first-child:nth-last-child(2):before {
        border-top-color: #aaa;
        position: relative;
        display: block;
    }
    .nav > li:hover > a:first-child:nth-last-child(2):before {
        border: 5px solid transparent;
        border-bottom-color: orange;
        margin-top:-5px;
        position: relative;
        display: block;

    }
    .dropdown:hover .dropdown-content {
        display: block;
    }
    /*.nav li li > a:first-child:nth-last-child(2):before {*/
        /*border-left-color: #aaa;*/
        /*margin-top: -5px;*/
        /*position: relative;*/
        /*display: block;*/
    /*}*/
    /*.nav li li:hover > a:first-child:nth-last-child(2):before {*/
        /*border: 5px solid transparent;*/
        /*border-right-color: orange;*/
        /*right: 10px;*/
        /*position: relative;*/
        /*display: block;*/
    /*}*/
</style>
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

                <li><a href="#">Edit</a>
                    <ul>
                        <li>
                            <a href="editAdmin">Admin</a>
                            <a href="editLibrarian">Librarian</a>
                            <a href="adminEditMember">Member</a>
                        </li>
                    </ul>
                </li>
                <li><a href="borrowBook">Delete</a>
                    <ul>
                        <li>
                            <a href="deleteAdmin">Admin</a>
                            <a href="deleteLibrarian">Librarian</a>
                            <a href="deleteMember">Member</a>
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
</div>>

</body>
</html>
