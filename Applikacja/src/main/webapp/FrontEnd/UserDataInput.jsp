<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

                                <c:choose>
                                    <c:when test="${userdata == null}">
                                        <a href="LogingForm.jsp">
                                            <div> Login </div>
                                        </a>
                                    </c:when>

                                    <c:otherwise>
                                        <a href="ShowLoggedUserFavoritesServlet">
                                            <div>Favorites</div>
                                        </a>
                                        <div>Hello, ${userdata.userName}</div>
                                            <li>
                                        <a href="logout" >
                                                <div>Logout</div>
                                        </a>

                                            </li>



                                    </c:otherwise>
                                </c:choose>


