package rgr.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import rgr.dao.DisciplineDao;
import rgr.entity.Discipline;
import rgr.utl.HibernateUtil;

public class DisciplineDaoImpl implements DisciplineDao {

    @Override
    public Discipline read(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Discipline discipline = (Discipline) session.get(Discipline.class, id);
        transaction.commit();
        session.close();
        return discipline;
    }
	@Override
    public List<Discipline> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Discipline> list = session.createQuery("from Discipline").list();
        transaction.commit();
        session.close();
        return list;
    }
    @Override
    public void save(Discipline entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();    
    }
    @Override
    public void delete(Discipline entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();    
    }
    @Override
    public void edit(Discipline entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Discipline discipline = (Discipline) session.get(Discipline.class, entity.getId());
        discipline.setName(entity.getName());
        session.update(discipline);
        transaction.commit();
        session.close();
    }
    
}
