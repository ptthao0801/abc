<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="styles/custom.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Tạo Sinh Viên Mới</h2>
    <form action="/students" method="post">
        <input type="hidden" name="action" value="create">
        <div class="mb-3">
            <label for="studentId" class="form-label">ID Sinh Viên:</label>
            <input type="number" class="form-control" id="studentId" name="studentId" required>
        </div>
        <div class="mb-3">
            <label for="nameStudent" class="form-label">Tên Sinh Viên:</label>
            <input type="text" class="form-control" id="nameStudent" name="nameStudent" required>
        </div>
        <div class="mb-3">
            <label for="dob" class="form-label">Ngày Sinh:</label>
            <input type="date" class="form-control" id="dob" name="dob" required>
        </div>
        <div class="mb-3">
            <label for="gradeToan" class="form-label">Điểm Toán:</label>
            <input type="number" step="0.01" class="form-control" id="gradeToan" name="gradeToan" required>
        </div>
        <div class="mb-3">
            <label for="gradeVan" class="form-label">Điểm Văn:</label>
            <input type="number" step="0.01" class="form-control" id="gradeVan" name="gradeVan" required>
        </div>
        <div class="mb-3">
            <label for="gradeAnh" class="form-label">Điểm Anh:</label>
            <input type="number" step="0.01" class="form-control" id="gradeAnh" name="gradeAnh" required>
        </div>
        <button type="submit" class="btn btn-primary">Tạo</button>
        <a href="/student" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>
