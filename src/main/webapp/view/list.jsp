<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>List of Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>List of Students</h1>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Class Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td><c:out value="${student.studentId}"/></td>
                <td><c:out value="${student.nameStudent}"/></td>
                <td><c:out value="${student.dob}"/></td>
<%--                <td><c:out value="${student.nameClass}"/></td>--%>
                <td>
                    <a href="students?action=view&id=${student.studentId}">View</a>
                    <a href="students?action=edit&id=${student.studentId}">Edit</a>
                    <a href="students?action=delete&id=${student.studentId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

        <a href="students?action=create" class="btn btn-primary">Create New Student</a>

</div>
</body>
</html>
