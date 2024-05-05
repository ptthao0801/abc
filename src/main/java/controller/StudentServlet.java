package controller;

import model.Student;

import service.StudentDAO;
import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/create.jsp").forward(req, resp);
                break;
            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                Student studentToEdit = studentService.searchById(idEdit);
                req.setAttribute("student", studentToEdit);
                req.getRequestDispatcher("/edit.jsp").forward(req, resp);
                break;
            case "delete":
                int idDelete = Integer.parseInt(req.getParameter("id"));
                Student studentToDelete = studentService.searchById(idDelete);
                req.setAttribute("student", studentToDelete);
                req.getRequestDispatcher("/delete.jsp").forward(req, resp);
                break;
            case "view":
                viewStudents(req,resp);
                break;
            default:
                listStudents(req,resp);
                break;
        }
    }

    private void viewStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idView = Integer.parseInt(req.getParameter("id"));
        Student studentToView = this.studentService.searchById(idView);
        RequestDispatcher dispatcher;
        if (studentToView == null) {
            dispatcher = req.getRequestDispatcher("error.jsp");
        } else {
            req.setAttribute("student", studentToView);
            dispatcher = req.getRequestDispatcher("view.jsp");
            dispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(req, resp);
                break;
            case "edit":
                updateStudent(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            default:
//                resp.sendRedirect("error_page.jsp");
                break;
        }
    }
    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = this.studentService.showAll();
        req.setAttribute("students", students);

        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req,resp);
    }



    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("nameStudent");
            String nameClass = req.getParameter("nameClass"); // Assume input includes class name
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dob = format.parse(req.getParameter("dob"));

            Student student = new Student();
            student.setNameStudent(name);
            student.setDob(new java.sql.Date(dob.getTime()));
            student.setNameClass(nameClass); // Set nameClass directly
            RequestDispatcher dispatcher;
            if (student == null) {
                dispatcher = req.getRequestDispatcher("error.jsp");
            }
            studentService.saveList(student);

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("nameStudent");
            String nameClass = req.getParameter("nameClass");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dob = format.parse(req.getParameter("dob"));
//            double gradeToan = Double.parseDouble(req.getParameter("gradeToan"));
//            double gradeVan = Double.parseDouble(req.getParameter("gradeVan"));
//            double gradeAnh = Double.parseDouble(req.getParameter("gradeAnh"));

            Student student = this.studentService.searchById(id);
            RequestDispatcher dispatcher;
            if (student == null) {
                dispatcher = req.getRequestDispatcher("error.jsp");
            } else {
                student.setStudentId(id);
                student.setNameStudent(name);
                student.setDob(new java.sql.Date(dob.getTime()));
                student.setNameClass(nameClass);
//                student.setGradeToan(gradeToan);
//                student.setGradeVan(gradeVan);
//                student.setGradeAnh(gradeAnh);

                studentService.update(id, student);
                req.setAttribute("student", student);
                dispatcher = req.getRequestDispatcher("edit.jsp");
                dispatcher.forward(req,resp);
            }



//            resp.sendRedirect("students?action=list");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.delete(id);
        resp.sendRedirect("student?action=list");
    }
}
