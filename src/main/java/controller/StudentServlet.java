package controller;

import model.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
                int idView = Integer.parseInt(req.getParameter("id"));
                Student studentToView = studentService.searchById(idView);
                req.setAttribute("student", studentToView);
                req.getRequestDispatcher("/view.jsp").forward(req, resp);
                break;
            default:
                req.setAttribute("students", studentService.showAll());
                req.getRequestDispatcher("/list.jsp").forward(req, resp);//                req.getRequestDispatcher("/error_page.jsp").forward(req, resp);
                break;
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

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String name = req.getParameter("nameStudent");
            String nameClass = req.getParameter("nameClass"); // Assume input includes class name
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dob = format.parse(req.getParameter("dob"));

            Student student = new Student();
            student.setNameStudent(name);
            student.setDob(new java.sql.Date(dob.getTime()));
            student.setNameClass(nameClass); // Set nameClass directly

            studentService.saveList(student);
            resp.sendRedirect("student?action=list");
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

            Student student = new Student();
            student.setStudentId(id);
            student.setNameStudent(name);
            student.setDob(new java.sql.Date(dob.getTime()));
            student.setNameClass(nameClass);

            studentService.update(id, student);
            resp.sendRedirect("student?action=list");
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
