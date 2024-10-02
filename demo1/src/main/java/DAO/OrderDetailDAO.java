package DAO;

import model.OrderDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDetailDAO implements IDAO<OrderDetail> {
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public boolean insert(OrderDetail orderDetail) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();
                session.save(orderDetail);
                transaction.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.update(orderDetail);
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(OrderDetail orderDetail) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.delete(orderDetail);
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<OrderDetail> getAll() {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from OrderDetail";
                Query query = session.createQuery(hql);
                orderDetailList = query.getResultList();
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return orderDetailList;
    }

    @Override
    public Optional<OrderDetail> selectById(OrderDetail orderDetail) {
        OrderDetail result = new OrderDetail();
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                result = session.get(OrderDetail.class, orderDetail.getIdOrderDetail());
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public List<OrderDetail> selectByCondition(String condition) {
        try {
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from OrderDetail where " + condition;
                Query query = session.createQuery(hql);
                orderDetailList = query.getResultList();
                tr.commit();
                session.close();
            }
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return orderDetailList;
    }
}
