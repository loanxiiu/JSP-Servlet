package DAO;

import model.Account;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDAO implements IDAO<Account>{
    private List<Account> accountList = new ArrayList<Account>();
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public boolean insert(Account account) {
        try{
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.save(account);
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
    public boolean update(Account account) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.update(account);
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
    public boolean delete(Account account) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.delete(account);
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
    public List<Account> getAll() {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from Account";
                Query query = session.createQuery(hql);
                accountList = query.getResultList();
                tr.commit();
                session.close();
            }
            else {
                return null;
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return accountList;
    }

    @Override
    public Optional<Account> selectById(Account account) {
        Account result = new Account();
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from Account where username = :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", account.getUsername());
                result  = (Account) query.uniqueResult();
                tr.commit();
                session.close();
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public List<Account> selectByCondition(String condition) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from Account where " + condition;
                Query query = session.createQuery(hql);
                accountList = query.getResultList();
                tr.commit();
                session.close();
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return accountList;
    }
}
