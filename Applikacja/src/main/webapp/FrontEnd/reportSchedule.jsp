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

    <title>Cover Template for Bootstrap</title>

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


<c:choose>
    <c:when test = "${userdata.userEmail != null}">

                        <div class="row">
                            <h3>Select your report schedule plan </h3>
                        </div>
                        <table id="admin_scheduler">

                                <tr>
                                    <td>
                                        <form name="myform" action="UserScheduleUpdate" method="POST">
                                            <div align="left"><br>
                                                <c:choose>
                                                    <c:when test="${userdata.reportFrequency == '0'}">
                                                        <label class = "specialFont"><input type="radio" name="userScheduleParam" value="0" checked> OFF</label><br>
                                                        <label class = "specialFont"><input type="radio" name="userScheduleParam" value="1"> Every 1 minute </label><br>
                                                        <label class = "specialFont"><input type="radio" name="userScheduleParam" value="2"> Every 2 minutes </label><br>
                                                        <label class = "specialFont"><input type="radio" name="userScheduleParam" value="3"> Every 3 minutes </label><br>
                                                        <input type="hidden" name="userEmail" value="${userdata.userEmail}"><br>
                                                    </c:when>
                                                </c:choose>
                                                <c:choose>
                                                    <c:when test="${userdata.reportFrequency == '1'}">
                                                        <label class = "specialFont"><input type="radio" name="userScheduleParam" value="0"> OFF</label><br>
                                                        <label class = "specialFont"><input type="radio" name="userScheduleParam" value="1" checked> Every 1 minute </label><br>
                                                        <label class = "specialFont"><input type="radio" name="userScheduleParam" value="2"> Every 2 minutes </label><br>
                                                        <label class = "specialFont"><input type="radio" name="userScheduleParam" value="3"> Every 3 minutes </label><br>
                                                        <input type="hidden" name="userEmail" value="${userdata.userEmail}"><br>
                                                    </c:when>
                                                </c:choose>
                                                <c:choose>
                                                    <c:when test="${userdata.reportFrequency == '2'}">
                                                            <label class = "specialFont"><input type="radio" name="userScheduleParam" value="0"> OFF</label><br>
                                                            <label class = "specialFont"><input type="radio" name="userScheduleParam" value="1"> Every 1 minute </label><br>
                                                            <label class = "specialFont"><input type="radio" name="userScheduleParam" value="2" checked> Every 2 minutes </label><br>
                                                            <label class = "specialFont"><input type="radio" name="userScheduleParam" value="3"> Every 3 minutes </label><br>
                                                            <input type="hidden" name="userEmail" value="${userdata.userEmail}"><br>
                                                    </c:when>
                                                </c:choose>
                                                <c:choose>
                                                    <c:when test="${userdata.reportFrequency == '3'}">
                                                            <label class = "specialFont"><input type="radio" name="userScheduleParam" value="0"> OFF</label><br>
                                                            <label class = "specialFont"><input type="radio" name="userScheduleParam" value="1"> Every 1 minute </label><br>
                                                            <label class = "specialFont"><input type="radio" name="userScheduleParam" value="2"> Every 2 minutes </label><br>
                                                            <label class = "specialFont"><input type="radio" name="userScheduleParam" value="3" checked> Every 3 minutes </label><br>
                                                        <input type="hidden" name="userEmail" value="${userdata.userEmail}"><br>
                                                    </c:when>
                                                </c:choose>
                                                <input type="submit" class="btn btn-default" value="Save changes">
                                            </div>
                                        </form>
                                    </td>
                                </tr>
                        </table>

        </c:when>
                        <c:otherwise>

                            <div class="row">
                                <h3>Setting will be available after login</h3>
                            </div>

                        </c:otherwise>


    </c:choose>



        </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>Product searcher made by SPEeD Team </p>
                </div>
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
