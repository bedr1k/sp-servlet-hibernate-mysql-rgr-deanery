package rgr.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import rgr.dao.ExamDao;
import rgr.entity.Exam;
import rgr.utl.HibernateUtil;

public class ExamDaoImpl implements ExamDao {

    @Override
    public Exam read(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Exam exam = (Exam) session.get(Exam.class, id);
        transaction.commit();
        session.close();
        return exam;    
    }
	@Override
    public List<Exam> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Exam> list = session.createQuery("from Exam").list();
        transaction.commit();
        session.close();
        return list;    
    }
    @Override
    public void save(Exam entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();    
    }
    @Override
    public void delete(Exam entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();    
    }
    @Override
    public void edit(Exam entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Exam exam = (Exam) session.get(Exam.class, entity.getId());
        exam.setDiscipline(entity.getDiscipline());
        exam.setExamDay(entity.getExamDay());
        exam.setGrade(entity.getGrade());
        exam.setStudent(entity.getStudent());
        session.update(exam);
        transaction.commit();
        session.close();    
    }
    
}
