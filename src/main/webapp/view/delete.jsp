<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Delete Student</h1>
    <p>Are you sure you want to delete this student?</p>
    <form method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="${student.studentId}">
        <input type="submit" class="btn btn-danger" value="Delete">
        <a href="students?action=list">Quay lại</a>
    </form>
</div>
</body>
</html>
