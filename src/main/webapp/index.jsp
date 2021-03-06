<html>
<head>
<title>Pulen LMS</title>
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
                <a class="navbar-brand" href="#">     Welcome to Book store</a>
            </div>
            <ul class="nav navbar-nav"></ul>
        </nav>
    </div>
</div>
<div>
    <ul><a href="adminLogin">Login as Admin</a> </ul>
</div>
<%=session.getAttribute("errorMessage")%>
<div class="container">

    <div class="col-md-6">
        <h2>Librarian Login</h2>
        <form method="post" class="form-horizontal" action="librarianLogin">
            <div class="form-group">
                <label class="control-label col-sm-2" for="email">Email:</label>
                <div class="col-sm-4">
                    <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="pwd">Password:</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pass">
                </div>
            </div>
            <input type="submit" value="Login"  />
        </form>
    </div>

    <div class="col-md-6">
        <h2>Customer Login</h2>
        <form method="post" class="form-horizontal" action="memberLogin">
            <div class="form-group">
                <label class="control-label col-sm-2" for="email">Email:</label>
                <div class="col-sm-4">
                    <input type="email" class="form-control" id="emai" placeholder="Enter email" name="email">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="pwd">Password:</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pass">
                </div>
            </div>
            <input type="submit" value="Login"  />
        </form>
    </div>
</div>

</div>
</body>
</html>
