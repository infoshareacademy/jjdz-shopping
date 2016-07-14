<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

                                <c:choose>
                                    <c:when test="${userdata == null}">
                                        <a href="LogingForm.jsp"><div>Login</div></a>
                                    </c:when>

                                    <c:otherwise>
                                        <li><a href="AllUsersData"><div>Admin Panel</div></a></li>
                                        <li><a href="reportSchedule.jsp"><div>Settings</div></a></li>
                                        <li><a href="ShowLoggedUserFavoritesServlet"><div>Favorites</div></a></li>
                                        <li><div>Hello, ${userdata.userName}</div></li>
                                        <li><a href="logout"><div>Logout</div></a></li>
                                    </c:otherwise>
                                </c:choose>


