package DAO;

import model.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDAO implements IDAO<Order>{
    private List<Order> orderList = new ArrayList<Order>();
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public boolean insert(Order order) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.save(order);
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(Order order) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.update(order);
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(Order order) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.delete(order);
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from Order";
                Query query = session.createQuery(hql);
                orderList = query.getResultList();
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }

    @Override
    public Optional<Order> selectById(Order order) {
        Order result = new Order();
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                result = session.get(Order.class, order.getIdOrder());
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public List<Order> selectByCondition(String condition) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from Order where " + condition;
                Query query = session.createQuery(hql);
                orderList = query.getResultList();
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }
}
