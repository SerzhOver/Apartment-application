<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
    <table border="1" cellpadding="5">
        <caption><h2>List of Apartments</h2></caption>
        <tr>
            <th>ID</th>
            <th>City</th>
            <th>Price</th>
            <th>Count of room</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="apartment" items="${listApartment}">
            <tr>
                <td><c:out value="${apartment.id}" /></td>
                <td><c:out value="${apartment.city}" /></td>
                <td><c:out value="${apartment.price}" /></td>
                <td><c:out value="${apartment.room}" /></td>
                <td>
                    <a href="/Apartment_Manager/edit?id=<c:out value='${apartment.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/Apartment_Manager/delete?id=<c:out value='${apartment.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>