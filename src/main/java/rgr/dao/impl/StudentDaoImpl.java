package rgr.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import rgr.dao.StudentDao;
import rgr.entity.Student;
import rgr.utl.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student read(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        transaction.commit();
        session.close();
        return student;
    }
	@Override
    public List<Student> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> list = session.createQuery("from Student").list();
        transaction.commit();
        session.close();
        return list;
    }
    @Override
    public void save(Student entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }
    @Override
    public void delete(Student entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
    @Override
    public void edit(Student entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student = (Student) session.get(Student.class, entity.getId());
        student.setFirstName(entity.getFirstName());
        student.setSecondName(entity.getSecondName());
        student.setPatronymic(entity.getPatronymic());
        student.setGroup(entity.getGroup());
        session.update(student);
        transaction.commit();
        session.close();
    }
    
}
