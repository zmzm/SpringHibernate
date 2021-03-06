<%--suppress ALL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08.08.2015
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Page</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h1>
    Add a Person
</h1>

<c:url var="addAction" value="/person/add"></c:url>
<c:if test="${!empty person.firstName}">
    <c:url var="addAction" value="/person/update"></c:url>
</c:if>

<form:form action="${addAction}" commandName="person">
    <table>
        <c:if test="${!empty person.firstName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="First Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message text="Last Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="money">
                    <spring:message text="Money"/>
                </form:label>
            </td>
            <td>
                <form:input path="money"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="department.id">
                    <spring:message text="Department ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="department.id"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty person.firstName}">
                    <input type="submit"
                           value="Edit Person"/>
                </c:if>
                <c:if test="${empty person.firstName}">
                    <input type="submit"
                           value="Add Person"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>

<h1>
    Add a Department
</h1>
<c:url var="addDep" value="/person/addDepartment"></c:url>
<form:form action="${addDep}" commandName="department">
    <table>
        <tr>
            <td>
                <form:label path="departmentName">
                    <spring:message text="Department Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="departmentName"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="Add Department"/>
            </td>
        </tr>
    </table>
</form:form>
<br>

<h3>Persons List</h3>
<c:if test="${!empty listPersons}">
    <table class="tg">
        <tr>
            <th width="80">Person ID</th>
            <th width="120">First Name</th>
            <th width="120">Last Name</th>
            <th width="120">Money</th>
            <th width="120">Department</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPersons}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>${person.money}</td>
                <td>${person.department.departmentName}</td>
                <td><a href="<c:url value='/edit/${person.id},${person.department.id}' />">Edit</a></td>
                <td><a href="<c:url value='/remove/${person.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h3>Departments List</h3>
<c:if test="${!empty listDepartments}">
    <table class="tg">
        <tr>
            <th width="120">Department ID</th>
            <th width="120">Department Name</th>
        </tr>
        <c:forEach items="${listDepartments}" var="department">
            <tr>
                <td>${department.id}</td>
                <td>${department.departmentName}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
