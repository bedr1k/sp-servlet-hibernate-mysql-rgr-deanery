package rgr.dao;

import java.util.List;

public interface Dao<T>{
    T read(long id);
    List<T> read();
    void save(T entity);
    void delete(T entity);
    void edit(T entity);
}
