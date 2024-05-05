package service;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/casestudy";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "khoatrinh18122001";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi kết nối");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver không tìm thấy");
        }
        return connection;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT s.id, s.nameStudent, s.dob, c.nameClass, g.gradeToan, g.gradeVan, g.gradeAnh FROM Student s JOIN Class c ON s.id_class = c.id JOIN (SELECT id_student, MAX(CASE WHEN id_subject = 1 THEN grade ELSE NULL END) as gradeToan, MAX(CASE WHEN id_subject = 2 THEN grade ELSE NULL END) as gradeVan, MAX(CASE WHEN id_subject = 3 THEN grade ELSE NULL END) as gradeAnh FROM Grade GROUP BY id_student) g ON s.id = g.id_student";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setNameStudent(rs.getString("nameStudent"));
                student.setDob(rs.getDate("dob"));
                student.setNameClass(rs.getString("nameClass"));
                student.setGradeToan(rs.getDouble("gradeToan"));
                student.setGradeVan(rs.getDouble("gradeVan"));
                student.setGradeAnh(rs.getDouble("gradeAnh"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    public Student getStudentById(int id) {
        Student student = null;
        String query = "SELECT s.id, s.nameStudent, s.dob, c.nameClass, g.gradeToan, g.gradeVan, g.gradeAnh FROM Student s JOIN Class c ON s.id_class = c.id JOIN (SELECT id_student, MAX(CASE WHEN id_subject = 1 THEN grade ELSE NULL END) as gradeToan, MAX(CASE WHEN id_subject = 2 THEN grade ELSE NULL END) as gradeVan, MAX(CASE WHEN id_subject = 3 THEN grade ELSE NULL END) as gradeAnh FROM Grade GROUP BY id_student) g ON s.id = g.id_student WHERE s.id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setNameStudent(rs.getString("nameStudent"));
                student.setDob(rs.getDate("dob"));
                student.setNameClass(rs.getString("nameClass"));
                student.setGradeToan(rs.getDouble("gradeToan"));
                student.setGradeVan(rs.getDouble("gradeVan"));
                student.setGradeAnh(rs.getDouble("gradeAnh"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


    public void createStudent(Student student) {
        String query = "INSERT INTO Student (nameStudent, dob, id_class) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getNameStudent());
            stmt.setDate(2, new java.sql.Date(student.getDob().getTime()));
            stmt.setInt(3, student.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        String query = "UPDATE Student SET nameStudent = ?, dob = ?, id_class = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getNameStudent());
            stmt.setDate(2, new java.sql.Date(student.getDob().getTime()));
            stmt.setInt(3, student.getId());
            stmt.setInt(4, student.getStudentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM Student WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
