<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 08.01.2022
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Apartment Application</title>
</head>
<body>
<center>
    <h2>
        <a href="/Apartment_Manager/new">Add New Apartment</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/Apartment_Manager/list">List All Apartments</a>

    </h2>
</center>
<div align="center">
    <c:if test="${apartment != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${apartment == null}">
        <form action="add" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${apartment != null}">
                            Edit Apartment
                        </c:if>
                        <c:if test="${apartment == null}">
                            Add New Apartment
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${apartment != null}">
                    <input type="hidden" name="id" value="<c:out value='${apartment.id}' />"/>
                </c:if>
                <tr>
                    <th>City:</th>
                    <td>
                        <input type="text" name="city" size="45"
                               value="<c:out value='${apartment.city}'/>"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Price:</th>
                    <td>
                        <input type="text" name="price" size="45"
                               value="<c:out value='${apartment.price}'/>"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Count of room:</th>
                    <td>
                        <input type="text" name="room" size="45"
                               value="<c:out value='${apartment.room}'/>"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
