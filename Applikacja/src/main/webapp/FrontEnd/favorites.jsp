<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Favorites</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="assets/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/speed.css" rel="stylesheet">
    <%--Font Awsome icons--%>
    <link rel="stylesheet" href="../resources/font-awesome-4.6.3/css/font-awesome.min.css">

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
                            <li><a href="index.jsp">Home</a></li>

                            <li>
                                <jsp:include page="UserDataInput.jsp"/>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">

                <p>
                    <h2>Favorites:</h2>
                    <table id="favorites">
                        <tr><th>Category ID</th><th>Category name</th><th>Remove from favorites</th><th>Link to Allegro</th></tr>
                        <c:forEach items="${favorites}" var="item">
                            <tr>
                                <td><c:out value="${item.catId}"/></td>
                                <td><c:out value="${item.catName}"/></td>
                                <td><a href="FavoritesDbServlet?categoryId=${item.catId}&addItem=0"><i class="fa fa-minus" aria-hidden="true"></i></a></td>
                                <td><a href="LinkToAllegroCategory?categoryId=${item.catId}" target="_blank">Open in Allegro</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </p>
                <!--<p class="lead">Cover is a one-page template for building simple and beautiful home pages. Download, edit the text, and add your own fullscreen background photo to make it your own.</p>-->
                <p class="lead">
                    <!--<a href="#" class="btn btn-lg btn-default">Wprowadz kod kreskowy</a>-->
                    <!--<a href="#" class="btn btn-lg btn-default">Wprowadz słowo kluczowe</a>-->
                </p>
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>Product searcher made by SPEeD Team</p>
                </div>
            </div>

        </div>

    </div>

</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="../../dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
