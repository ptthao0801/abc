package service;

import model.Student;

import java.util.List;


public class StudentService implements IStudentService {
    private StudentDAO studentDAO = new StudentDAO();

    @Override
    public List<Student> showAll() {
        return studentDAO.getAllStudents();
    }

    @Override
    public void saveList(Student student) {
        studentDAO.createStudent(student);
    }

    @Override
    public Student searchById(int studentId) {
        return studentDAO.getStudentById(studentId);
    }

    @Override
    public void update(int id, Student student) {
        studentDAO.updateStudent(student);
    }

    @Override
    public void delete(int studentId) {
        studentDAO.deleteStudent(studentId);
    }
}

