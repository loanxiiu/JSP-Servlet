package DAO;
import model.Coffee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CoffeeDAO implements IDAO<Coffee> {
    private List<Coffee> coffeeList = new ArrayList<>();
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public boolean insert(Coffee coffee) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.save(coffee);
                tr.commit();
                session.close();
            }
        }catch(HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(Coffee coffee) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.update(coffee);
                tr.commit();
                session.close();
            }
        }catch(HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(Coffee coffee) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.delete(coffee);
                tr.commit();
                session.close();
            }
        }catch(HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<Coffee> getAll() {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "FROM Coffee";
                Query query = session.createQuery(hql);
                coffeeList = query.getResultList();
                tr.commit();
                session.close();
            }
        }catch(HibernateException e) {
            throw new RuntimeException(e);
        }
        return coffeeList;
    }

    @Override
    public Optional<Coffee> selectById(Coffee coffee) {
        Coffee result = new Coffee();
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                result = session.get(Coffee.class, coffee.getIdCoffe());
                tr.commit();
                session.close();
            }
        }catch(HibernateException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public List<Coffee> selectByCondition(String condition) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from City where " + condition;
                Query query = session.createQuery(hql);
                coffeeList = query.getResultList();
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return coffeeList;
    }
}
