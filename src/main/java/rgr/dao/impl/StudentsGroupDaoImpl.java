package rgr.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import rgr.dao.StudentsGroupDao;
import rgr.entity.StudentsGroup;
import rgr.utl.HibernateUtil;

public class StudentsGroupDaoImpl implements StudentsGroupDao {

    @Override
    public StudentsGroup read(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        StudentsGroup group = (StudentsGroup) session.get(StudentsGroup.class, id);
        transaction.commit();
        session.close();
        return group;    
    }
	@Override
    public List<StudentsGroup> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<StudentsGroup> list = session.createQuery("from StudentsGroup").list();
        transaction.commit();
        session.close();
        return list;
    }
    @Override
    public void save(StudentsGroup entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }
    @Override
    public void delete(StudentsGroup entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
    @Override
    public void edit(StudentsGroup entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        StudentsGroup group = (StudentsGroup) session.get(StudentsGroup.class, entity.getId());
        group.setName(entity.getName());
        group.setCourse(entity.getCourse());
        session.update(group);
        transaction.commit();
        session.close();
    }
    
}
