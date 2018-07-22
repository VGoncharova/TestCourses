package atmmock.src.ru.raiffeisen.cources.atm.model.db;

import java.sql.Connection;

public interface IConnectionManager {
    Connection getConnection();
}
