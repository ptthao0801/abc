package service;

import model.Student;
import java.util.List;

public class StudentService implements IStudentService {
    private StudentDAO studentDAO = new StudentDAO();

    @Override
    public List<Student> showAll() {
        return StudentDAO.getAllStudents();
    }
static StudentService studentService = new StudentService();
    public static void main(String[] args) {
        studentService.showAll();
    }

    @Override
    public void saveList(Student student) {
        studentDAO.createStudent(student);
    }

    @Override
    public Student searchById(int id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public void update(int id, Student student) {
        studentDAO.updateStudent(student);
    }

    @Override
    public void delete(int id) {
        studentDAO.deleteStudent(id);
    }
}
