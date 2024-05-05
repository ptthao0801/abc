<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Edit Student</h1>
    <form method="post">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${student.id}">
        <div class="mb-3">
            <label for="nameStudent" class="form-label">Tên Sinh Viên:</label>
            <input type="text" class="form-control" id="nameStudent" name="nameStudent" value="${student.nameStudent}" required>
        </div>
        <div class="mb-3">
            <label for="dob" class="form-label">Ngày Sinh:</label>
            <input type="date" class="form-control" id="dob" name="dob" value="${student.dob}">
        </div>
        <div class="mb-3">
            <label for="name_class" class="form-label">Tên Lớp:</label>
            <input type="text" class="form-control" id="name_class" name="name_class" value="${student.nameClass}" required>
        </div>
<%--        <div class="mb-3">--%>
<%--            <label for="math" class="form-label">Điểm Toán:</label>--%>
<%--            <input type="number" step="any" class="form-control" id="math" name="math" value="${student.gradeToan}" required>--%>
<%--        </div>--%>
<%--        <div class="mb-3">--%>
<%--            <label for="lit" class="form-label">Điểm Văn:</label>--%>
<%--            <input type="number" step="any" class="form-control" id="lit" name="math" value="${student.gradeVan}" required>--%>
<%--        </div>--%>
<%--        <div class="mb-3">--%>
<%--            <label for="eng" class="form-label">Điểm Anh:</label>--%>
<%--            <input type="number" step="any" class="form-control" id="eng" name="math" value="${student.gradeAnh}" required>--%>
<%--        </div>--%>
        <button type="submit" class="btn btn-primary">Lưu Thay Đổi</button>
        <a href="students?action=list">Quay lại</a>
    </form>
</div>
</body>
</html>
