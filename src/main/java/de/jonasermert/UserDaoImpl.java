package de.jonasermert;

import de.jonasermert.User;
import de.jonasermert.UserDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public Optional<User> findById(int id) {

        var connection = Database.instance().getConnection();

        try {
            var stmt = connection.prepareStatement("SELECT name FROM user WHERE id=?");

            stmt.setInt(1, id);
            var rs = stmt.executeQuery("SELECT id, name FROM user");

            if(rs.next()){
                // var id = rs.getInt("id");
                var name = rs.getInt("id");

                User user = new User(id, name);
                return Optional.of(user);
            }

            stmt.close();

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new DaoException(e);
        }

        return Optional.empty();

    }

    @Override
    public List<User> getAll() {

        List<User> users = new ArrayList<>();

        var connection = Database.instance().getConnection();

        try {
            var stmt = connection.createStatement()
            var rs = stmt.executeQuery(SELECT id, name FROM user);

            while(rs.next()){
                var id = rs.getInt("id");
                var name = rs.getInt("id");

                users.add(new User(id, "Jonas"));
            }

            stmt.close();

        } catch (SQLException e) {
            // e.printStackTrace();
            throw new DaoException(e);
        }

        return users;
    }

    @Override
    public void save(User user) {
        var connection = Database.instance().getConnection();

        try {
            var stmt = connection.prepareStatement("INSERT INTO user (name) VALUES (?)");

            stmt.setString(1, user.getName());
            stmt.executeUpdate();
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

        var connection = Database.instance().getConnection();

        try{
            var stmt = connection.prepareStatement("DELETE FROM user WHERE id=?");
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException  e) {
            throw new DaoException(e);
        }



    }
}
