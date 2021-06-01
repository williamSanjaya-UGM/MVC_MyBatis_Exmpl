<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 5/29/2021
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>
    <div class="container">
        <h1>List Employees</h1>
        <p align="right">
            <button
                    onclick="window.location.href = 'showFormForAdd.html'; return false;"
                    class="btn btn-primary">Add Employee</button>
        </p>
        <hr/>
        <table border="1" class="table table-striped table-bordered">
            <thead class="thead-dark">
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
            </thead>
            <c:forEach items="${listemployees}" var="e">
                <c:url var = "deleteLink" value="/deleteEmployee">
                    <c:param name="employeeId" value="${e.id}"/>
                </c:url>
                <c:url var = "updateLink" value="/editEmployee">
                    <c:param name="employeeId" value="${e.id}"/>
                </c:url>
                <tbody>
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
                </tbody>
            </c:forEach>
        </table>
    </div>
    <a href="check-inventory">Click here if you are a cashier</a><br>
</body>
</html>
