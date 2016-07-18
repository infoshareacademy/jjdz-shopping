<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

                                <c:choose>
                                    <c:when test="${userdata == null}">
                                        <a href="LogingForm.jsp"><div>Login</div></a>
                                    </c:when>

                                    <c:otherwise>
                                        <c:if test = "${userdata.userType == '1'}">
                                            <li><a href="AllUsersData?userEmail=${userdata.userEmail}"><div>Admin Panel</div></a></li>
                                        </c:if>
                                        <li><a href="reportSchedule.jsp"><div>Settings</div></a></li>
                                        <li><a href="ShowLoggedUserFavoritesServlet"><div>Favorites</div></a></li>
                                        <li><div>Hello, ${userdata.userName}</div></li>
                                        <li><a href="logout"><div>Logout</div></a></li>
                                    </c:otherwise>
                                </c:choose>


