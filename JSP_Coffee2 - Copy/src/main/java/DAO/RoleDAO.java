package DAO;

import model.Role;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleDAO implements IDAO<Role>{
    private List<Role> roleList = new ArrayList<Role>();
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public boolean insert(Role role) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.save(role);
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
    public boolean update(Role role) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.update(role);
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
    public boolean delete(Role role) {
        try{
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.delete(role);
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
    public List<Role> getAll() {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from Role";
                Query query = session.createQuery(hql);
                roleList = query.getResultList();
                tr.commit();
                session.close();
            }
            else {
                return null;
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return roleList;
    }

    @Override
    public Optional<Role> selectById(Role role) {
        Role result = new Role();
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                result = session.get(Role.class, role.getIdRole());
                tr.commit();
                session.close();
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public List<Role> selectByCondition(String condition) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from Role where " + condition;
                Query query = session.createQuery(hql);
                roleList = query.getResultList();
                tr.commit();
            }
        }catch(HibernateException e){
            throw new RuntimeException(e);
        }
        return roleList;
    }
}
