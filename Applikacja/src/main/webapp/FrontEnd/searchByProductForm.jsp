<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Cover Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="assets/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/speed.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="assets/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="assets/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <h4 class="text-left col-md-12">SPEeD Team</h4>
                <div class="inner">

                    <nav>
                        <ul class="nav masthead-nav">
                            <li ><a href="index.jsp">Home</a></li>

                            <li>
                                <jsp:include page="UserDataInput.jsp"/>
                            </li>


                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <div class="row">
                    <div class="col-md-12">
                        <div class="input-group">
                            <p>Search by product name</p>
                        </div><!-- /input-group -->
                    </div><!-- /.col-md-12 -->
                </div><!-- /.row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="input-group">



                            <form class="navbar-form navbar-left" role="search" method="POST" action="SearchByProductServlet">

                                <div class="form-group">
                                    <input type="text" name="searchedProduct" class="form-control" placeholder="Search for ..."/>
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>

                                <c:if test="${message != null}">
                                    <br>
                                    <div style="background-color: red;">${message}</div>
                                </c:if>

                            </form>



                        </div><!-- /input-group -->
                    </div><!-- /.col-md-12 -->
                </div><!-- /.row -->
            </div>


            <div class="mastfoot">
                <div class="inner">
                    <p>Product searcher made by SPEeD Team </p>
                </div>
            </div>

        </div>

    </div>

</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="assets/jquery.min.js"><\/script>')</script>
<script src="assets/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="assets/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
