<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 5/29/2021
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Add Employee</h1>
    <s:form modelAttribute="employee" action="saveProcess">
        <s:hidden path="id" />
        NIK:<s:input path="nik"/><br/>
        Name:<s:input path="name"/><br/>
        No.Telp:<s:input path="phoneNumber"/><br/>
        Alamat:<s:textarea path="address"/><br/>
        Posisi:<s:input path="position"/><br/>
        Gaji:<s:input path="salary"/><br/>
        <input type="submit" value="Save Employee"/>
    </s:form>
</body>
</html>
