package DAO;

import model.Staff;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StaffDAO implements IDAO<Staff>{
    private List<Staff> staffList = new ArrayList<Staff>();
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public boolean insert(Staff staff) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.save(staff);
                tr.commit();
                session.close();
                return true;
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(Staff staff) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.update(staff);
                tr.commit();
                session.close();
                return true;
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(Staff staff) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.delete(staff);
                tr.commit();
                session.close();
                return true;
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<Staff> getAll() {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from Staff";
                Query query = session.createQuery(hql);
                staffList = query.getResultList();
                tr.commit();
                session.close();
            }else {
                return null;
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return staffList;
    }

    @Override
    public Optional<Staff> selectById(Staff staff) {
        Staff result = new Staff();
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                result = session.get(Staff.class, staff.getIdStaff());
                tr.commit();
                session.close();
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public List<Staff> selectByCondition(String condition) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from Staff where " + condition;
                Query query = session.createQuery(hql);
                staffList = query.getResultList();
                tr.commit();
                session.close();
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return staffList;
    }
}
