<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>View Student</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <h1>View Student Details</h1>
  <form>
    <div class="mb-3">
      <label for="nameStudent" class="form-label">Tên Sinh Viên:</label>
      <input type="text" class="form-control" id="nameStudent" name="nameStudent" value="${student.nameStudent}" readonly>
    </div>
    <div class="mb-3">
      <label for="dob" class="form-label">Ngày Sinh:</label>
      <input type="date" class="form-control" id="dob" name="dob" value="${student.dob}" readonly>
    </div>
    <div class="mb-3">
      <label for="name_class" class="form-label">Tên Lớp:</label>
      <input type="text" class="form-control" id="name_class" name="name_class" value="${student.nameClass}" readonly>
    </div>
    <div class="mb-3">
      <label for="gradeToan" class="form-label">Điểm Toán:</label>
      <input type="number" class="form-control" id="gradeToan" name="gradeToan" value="${student.gradeToan}" readonly>
    </div>
    <div class="mb-3">
      <label for="gradeVan" class="form-label">Điểm Văn:</label>
      <input type="number" class="form-control" id="gradeVan" name="gradeVan" value="${student.gradeVan}" readonly>
    </div>
    <div class="mb-3">
      <label for="gradeAnh" class="form-label">Điểm Anh:</label>
      <input type="number" class="form-control" id="gradeAnh" name="gradeAnh" value="${student.gradeAnh}" readonly>
    </div>
    <div class="mb-3">
      <label for="gradeAVG" class="form-label">Điểm Trung Bình:</label>
      <input type="text" class="form-control" id="gradeAVG" name="gradeAVG" value="${student.scoreAVG()}" readonly>
    </div>
    <a href="students?action=list" class="btn btn-primary">Quay lại</a>
  </form>
</div>
</body>
</html>
