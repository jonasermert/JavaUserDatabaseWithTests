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

        try {
            db.close();
        } catch (SQLException e) {
            System.out.println("Kann Datenbankverbindung nicht beenden");
        }

    }
}
