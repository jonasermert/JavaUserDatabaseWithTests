package de.jonasermert;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> findById(int id);
    List<T> getAll();

    void save(T t) throws SQLException;
    void update(T t);
    void delete(T t);

}
