package ua.ithillel.lesson31.homework.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ithillel.lesson31.homework.model.Student;

import java.util.List;
@Transactional
@Repository
public class StudentDaoImpl implements StudentDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Student student) {
        var session = sessionFactory.openSession();
        session.save(student);
        session.close();
    }

    @Override
    public void update(Student student) {
        var session = sessionFactory.openSession();
        session.update(student);
        session.close();
    }

    @Override
    public void remove(Student student) {
        var session = sessionFactory.openSession();
        session.remove(student);
        session.close();
    }

    @Override
    public Student getById(long id) {
        var session = sessionFactory.openSession();
        var student = session.byId(Student.class).getReference(id);
        session.close();
        return student;
    }

    @Override
    public List<Student> getAll() {
        var session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student ").list();
        session.close();
        return students;
    }
}
