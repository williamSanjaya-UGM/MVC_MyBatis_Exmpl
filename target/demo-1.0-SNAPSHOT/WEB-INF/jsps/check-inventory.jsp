<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 5/30/2021
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Check Inventory Location</title>
</head>
<body>
    <h1>Add Employee</h1>
    <s:form modelAttribute="inventoryInfoLoc" action="saveProcedure">
        Nama Sektor:<s:input path="sectorName"/><br/>
        Tanggal:<s:input path="date"/><br/>
        <input type="submit" value="Search info loc"/>
    </s:form>
    <h1>List Inventory and it's location</h1>
    <div>
        <table>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>SECTOR NAME</th>
            </tr>
            <c:forEach items="${inventoryInfoList}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.name}</td>
                    <td>${e.sectorName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <a href="http://localhost:8080/demo_war_exploded/">Click here to get back to first page</a><br>
</body>
</html>
