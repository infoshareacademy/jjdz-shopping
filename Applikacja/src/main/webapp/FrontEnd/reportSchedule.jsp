<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
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

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="assets/ie8-responsive-file-warning.js"></script><![endif]-->
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
                <div class="inner">
                    <h3 class="masthead-brand">SPEeD Team</h3>
                    <nav>
                        <ul class="nav masthead-nav">
                            <li class="active"><a href="index.jsp">Home</a></li>
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
                        <h4>Select your frequency of Raports</h4>
                    </div>
                    <div class="row"><p>&nbsp;</p></div>
                </div>


            <div class="btn-group btn-group-justified" role="group" aria-label="...">

                <c:choose>
                    <c:when test="${userdata.reportFrequency == '0'}">

                        <div class="btn-group" role="group">
                            <FORM><INPUT TYPE ="button" class="btn btn-default active" onClick="history.go(0)" VALUE="OFF"></FORM>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="btn-group" role="group">
                            <a href="UserScheduleUpdate?userScheduleParam=${"0"}&userEmail=${userdata.userEmail}"><FORM><INPUT TYPE ="button" class="btn btn-default" onclick="myFunction()" VALUE="OFF"></FORM></a>
                        </div>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${userdata.reportFrequency == '1'}">

                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-default active" onClick="history.go(0)" VALUE="Refresh"> 1 min </button>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="btn-group" role="group">
                            <a href="UserScheduleUpdate?userScheduleParam=${"1"}&userEmail=${userdata.userEmail}"><button type="button" class="btn btn-default" onClick="history.go(0)" VALUE="Refresh"> 1 min </button></a>
                        </div>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${userdata.reportFrequency == '2'}">

                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-default active"> 2 min </button>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="btn-group" role="group">
                            <a href="UserScheduleUpdate?userScheduleParam=${"2"}&userEmail=${userdata.userEmail}"><button type="button" class="btn btn-default "> 2 min </button></a>
                        </div>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${userdata.reportFrequency == '3'}">

                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-default active"> 3 min </button>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="btn-group" role="group">
                            <a href="UserScheduleUpdate?userScheduleParam=${"3"}&userEmail=${userdata.userEmail}"><button type="button" class="btn btn-default " onclick="myFunction()"> 3 min </button></a>
                        </div>
                    </c:otherwise>
                </c:choose>

            </div>


            <div class="mastfoot">
                <div class="inner">
                    <p>Product searcher made by SPEeD Team <a href="http://getbootstrap.com">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
                </div>
            </div>

        </div>
        </div>
    </div>

        <FORM><INPUT TYPE ="button" class="btn btn-default active" onClick="history.go(0)" VALUE="refresh"></FORM>


        <c:choose>
            <c:when test="${userdata.reportFrequency == '0'}">
                <FORM><INPUT TYPE ="button" class="btn btn-default active" onClick="history.go(0)" VALUE="OFF"></FORM>
            </c:when>
            <c:when test="${userdata.reportFrequency == '1'}">
                <FORM><INPUT TYPE ="button" class="btn btn-default active" onClick="history.go(0)" VALUE="1"></FORM>
            </c:when>
            <c:when test="${userdata.reportFrequency == '2'}">
                <FORM><INPUT TYPE ="button" class="btn btn-default active" onClick="history.go(0)" VALUE="2"></FORM>
            </c:when>
            <c:otherwise>
                3
            </c:otherwise>

        </c:choose>


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

<script>
    function myFunction() {
        setTimeout(function(){ alert("Hello"); }, 3000);
    }
</script>


</body>
</html>
