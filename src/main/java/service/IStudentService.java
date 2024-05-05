package service;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> showAll();

    void saveList(Student document);

    Student searchById(int id);


    void update(int id, Student student);

    void delete(int id);
}
