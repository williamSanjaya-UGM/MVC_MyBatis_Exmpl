<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 5/29/2021
  Time: 7:39 PM
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
        <h1>Employee details</h1>
        <hr/>
        <s:form modelAttribute="employee" action="saveProcess">
            <s:hidden path="id" />
            <div class="form-group">
                <s:input path="nik" class="form-control" placeholder="Enter your NIK"/>
            </div>
            <div class="form-group">
                <s:input path="name" placeholder="Enter email" class="form-control"/>
            </div>
            <div class="form-group">
                <s:input path="phoneNumber" placeholder="phone number"  class="form-control"/>
            </div>
            <div>
                <s:textarea path="address" placeholder="address"  class="form-control"/>
            </div>
            <div>
                <s:input path="position" placeholder="position" class="form-control"/>
            </div>
            <div>
                <s:input path="salary" placeholder="salary" class="form-control"/>
            </div>
            <input type="submit" value="Save" class="btn btn-info" />&nbsp;
        </s:form>
        <hr/>
    </div>
</body>
</html>
