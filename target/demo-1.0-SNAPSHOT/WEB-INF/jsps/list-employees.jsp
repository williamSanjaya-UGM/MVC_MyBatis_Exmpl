<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 5/29/2021
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
    <h1>List Employees</h1>
    <button onclick="window.location.href = 'showFormForAddEmployee.html'">Add Employee</button>
    <div>
        <table>
            <tr>
                <th>NIK</th>
                <th>name</th>
                <th>phoneNumber</th>
                <th>address</th>
                <th>position</th>
                <th>job description</th>
                <th>salary</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${listemployees}" var="e">
                <c:url var = "deleteLink" value="/deleteEmployee">
                    <c:param name="employeeId" value="${e.id}"/>
                </c:url>
                <c:url var = "updateLink" value="/editEmployee">
                    <c:param name="employeeId" value="${e.id}"/>
                </c:url>
                <tr>
                    <td>${e.nik}</td>
                    <td>${e.name}</td>
                    <td>${e.phoneNumber}</td>
                    <td>${e.address}</td>
                    <td>${e.position}</td>
                    <td>${e.jobDesc}</td>
                    <td>${e.salary}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        <a href="${deleteLink}" onclick="if(!(confirm('Are you sure want to delete the record?'))) return false;">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <a href="check-inventory">Click here if you are a cashier</a><br>
</body>
</html>
