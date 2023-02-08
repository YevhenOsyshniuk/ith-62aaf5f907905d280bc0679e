package ua.ithillel.lesson31.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.lesson31.homework.dao.StudentDaoImpl;
import ua.ithillel.lesson31.homework.model.Student;
import ua.ithillel.lesson31.homework.util.HibernateSession;

public class Application {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(HibernateSession.class);
        var studentDao = ctx.getBean(StudentDaoImpl.class);

        Student student1 = new Student();
        student1.setName("student1");
        student1.setEmail("student1@gmail.com");
        studentDao.save(student1);

        Student student2 = new Student();
        student1.setName("student2");
        student1.setEmail("student2@gmail.com");
        studentDao.save(student2);

        Student student3 = new Student();
        student1.setName("student3");
        student1.setEmail("student3@gmail.com");
        studentDao.save(student3);

        studentDao.getById(2);
        studentDao.remove(student1);
        studentDao.getAll();
    }
}
