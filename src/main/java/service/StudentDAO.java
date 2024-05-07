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
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            System.out.println("THANH CONG");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection error: " + e.getMessage());
        }
        return connection;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setNameStudent(rs.getString("nameStudent"));
                student.setDob(rs.getDate("dob"));

//                student.setGradeToan(rs.getDouble("gradeToan"));
//                student.setGradeVan(rs.getDouble("gradeVan"));
//                student.setGradeAnh(rs.getDouble("gradeAnh"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getStudentById(int studentId) {
        Student student = null;
        String query = "SELECT * FROM student WHERE studentId = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setStudentId(rs.getInt("studentID"));
                    student.setNameStudent(rs.getString("nameStudent"));
                    student.setDob(rs.getDate("dob"));
                    student.setGradeToan(rs.getDouble("gradeToan"));
                    student.setGradeVan(rs.getDouble("gradeVan"));
                    student.setGradeAnh(rs.getDouble("gradeAnh"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void createStudent(Student student) {
        String query = "INSERT INTO Student (studentId, nameStudent, dob, gradeToan, gradeVan, gradeAnh) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, student.getStudentId());
            stmt.setString(2, student.getNameStudent());
            stmt.setDate(3, new java.sql.Date(student.getDob().getTime()));
            stmt.setDouble(4, student.getGradeToan());
            stmt.setDouble(5, student.getGradeVan());
            stmt.setDouble(6, student.getGradeAnh());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        String query = "UPDATE student SET nameStudent = ?, dob = ?, gradeToan = ?, gradeVan = ?, gradeAnh = ? WHERE studentId = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getNameStudent());
            stmt.setDate(2, new java.sql.Date(student.getDob().getTime()));
            stmt.setDouble(3, student.getGradeToan());
            stmt.setDouble(4, student.getGradeVan());
            stmt.setDouble(5, student.getGradeAnh());
            stmt.setInt(6, student.getStudentId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {
//        deleteStudentGrades(studentId);
        String query = "DELETE FROM Student WHERE studentId = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void deleteStudentGrades(int studentId) {
//        String sql = "DELETE FROM Grade WHERE id_student = ?";
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, studentId);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}





//package service;
//
//import controller.StudentServlet;
//import model.Student;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class StudentDAO {
//
//    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/minitest3";
//    private static final String JDBC_USERNAME = "root";
//    private static final String JDBC_PASSWORD = "khoatrinh18122001";
//
//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
//            System.out.println("THANH CONG");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("lỗi kết nối");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("looix ");
//        }
//        return connection;
//    }
//
//
//    public List<Student> getAllStudents() {
//        List<Student> students = new ArrayList<>();
//        String query = "SELECT * FROM student";
//
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    Student student = new Student();
//                    student.setId(rs.getInt("id"));
//                    student.setCode(rs.getString("code"));
//                    student.setName(rs.getString("name"));
//                    student.setYear(rs.getInt("year"));
//                    student.setDescription(rs.getString("description"));
//                    students.add(document);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return documents;
//    }
//
//    public Document getDocumentById(int id) {
//        Document document = null;
//        String query = "SELECT * FROM document WHERE id = ?";
//
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                document = new Document();
//                document.setId(rs.getInt("id"));
//                document.setCode(rs.getString("code"));
//                document.setName(rs.getString("name"));
//                document.setYear(rs.getInt("year"));
//                document.setDescription(rs.getString("description"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return document;
//    }
//
//    public void createDocument(Document document) {
//        String query = "INSERT INTO document (id, code, name, year, description) VALUES (?, ?, ?, ?, ?)";
//
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setInt(1, document.getId());
//            stmt.setString(2, document.getCode());
//            stmt.setString(3, document.getName());
//            stmt.setInt(4, document.getYear());
//            stmt.setString(5, document.getDescription());
//
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void updateDocument(Document document) {
//        String query = "UPDATE document SET code = ?, name = ?, year = ?, description = ? WHERE id = ?";
//
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setString(1, document.getCode());
//            stmt.setString(2, document.getName());
//            stmt.setInt(3, document.getYear());
//            stmt.setString(4, document.getDescription());
//            stmt.setInt(5, document.getId());
//
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteDocument(int id) {
//        String query = "DELETE FROM document WHERE id = ?";
//
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setInt(1, id);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
