package de.jonasermert;

import de.jonasermert.User;
import de.jonasermert.UserDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public Optional<User> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void save(User user) {
        var connection = Database.instance().getConnection();

        try {
            var stmt = connection.prepareStatement("");
            stmt.setString(1, user.getName());
            stmt.executeQuery();
            stmt.close();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new DaoException(e);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
