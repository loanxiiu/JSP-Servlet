package DAO;

import model.City;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDAO implements IDAO<City> {
    List<City> cities = new ArrayList<>();
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public boolean insert(City city) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.save(city);
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
    public boolean update(City city) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.update(city);
                tr.commit();
                session.close();
            }
        } catch (HibernateException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(City city) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                session.delete(city);
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
    public List<City> getAll() {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from City";
                Query query = session.createQuery(hql);
                cities = query.getResultList();
                tr.commit();
                session.close();
            }
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
        return cities;
    }

    @Override
    public Optional<City> selectById(City city) {
        City result = new City();
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                result = session.get(City.class, city.getIdCity());
                tr.commit();
                session.close();
            }
        } catch (HibernateException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public List<City> selectByCondition(String condition) {
        try {
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                String hql = "from City where " + condition;
                Query query = session.createQuery(hql);
                cities = query.getResultList();
                tr.commit();
                session.close();
            }
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
        return cities;
    }
}
