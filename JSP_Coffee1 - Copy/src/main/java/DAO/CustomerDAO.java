package DAO;

import model.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAO implements IDAO<Customer>{
    private List<Customer> customerList = new ArrayList<>();
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public boolean insert(Customer customer) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.save(customer);
                tr.commit();
                session.close();
                return true;
            }
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        try{
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.update(customer);
                tr.commit();
                session.close();
                return true;
            }
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(Customer customer) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.delete(customer);
                tr.commit();
                session.close();
                return true;
            }
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "FROM Customer";
                Query query = session.createQuery(hql);
                customerList = query.getResultList();
                tr.commit();
                session.close();
            }
            else {
                return null;
            }
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
        return customerList;
    }

    @Override
    public Optional<Customer> selectById(Customer customer) {
        Customer result = new Customer();
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                result = session.get(Customer.class, customer.getIdCustomer());
                tr.commit();
                session.close();
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public List<Customer> selectByCondition(String condition) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "FROM Customer WHERE " + condition;
                Query query = session.createQuery(hql);
                customerList = query.getResultList();
                tr.commit();
                session.close();
            }
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
        return customerList;
    }
}
