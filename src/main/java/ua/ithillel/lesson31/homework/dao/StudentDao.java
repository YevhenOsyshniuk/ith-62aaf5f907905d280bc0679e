package ua.ithillel.lesson31.homework.dao;

import ua.ithillel.lesson31.homework.model.Student;

import java.util.List;

public interface StudentDao {
    void save(Student student);

    void update(Student student);

    void remove(Student student);

    Student getById(long id);

    List<Student> getAll();
}
