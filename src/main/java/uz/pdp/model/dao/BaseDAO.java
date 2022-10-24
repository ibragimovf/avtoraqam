package uz.pdp.model.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import uz.pdp.model.DatabaseInit;

import java.util.List;

@Repository
public interface BaseDAO<T> extends DatabaseInit {

    boolean add(T t);

    List<T> getList(String id);

    void delete(String id);

    boolean update(String id, T t);
}
