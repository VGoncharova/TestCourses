package atmmock.src.main.java.ru.raiffeisen.cources.atm.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnectionManager implements IConnectionManager {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/atm";
    public static final String USER_NAME = "postgres";
    public static final String USER_PASSWORD = "root";

    private Connection connection;

    public SingleConnectionManager() {
        try {
            this.connection =
                    DriverManager
                            .getConnection(DB_URL,
                                    USER_NAME, USER_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }
}
