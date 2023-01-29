package ua.ithillel.lesson31.homework;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.lesson31.homework.dao.StudentDaoImpl;
import ua.ithillel.lesson31.homework.model.Student;

public class Application {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext("ua.ithillel.lesson31.homework.util");
        var sessionFactory = ctx.getBean(StudentDaoImpl.class);

        Student student1 = new Student();
        student1.setName("JK");
        student1.setEmail("jk@gmail.com");

        StudentDaoImpl studentDao = new StudentDaoImpl((SessionFactory) sessionFactory);
        studentDao.save(student1);
    }
}
