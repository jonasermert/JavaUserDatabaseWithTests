package de.jonasermert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database db = new Database();
    private final static String URI = "";
    private Connection connection;

    public static Database instance(){
        return db;
    }

    private Database(){

    }

    public Connection getConnection() {
        return connection;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(URI);
    }

    public void close() throws SQLException {
        connection.close();
    }

}
