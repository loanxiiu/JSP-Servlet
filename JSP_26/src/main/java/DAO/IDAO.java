package DAO;

import java.util.ArrayList;

public interface IDAO<T>{
    public void insert(T t);
    public void update(T t);
    public void delete(T t);
    public ArrayList<T> selectAll();
    public T selectById(T t);
    public ArrayList<T> selectByCondition(String condition);
}
