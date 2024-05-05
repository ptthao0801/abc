<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Tạo Sinh Viên Mới</h2>
    <form action="/student" method="post">
        <input type="hidden" name="command" value="create">
        <div class="mb-3">
            <label for="nameStudent" class="form-label">Tên Sinh Viên:</label>
            <input type="text" class="form-control" id="nameStudent" name="nameStudent" required>
        </div>
        <div class="mb-3">
            <label for="dob" class="form-label">Ngày Sinh:</label>
            <input type="date" class="form-control" id="dob" name="dob" required>
        </div>
        <div class="mb-3">
            <label for="id_class" class="form-label">ID Lớp:</label>
            <input type="number" class="form-control" id="id_class" name="id_class" required>
        </div>
        <button type="submit" class="btn btn-primary">Tạo</button>
        <a href="/student?command=list">Quay lại</a>
    </form>
</div>
</body>
</html>
