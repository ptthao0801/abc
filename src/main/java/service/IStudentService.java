package service;

import model.Student;

import java.util.List;


public interface IStudentService {
    List<Student> showAll();

    void saveList(Student student);

    Student searchById(int studentId);


    void update(int id, Student student);

    void delete(int studentId);
}
