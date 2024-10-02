package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IDAO<T>{
    public boolean insert(T t);
    public boolean update(T t);
    public boolean delete(T t);
    public List<T> getAll();
    public Optional<T> selectById(T t);
    public List<T> selectByCondition(String condition);
}
