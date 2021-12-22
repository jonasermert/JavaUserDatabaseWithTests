package de.jonasermert;

import java.sql.SQLException;

public class App {

    public static void main (String[] args) throws SQLException {

        var db = Database.instance();

        try {
            db.connect();
        } catch (SQLException e) {
            System.out.println("Verbindung herstellen fehlgeschlagen");
        }
        System.out.println("Verbunden");

        UserDao userDao = new UserDaoImpl();
        // userDao.save(new User("Jonas"));

        var users= userDao.getAll();
        users.forEach(System.out::println);

        var userOpt = userDao.findById(1);

        if(userOpt.isPresent()){
            System.out.println("Erhalten:" + userOpt.get());
        } else {
            System.out.println("Keine Einträge gefunden");
        }

        userDao.delete(new User(5, null));

        try {
            db.close();
        } catch (SQLException e) {
            System.out.println("Kann Datenbankverbindung nicht beenden");
        }

    }
}
